package com.example.mark.pheonix2;

import android.text.Editable;
import android.text.Html;

import org.xml.sax.XMLReader;

/**
 * Created by Mark on 1/10/2016.
 */
public class TagGetter implements Html.TagHandler{
    //TODO: see if there is a way to either make this class useful or eliminate it altogether

    @Override
    public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {

    }
}
