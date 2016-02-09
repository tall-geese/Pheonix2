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

    public ArrayList<Element> getDeckSearchResults(ArrayList<String> searchQuery){
        //TODO: replace arraylist searchquery with array instead, get rid of conc. for loop, replace with stringBuilder
        ArrayList<Element> arrayList = new ArrayList<>();

        String urlLeading = ctx.getResources().getString(R.string.tappedoutNoUserURLQueryLeading);
        String urlTrailing = ctx.getResources().getString(R.string.tappedoutNoUserURLQueryTrailing);

        for (int i = 0; i < searchQuery.size(); i++){
            urlLeading += searchQuery.get(i);
            if (i + 1 != searchQuery.size())
                urlLeading += "+";
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
        // check for the userDefinedFlag == true
        // this will handle differently from the sister method, we are scraping decks from the user web page
        // but we will also need to sort the list and return results that best matches to the searchQuery

        ArrayList<Element> arrayList = new ArrayList<>();

        try{
            Document doc = Jsoup.connect("http://tappedout.net/users/" + userName).get();
            Elements elements = doc.select("h4.name name-long > a[title]");
            for(Element e : elements){
                for(String s : e.text().split(" ")){
                    for(String q : splitSearchQuery){
                        Levenshtein l = new Levenshtein();
                        double distance = (s.length() < q.length()) ?
                                l.distance(s, q.substring(0, s.length()-1)) :
                                l.distance(q, s.substring(0, q.length()-1));
                        if (distance < 2)
                            arrayList.add(e); //then do something to move onto the next element
                        // or maybe check to see  if the arrayList already has that element in it //
                    }
                }
            }
            //return the arrayList here, maybe return empty one if we cant find a better soltion to that

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
