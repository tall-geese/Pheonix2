package com.example.mark.pheonix2.Util.HTML;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;

import com.example.mark.pheonix2.R;

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

        //TODO: possibly elimintate all of the "large" cases to save time when doing a switch
        switch (source){

            // Zero
            case ("/Handlers/Image.ashx?size=small&name=0&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.zerosymbolsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=0&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.zerosymbolmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=0&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.zerosymbollarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //One
            case ("/Handlers/Image.ashx?size=small&name=1&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.onesmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=1&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.onemedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=1&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.onelarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Two
            case ("/Handlers/Image.ashx?size=small&name=2&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.twosmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=2&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.twomedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=2&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.twolarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Three
            case ("/Handlers/Image.ashx?size=small&name=3&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.threesmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=3&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.threemedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=3&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.threelarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Four
            case ("/Handlers/Image.ashx?size=small&name=4&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.foursmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=4&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.fourmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=4&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.fourlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Five
            case ("/Handlers/Image.ashx?size=small&name=5&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.fivesmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=5&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.fivemedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=5&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.fivelarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Six
            case ("/Handlers/Image.ashx?size=small&name=6&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.sixsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=6&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.sixmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=6&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.sixlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Seven
            case ("/Handlers/Image.ashx?size=small&name=7&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.sevensmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;

            case ("/Handlers/Image.ashx?size=medium&name=7&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.sevenmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;

            case ("/Handlers/Image.ashx?size=large&name=7&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.sevenlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Eight
            case ("/Handlers/Image.ashx?size=small&name=8&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.eightsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=8&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.eightmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=8&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.eightlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Nine
            case ("/Handlers/Image.ashx?size=small&name=9&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.ninesmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=9&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.ninemedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=9&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.ninelarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Ten
            case ("/Handlers/Image.ashx?size=small&name=10&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.tensmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=10&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.tenmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=10&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.tenlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Eleven
            case ("/Handlers/Image.ashx?size=small&name=11&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.elevensmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=11&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.elevenmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=11&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.elevenlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Twelve
            case ("/Handlers/Image.ashx?size=small&name=12&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.twelvesmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=12&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.twelvemedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=12&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.twelvelarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Thirteen
            case ("/Handlers/Image.ashx?size=small&name=13&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.thirteensmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=13&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.thirteenmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=13&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.thirteenlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //fourteen
            case ("/Handlers/Image.ashx?size=small&name=14&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.fourteensmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=14&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.fourteenmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=14&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.fourteenlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Fifteen
            case ("/Handlers/Image.ashx?size=small&name=15&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.fifteensmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=15&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.fifteenmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=15&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.fifteenlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Sixteen
            case ("/Handlers/Image.ashx?size=small&name=16&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.sixteensmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=16&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.sixteenmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=16&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.sixteenlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Seventeen
            case ("/Handlers/Image.ashx?size=small&name=17&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.seventeensmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=17&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.seventeenmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=17&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.seventeenlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Eighteen
            case ("/Handlers/Image.ashx?size=small&name=18&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.eighteensmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=18&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.eighteenmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=18&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.eighteenlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Ninteen
            case ("/Handlers/Image.ashx?size=small&name=19&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.nineteensmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=19&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.nineteenmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=19&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.nineteenlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Twenty
            case ("/Handlers/Image.ashx?size=small&name=20&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.twentysmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=20&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.twentymedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=20&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.twentylarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Plains
            case ("/Handlers/Image.ashx?size=small&name=W&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.plainssmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=W&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.plainsmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=W&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.plainslarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Island
            case ("/Handlers/Image.ashx?size=small&name=U&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.islandsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=U&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.islandmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=U&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.islandlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Swamp
            case ("/Handlers/Image.ashx?size=small&name=B&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.swampsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=B&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.swampmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=B&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.swamplarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Mountain
            case ("/Handlers/Image.ashx?size=small&name=R&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.mountainsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=R&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.mountainmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=R&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.mountainlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Forest
            case ("/Handlers/Image.ashx?size=small&name=G&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.forestsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=G&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.forestmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=G&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.forestlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Snow
            case ("/Handlers/Image.ashx?size=small&name=snow&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.snowsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=snow&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.snowmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=snow&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.snowlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Hybrid Azorius
            case ("/Handlers/Image.ashx?size=small&name=WU&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridazoriussmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=WU&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridazoriusmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=WU&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridazoriuslarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Hybrid Orzhov
            case ("/Handlers/Image.ashx?size=small&name=WB&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridorzhovsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=WB&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridorzhovmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=WB&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridorzhovlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Hybrid Dimir
            case ("/Handlers/Image.ashx?size=small&name=UB&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybriddimirsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=UB&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybriddimirmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=UB&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybriddimirlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Hybrid Izzet
            case ("/Handlers/Image.ashx?size=small&name=UR&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridizzetsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=UR&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridizzetmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=UR&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridizzetlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Hybrid Rakdos
            case ("/Handlers/Image.ashx?size=small&name=BR&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridrakdossmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=BR&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridrakdosmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=BR&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridrakdoslarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Hybrid Golgari
            case ("/Handlers/Image.ashx?size=small&name=BG&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridgolgarismall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=BG&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridgolgarimedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=BG&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridgolgarilarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Hybrid Boros
            case ("/Handlers/Image.ashx?size=small&name=RW&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridborossmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=RW&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridborosmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=RW&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridboroslarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Hybrid Gruul
            case ("/Handlers/Image.ashx?size=small&name=RG&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridgruulsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=RG&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridgruulmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=RG&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridgruullarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Hybrid Selesnya
            case ("/Handlers/Image.ashx?size=small&name=GW&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridselesnyasmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=GW&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridselesnyamedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=GW&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridselesnyalarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Hybrid Simic
            case ("/Handlers/Image.ashx?size=small&name=GU&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridsimicsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=GU&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridsimicmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=GU&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.hybridsimiclarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Mono Hybrid Plains
            case ("/Handlers/Image.ashx?size=small&name=2W&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridplainssmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=2W&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridplainsmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=2W&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridplainslarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Mono Hybrid Island
            case ("/Handlers/Image.ashx?size=small&name=2U&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridislandsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=2U&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridislandmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=2U&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridislandlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Mono Hybrid Swamp
            case ("/Handlers/Image.ashx?size=small&name=2B&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridswampsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=2B&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridswampmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=2B&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridswamplarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Mono Hybrid Mountain
            case ("/Handlers/Image.ashx?size=small&name=2R&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridmountainsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=2R&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridmountainmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=2R&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridmountainlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Mono Hybrid Forest
            case ("/Handlers/Image.ashx?size=small&name=2G&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridforestsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=2G&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridforestmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=2G&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.monohybridforestlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Phyrexian Plains
            case ("/Handlers/Image.ashx?size=small&name=WP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianplainssmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=WP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianplainsmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=WP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianplainslarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Phyrexian Island
            case ("/Handlers/Image.ashx?size=small&name=UP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianislandsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=UP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianislandmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=UP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianislandlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Phyrexian Swamp
            case ("/Handlers/Image.ashx?size=small&name=BP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianswampsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=BP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianswampmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=BP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianswamplarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Phyrexian Mountain
            case ("/Handlers/Image.ashx?size=small&name=RP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianmountainsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=RP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianmountainmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=RP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianmountainlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Phyrexian Forest
            case ("/Handlers/Image.ashx?size=small&name=GP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianforestsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=GP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianforestmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=GP&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.phyrexianforestlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Tap
            case ("/Handlers/Image.ashx?size=small&name=tap&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.tapsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=tap&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.tapmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=tap&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.taplarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Untap
            case ("/Handlers/Image.ashx?size=small&name=untap&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.untapsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=untap&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.untapmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=untap&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.untaplarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Infinity
            case ("/Handlers/Image.ashx?size=small&name=Infinity&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.infinitysmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=Infinity&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.infinitymedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=Infinity&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.infinitylarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Half Plains
            case ("/Handlers/Image.ashx?size=small&name=500&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.halfplainssmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=500&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.halfplainsmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=500&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.halfplainslarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Half Mountain
            case ("/Handlers/Image.ashx?size=small&name=HalfR&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.halfmountainsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=HalfR&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.halfmountainmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=HalfR&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.halfmountainlarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //One Hundred
            case ("/Handlers/Image.ashx?size=small&name=100&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.onehundredsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //One Million
            case ("/Handlers/Image.ashx?size=medium&name=1000000&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.onemillionmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //X
            case ("/Handlers/Image.ashx?size=small&name=X&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.xsymbolsmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=X&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.xsymbolmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=large&name=X&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.xsymbollarge);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            //Colorless
            case ("/Handlers/Image.ashx?size=small&name=C&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.colorlesssmall);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            case ("/Handlers/Image.ashx?size=medium&name=C&type=symbol"):
                drawable = context.getResources().getDrawable(R.drawable.colorlessmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
//            case ("/Handlers/Image.ashx?size=large&name=C&type=symbol"):
//                drawable = context.getResources().getDrawable(R.drawable.colorlesslarge);
//                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
//                return drawable;





            //Unknown
            default: drawable = (Drawable) context.getResources().getDrawable(R.drawable.unknownmedium);
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                break;
        }


        return drawable;
    }
}
