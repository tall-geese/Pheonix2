package com.example.mark.pheonix2.Domain;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.mark.pheonix2.Util.Interfaces.AsyncScroller;
import com.example.mark.pheonix2.Presentation.NewMainActivity;
import com.example.mark.pheonix2.Data.TappedOutScraper;

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
        Bundle data = new TappedOutScraper(ctx).getDeckCategories(params[0]);
        return data;
    }
}
