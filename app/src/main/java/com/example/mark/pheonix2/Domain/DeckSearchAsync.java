package com.example.mark.pheonix2.Domain;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.example.mark.pheonix2.Util.Interfaces.AsyncScroller;
import com.example.mark.pheonix2.Presentation.NewMainActivity;
import com.example.mark.pheonix2.R;
import com.example.mark.pheonix2.Data.TappedOutScraper;

/**
 * Created by Mark on 2/12/2016.
 */
public class DeckSearchAsync extends AsyncTask<String, Void, Bundle> {
    //TODO: dont foget that AsyncTask (at least with frags, not sure on activity) should be weakly referenced
    Context ctx;
    AsyncScroller scroller;
    Resources res;

    public DeckSearchAsync(Context context){
        ctx = context;
        scroller = (AsyncScroller) context;
        res = context.getResources();
    }

    @Override
    protected void onPostExecute(Bundle data) {
        scroller.setFragmentData(NewMainActivity.AUTOCOMPLETE_DATA, data);
    }

    @Override
    protected Bundle doInBackground(String... params) {
        TappedOutScraper scraper = new TappedOutScraper(ctx);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ctx);

        Bundle data = (sharedPref.getBoolean(res.getString(R.string.user_name_enabled), false)) ?
                //TODO: replace "mikey" with something that makes more sense
                scraper.getDeckSearchResults(params[0], true, sharedPref.getString(res.getString(R.string.user_name), "mikey"))
                : scraper.getDeckSearchResults(params[0]);

        return data;
    }
}
