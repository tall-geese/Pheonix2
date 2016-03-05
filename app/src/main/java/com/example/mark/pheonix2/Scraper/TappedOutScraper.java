package com.example.mark.pheonix2.Scraper;

import android.content.Context;
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
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Mark on 2/7/2016.
 */
public class TappedOutScraper {
    private Context ctx;

    public TappedOutScraper(Context context) {
        ctx = context;
    }

    public Bundle getDeckSearchResults(String searchQuery){
        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<String> urlList = new ArrayList<>();
        Bundle data = new Bundle();

        //TODO: test network connection

        try{
            OkHttpClient client = new OkHttpClient();
            client.followRedirects();
            RequestBody body = new FormBody.Builder()
                    .add("q", searchQuery)
                    .add("format", "edh")
                    .add("cards", "")
                    .add("general", "")
                    .add("price_0", "")
                    .add("price_1", "")
                    .add("o", "date_updated")
                    .add("d", "desc")
                    .add("submit", "Filter results")
                    .build();


            Request request = new Request.Builder().url("http://tappedout.net/mtg-decks/search/").post(body).build();
            Response response = client.newCall(request).execute();


            Document doc = Jsoup.parse(response.body().string());
            Elements elements = doc.select("h3.name > a[href]");

            //TODO: magic number here
            for(int i = 0; i < elements.size() && i < 6; i++){
                nameList.add(elements.get(i).text());
                urlList.add(elements.get(i).attr("abs:href"));
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
                        .url("http://tappedout.net/users/" + userName + "/mtg-decks/")
                        .build();
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {

                    Document doc = Jsoup.parse(response.body().string());
                    Elements elements = doc.select("h4.name name-long > a[title]");
                    // compare each word in the deck name to each word in the search query
                    // and if we find that they'll similar enough, add that wrapping element to arrayList to return
                    for (Element e : elements) {
                        for (String s : e.text().split(" ")) {
                            for (String q : splitSearchQuery) {
                                Levenshtein l = new Levenshtein();
                                double distance = (s.length() < q.length()) ?
                                        l.distance(s, q.substring(0, s.length() - 1)) :
                                        l.distance(q, s.substring(0, q.length() - 1));
                                //TODO: define our magic number of results to return, currently just saying "4"
                                if (distance < 2 && !nameList.contains(e.text()) && nameList.size() < 4) {
                                    nameList.add(e.text());
                                    urlList.add(e.attr("abs:href"));
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
            Elements elements = doc.select(".board-col.col-md-4.col-sm-6 > h3[style]");
            for (Element e : elements){
                list.add(e.text());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return list;
    }
}
