package com.example.mark.pheonix2.Async;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.mark.pheonix2.AsyncScroller;
import com.example.mark.pheonix2.CardValuesFragment;
import com.example.mark.pheonix2.Scraper.GathererWebScraper;
import com.example.mark.pheonix2.NewMainActivity;

/**
 * Created by Mark on 2/11/2016.
 */
public class GathererAsync extends AsyncTask<String, Void, Bundle> {
    //TODO: dont foget that AsyncTask (at least with frags, not sure on activity) should be weakly referenced
    private CardValuesFragment cvFragment;
    private Context ctx;
    private AsyncScroller scroller;

    public GathererAsync(Context context, CardValuesFragment fragment){
        cvFragment = fragment;
        ctx = context;
        scroller = (AsyncScroller) context;
    }

    @Override
    protected void onPreExecute() {
        scroller.handleScroll(NewMainActivity.VALUES_FRAG);
        // Todo: add code here for testing an internet connection
    }

    @Override
    protected void onPostExecute(Bundle cardBundle) {
        scroller.setFragmentData(NewMainActivity.CARD_DATA,cardBundle);
    }

    @Override
    protected Bundle doInBackground(String... params) {
        GathererWebScraper scraper = new GathererWebScraper(params[0], ctx);

        Bundle cardBundle = new Bundle();

        cardBundle.putString(CardValuesFragment.CV_NAME, scraper.getcardName());
        cardBundle.putString(CardValuesFragment.CV_TYPE, scraper.getCardTypes());
        cardBundle.putString(CardValuesFragment.CV_CMC, scraper.getCardCMC());
        cardBundle.putStringArrayList(CardValuesFragment.CV_FLAVOR, scraper.getCardFlavor());
        cardBundle.putStringArrayList(CardValuesFragment.CV_CARD_TEXT, scraper.getCardTextArray());

        return cardBundle;

    }
}
