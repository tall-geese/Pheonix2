package com.example.mark.pheonix2.Data;

/**
 * Created by Mark on 12/31/2015.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.mark.pheonix2.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;


public class GathererWebScraper {
    /*
     * eventually we will have to redo this class so that is can scrape gatherer
     * based off of a name and not a multiverseID
     */

    Document document;
    Context context;
    String gathererURL;
    //TODO: replace this concatenation with StringBuilder
    String collectiveNodesString;
    private String AppTag = "AppTag";

    private String cardNameQuery;
    private String cardName;
    private String cardTypesQuery;
    private String cardTypes;
    private String cardFlavorQuery;
    private ArrayList<String> cardFlavor;
    private String cardTextQuery;
    private String cardCMCQuery;


    public GathererWebScraper(String multiverseID, Context ctx){
        // call init methods on ctx so unit test doesn't break
        //TODO: runtime permissions for calling wizards of the coast
        context = ctx;
        collectiveNodesString = "";

        gathererURL = (String) ctx.getResources().getString(R.string.url) + multiverseID;
        cardNameQuery = (String) ctx.getResources().getString(R.string.cardNameQuery);
        cardTypesQuery = (String) ctx.getResources().getString(R.string.cardTypesQuery);
        cardFlavorQuery = (String) ctx.getResources().getString(R.string.cardFlavorQuery);
        cardTextQuery = (String) ctx.getResources().getString(R.string.cardTextQuery);
        cardCMCQuery = (String) ctx.getResources().getString(R.string.cardCMCQuery);

        if (GathererWebScraper.isConnectedToNetwork(ctx)) {

            try {
                document = Jsoup.connect(gathererURL).get();
                setcardName();
                setCardTypes();
                setCardFlavor();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            GathererWebScraper.toastErrorLog(ctx, ctx.getResources().getString(R.string.networkConnectionFailed));
        }
    }

    public void setcardName(){
        Elements elements = document.select(cardNameQuery);
        String elementText = elements.text();
        cardName = elementText;
    }

    public String getcardName(){
        return cardName;
    }

    public void setCardTypes(){
        Elements elements = document.select(cardTypesQuery);
        String elementText = elements.text();
        cardTypes = elementText;
    }

    public String getCardTypes(){
        return cardTypes;
    }

    public void setCardFlavor(){
        //TODO: cards that have broken up flavor text, will this still work?
        cardFlavor = new ArrayList<>();
        Elements elements = document.select(cardFlavorQuery);
        for (Element e: elements){
            cardFlavor.add(e.text());
        }
    }

    public ArrayList<String> getCardFlavor(){
        return cardFlavor;
    }

    public ArrayList<String> getCardTextArray(){

        collectiveNodesString = "";
        ArrayList<String> cardTextList = new ArrayList<>();
        Elements elements = document.select(cardTextQuery);

        for (Element element : elements){
            if(element.hasText() && element.childNodeSize() == 1){
                cardTextList.add(element.text());
            }
            else{
                nodeIterator(element);
                cardTextList.add(collectiveNodesString);

                collectiveNodesString = "";
            }
        }

        return cardTextList;
    }

    public String getCardCMC(){
        collectiveNodesString = "";
        Element element = document.select(cardCMCQuery).first();
        nodeIterator(element);
        return collectiveNodesString;
    }

    private void nodeIterator (Node node){
        if(node.childNodeSize() > 0){
            for(int i = 0; i< node.childNodeSize(); i++){
                nodeIterator(node.childNode(i));
            }
        }
        else if(!node.toString().equals("")) {
            collectiveNodesString += node.toString();
        }
    }

    public static boolean isConnectedToNetwork(Context ctx){

        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    public static void toastErrorLog(Context ctx, String errorMsg){
        Toast.makeText(ctx, errorMsg, Toast.LENGTH_LONG).show();
    }
}
