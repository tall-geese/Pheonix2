package com.example.mark.pheonix2.Domain;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.mark.pheonix2.Util.Interfaces.AsyncScroller;
import com.example.mark.pheonix2.Presentation.NewMainActivityFragments.CardValuesFragment;
import com.example.mark.pheonix2.Data.GathererWebScraper;
import com.example.mark.pheonix2.Presentation.NewMainActivity;

/**
 * Created by Mark on 2/11/2016.
 */
public class GathererAsync extends AsyncTask<String, Void, Bundle> {
    //TODO: dont foget that AsyncTask (at least with frags, not sure on activity) should be weakly referenced
    private Context ctx;
    private AsyncScroller scroller;

    public GathererAsync(Context context){
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

        //TODO: come up with consistency here, shouldnt need 5 methods for that class for public use
        cardBundle.putString(CardValuesFragment.CV_NAME, scraper.getcardName());
        cardBundle.putString(CardValuesFragment.CV_TYPE, scraper.getCardTypes());
        cardBundle.putString(CardValuesFragment.CV_CMC, scraper.getCardCMC());
        cardBundle.putStringArrayList(CardValuesFragment.CV_FLAVOR, scraper.getCardFlavor());
        cardBundle.putStringArrayList(CardValuesFragment.CV_CARD_TEXT, scraper.getCardTextArray());

        return cardBundle;

    }
}
