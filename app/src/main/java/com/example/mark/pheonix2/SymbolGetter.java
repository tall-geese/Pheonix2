package com.example.mark.pheonix2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.Log;

/**
 * Created by Mark on 1/10/2016.
 */
public class SymbolGetter implements Html.ImageGetter {
    private Context context;
    private String AppTag = "AppTag";

    public SymbolGetter(Context mContext){
        context = mContext;
    }

    @Override
    public Drawable getDrawable(String source) {
        Drawable drawable;

        //TODO: replace our raster images with vector ones, and have a case for each possible image
        switch (source){
            case ("/Handlers/Image.ashx?size=medium&name=2&type=symbol"):
                drawable = (Drawable) context.getResources().getDrawable(R.drawable.twomed);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                break;
            case ("/Handlers/Image.ashx?size=medium&name=G&type=symbol"):
                drawable = (Drawable) context.getResources().getDrawable(R.drawable.forestmed);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                break;
            case ("/Handlers/Image.ashx?size=medium&name=W&type=symbol"):
                drawable = (Drawable) context.getResources().getDrawable(R.drawable.plainsmed);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                break;
            case ("/Handlers/Image.ashx?size=medium&name=U&type=symbol"):
                drawable = (Drawable) context.getResources().getDrawable(R.drawable.islandmed);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                break;
            case ("/Handlers/Image.ashx?size=small&name=2&type=symbol"):
                drawable = (Drawable) context.getResources().getDrawable(R.drawable.twosmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                break;
            case ("/Handlers/Image.ashx?size=small&name=tap&type=symbol"):
                drawable = (Drawable) context.getResources().getDrawable(R.drawable.tapsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                break;
            default: drawable = (Drawable) context.getResources().getDrawable(R.drawable.twomed);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                break;
        }


        return drawable;
    }
}
