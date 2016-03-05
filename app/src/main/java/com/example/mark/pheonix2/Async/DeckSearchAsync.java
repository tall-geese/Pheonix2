package com.example.mark.pheonix2.Async;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.mark.pheonix2.AsyncScroller;
import com.example.mark.pheonix2.DeckSearchFragment;
import com.example.mark.pheonix2.NewMainActivity;
import com.example.mark.pheonix2.Scraper.TappedOutScraper;

import java.util.ArrayList;
import java.util.List;

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
        Bundle data = (DeckSearchFragment.USER_DEFINED) ?
                scraper.getDeckSearchResults(params[0], DeckSearchFragment.USER_DEFINED, DeckSearchFragment.USER_NAME)
                : scraper.getDeckSearchResults(params[0]);

        return data;
    }
}
