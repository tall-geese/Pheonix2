package com.example.mark.pheonix2;

/**
 * Created by Mark on 12/31/2015.
 */

import android.app.ActionBar;
import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CardWebScraper {

    Document document;
    Context context;
    String gathererURL;
    String collectiveNodesString;
    private String AppTag = "AppTag";

    private String cardNameQuery;
    private String cardName;
    private String cardTypesQuery;
    private String cardTypes;
    private String cardFlavorQuery;
    private String cardFlavor;
    private String cardTextQuery;
    private String cardCMCQuery;


    public CardWebScraper(String multiverseID, Context ctx){
        collectiveNodesString = "";
        context = ctx;

        gathererURL = (String) context.getResources().getString(R.string.url) + multiverseID;
        cardNameQuery = (String) context.getResources().getString(R.string.cardNameQuery);
        cardTypesQuery = (String) context.getResources().getString(R.string.cardTypesQuery);
        cardFlavorQuery = (String) context.getResources().getString(R.string.cardFlavorQuery);
        cardTextQuery = (String) context.getResources().getString(R.string.cardTextQuery);
        cardCMCQuery = (String) context.getResources().getString(R.string.cardCMCQuery);

        try {
            document = Jsoup.connect(gathererURL).get();
            setcardName();;
            setCardTypes();
            setCardFlavor();
        } catch (IOException e){
            e.printStackTrace();
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
        Elements elements = document.select(cardFlavorQuery);
        String elementText = elements.text();
        cardFlavor = elementText;
    }

    public String getCardFlavor(){
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
}