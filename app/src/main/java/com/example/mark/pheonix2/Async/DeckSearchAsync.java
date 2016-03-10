package com.example.mark.pheonix2.Async;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.mark.pheonix2.AsyncScroller;
import com.example.mark.pheonix2.NewMainActivity;
import com.example.mark.pheonix2.Scraper.TappedOutScraper;

/**
 * Created by Mark on 2/12/2016.
 */
public class DeckSearchAsync extends AsyncTask<String, Void, Bundle> {
    //TODO: dont foget that AsyncTask (at least with frags, not sure on activity) should be weakly referenced
    Context ctx;
    AsyncScroller scroller;

    public DeckSearchAsync(Context context){
        ctx = context;
        scroller = (AsyncScroller) context;
    }

    @Override
    protected void onPostExecute(Bundle data) {
        scroller.setFragmentData(NewMainActivity.AUTOCOMPLETE_DATA, data);
    }

    @Override
    protected Bundle doInBackground(String... params) {
        TappedOutScraper scraper = new TappedOutScraper(ctx);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ctx);

        //TODO remove log here
        Log.d(NewMainActivity.AppTag, "" + sharedPref.getBoolean("user_name_enabled", false) + sharedPref.getString("user_name_value", "NOUSER"));
        Bundle data = (sharedPref.getBoolean("user_name_enabled", false)) ?
                scraper.getDeckSearchResults(params[0], true, sharedPref.getString("user_name_value", "mikey"))
                : scraper.getDeckSearchResults(params[0]);

        return data;
    }
}
