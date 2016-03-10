package com.example.mark.pheonix2.Async;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.mark.pheonix2.AsyncScroller;
import com.example.mark.pheonix2.DeckListFragment;
import com.example.mark.pheonix2.NewMainActivity;
import com.example.mark.pheonix2.Scraper.TappedOutScraper;

import java.util.ArrayList;

/**
 * Created by Mark on 2/13/2016.
 */
public class DeckListAsync extends AsyncTask<String, Void, Bundle>{
    private Context ctx;
    private AsyncScroller scroller;

    public DeckListAsync(Context context) {
        ctx = context;
        scroller = (AsyncScroller) context;
    }

    @Override
    protected void onPreExecute() {
        scroller.handleScroll(NewMainActivity.DECKLIST_FRAG);
    }

    @Override
    protected void onPostExecute(Bundle data) {
        scroller.setFragmentData(NewMainActivity.DECKLIST_DATA, data);
    }

    @Override
    protected Bundle doInBackground(String... params) {
        ArrayList<String> list = new TappedOutScraper(ctx).getDeckCategories(params[0]);
        Bundle data = new Bundle();

        data.putStringArrayList(DeckListFragment.DL_CATEGORIES, list);
        return data;
    }
}
