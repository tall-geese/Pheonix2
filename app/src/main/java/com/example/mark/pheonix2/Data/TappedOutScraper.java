package com.example.mark.pheonix2.Data;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import com.example.mark.pheonix2.Presentation.NewMainActivityFragments.DeckSearchFragment;
import com.example.mark.pheonix2.Presentation.NewMainActivity;
import com.example.mark.pheonix2.R;
import com.example.mark.pheonix2.Util.Models.DeckListModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import info.debatty.java.stringsimilarity.NormalizedLevenshtein;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Mark on 2/7/2016.
 */
public class TappedOutScraper {
    private Context ctx;
    private Resources res;

    public TappedOutScraper(Context context) {
        ctx = context;
        res = context.getResources();
    }

    public Bundle getDeckSearchResults(String searchQuery){
        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<String> urlList = new ArrayList<>();
        Bundle data = new Bundle();

        //TODO: test network connection - change this, shouldnt be present only in methods, should be in
        // constructor like for gathererwebscraper here

        try{
            OkHttpClient client = new OkHttpClient();
            client.followRedirects();
            Request request = new Request.Builder()
                    .url(res.getString(R.string.tappedoutNoUser_urlLeading) + searchQuery + res.getString(R.string.tappedoutNoUser_urlTrailing))
                    .build();

            Response response = client.newCall(request).execute();

            Document doc = Jsoup.parse(response.body().string());
            Elements elements = doc.select(res.getString(R.string.deckNames_NoUser));

            //TODO: magic number here
            for(int i = 0; i < elements.size() && i < 6; i++){
                elements.get(i).setBaseUri(res.getString(R.string.tappedoutURI));
                nameList.add(elements.get(i).text());
                urlList.add(elements.get(i).absUrl("href"));
            }

            data.putStringArrayList(DeckSearchFragment.DS_NAME, nameList);
            data.putStringArrayList(DeckSearchFragment.DS_URL, urlList);

            return data;

        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }

    public Bundle getDeckSearchResults(String searchQuery, boolean userDefinedFlag, String userName){

        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<String> urlList = new ArrayList<>();
        Bundle data = new Bundle();
        String[] splitSearchQuery = searchQuery.split(" ");

        if(userDefinedFlag == true && GathererWebScraper.isConnectedToNetwork(ctx)) {

            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(res.getString(R.string.tappedoutUser_urlLeading) + userName + res.getString(R.string.tappedoutUser_urlTrailing))
                        .build();
                Response response = client.newCall(request).execute();
                //TODO: why do we check the status of the response here and not elsewhere
                if (response.isSuccessful()) {
                    //TODO erase logs here
                    Log.d(NewMainActivity.AppTag, response.toString());

                    Document doc = Jsoup.parse(response.body().string());
                    Elements elements = doc.select(res.getString(R.string.deckNames_withUser));
                    // compare each word in the deck name to each word in the search query
                    // and if we find that they'll similar enough, add that wrapping element to arrayList to return
                    for (Element e : elements) {
                        for (String s : e.text().split(" ")) {
                            for (String q : splitSearchQuery) {
                                NormalizedLevenshtein l = new NormalizedLevenshtein();
                                double distance = l.distance(s.toUpperCase(), q.toUpperCase());
                                //TODO: define our magic number of results to return, currently just saying "4"
                                if (distance <= 0.5 && !nameList.contains(e.text()) && nameList.size() < 4) {
                                    e.setBaseUri(res.getString(R.string.tappedoutURI) + "/" + userName + "/");
                                    nameList.add(e.text());
                                    urlList.add(e.attr(res.getString(R.string.absolute_url)));
                                }
                            }
                        }
                    }
                    data.putStringArrayList(DeckSearchFragment.DS_NAME, nameList);
                    data.putStringArrayList(DeckSearchFragment.DS_URL, urlList);
                    return data;
                }
                else{
                    //TODO: put log here when testing succesful / unsucceful connections
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //TODO: how to handle what happens when user isnt defined or when connection not successful, dont let it crash here
        return  data;
    }

    public Bundle getDeckCategories (String s){
        //TODO: clean up this method, too many commented out pieces of earlier build
        Bundle returnBundle = new Bundle();
        ArrayList<DeckListModel> modelList = new ArrayList<>();

        try{
            Document doc = Jsoup.connect(s).get();

            // scrape the list of cards belonging to each category
            Elements cardElements = doc.select(ctx.getResources().getString(R.string.deck_category_cards));
            String cardNameAttr = ctx.getResources().getString(R.string.card_name_attr);


            for (Element e : cardElements){
                if(e.hasText()){
                    //get category header
                    String categoryHeader = e.previousElementSibling().text();
                    Elements f = e.children();
                    // get all the childen elements which are the indvidual cards in this category
                    for(int i = 0; i < f.size(); i++){
                        DeckListModel model = new DeckListModel();
                        model.setParentCatgeroy(categoryHeader);
                        model.setName(f.get(i).getElementsByAttribute(cardNameAttr).attr(cardNameAttr));

                        // if this is the first card, set it as the category header
                        if(i == 0) {
                            model.setIsCategoryHeader(1);
                        }
                        modelList.add(model);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        returnBundle.putParcelableArrayList(ctx.getResources().getString(R.string.model_key), modelList);
        return returnBundle;
    }
}
