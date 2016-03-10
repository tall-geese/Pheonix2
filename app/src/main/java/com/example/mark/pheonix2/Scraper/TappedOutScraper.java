package com.example.mark.pheonix2.Scraper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import com.example.mark.pheonix2.DeckSearchFragment;
import com.example.mark.pheonix2.NewMainActivity;
import com.example.mark.pheonix2.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import info.debatty.java.stringsimilarity.Levenshtein;
import info.debatty.java.stringsimilarity.NormalizedLevenshtein;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

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

        // comment here for testing push

        //TODO: test network connection

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
        return  data;
    }

    public ArrayList<String> getDeckCategories (String s){
        ArrayList<String> list = new ArrayList<>();

        try{
            Document doc = Jsoup.connect(s).get();
            Elements elements = doc.select(res.getString(R.string.deck_categories));
            for (Element e : elements){
                list.add(e.text());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return list;
    }
}
