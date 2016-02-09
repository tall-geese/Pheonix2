package com.example.mark.pheonix2;

import android.content.Context;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import info.debatty.java.stringsimilarity.Levenshtein;

/**
 * Created by Mark on 2/7/2016.
 */
public class TappedOutScraper {
    private Document doc;
    private String user;
    private Context ctx;



    TappedOutScraper(Context context) {
        ctx = context;
    }

    public ArrayList<Element> getDeckSearchResults(String[] searchQuery){
        StringBuilder builder = new StringBuilder();
        ArrayList<Element> arrayList = new ArrayList<>();

        String urlLeading = ctx.getResources().getString(R.string.tappedoutNoUserURLQueryLeading);
        String urlTrailing = ctx.getResources().getString(R.string.tappedoutNoUserURLQueryTrailing);

        for (int i = 0; i < searchQuery.length; i++){
            builder.append(searchQuery[i]);
            if (i + 1 != searchQuery.length)
                builder.append("+");
        }
        try{
            Document doc = Jsoup.connect(urlLeading + urlTrailing).get();
            Elements elements = doc.select("h3.name > a[href]");
            // TODO: replace magic number 4 with static value, this is the arbitrary number of results we want to return
            for(int i = 0; i < 4; i++){
                arrayList.add(elements.get(i));
            }
            return arrayList;

        }catch (IOException e){
            e.printStackTrace();
        }
        return new ArrayList<Element>();
    }

    public ArrayList<Element> getDeckSearchResults(String[] splitSearchQuery, boolean userDefinedFlag, String userName){

        ArrayList<Element> arrayList = new ArrayList<>();

        if(userDefinedFlag == true && CardWebScraper.isConnectedToNetwork(ctx)) {

            try {
                Document doc = Jsoup.connect("http://tappedout.net/users/" + userName).get();
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
                            if (distance < 2 && !arrayList.contains(e))
                                arrayList.add(e);
                            //TODO: do something here with that magic number arbitraty number of results we want to return
                        }
                    }
                }
                return arrayList;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  arrayList;
    }
}
