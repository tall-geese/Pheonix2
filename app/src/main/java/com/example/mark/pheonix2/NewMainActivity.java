package com.example.mark.pheonix2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import io.karim.MaterialTabs;

/**
 * Created by Mark on 1/26/2016.
 */
public class NewMainActivity extends AppCompatActivity{
    private ScreenSlidePagerAdapter mAdapter;
    private static final int NUM_PAGES = 3;
    private static final int SEARCH_FRAG = 0;
    private static final int VALUES_FRAG = 1;

    private static final String AppTag = "AppTag";

    private ViewPager mPager;
    private MaterialTabs mTabs;
    private CardValuesFragment cvFragment;
    private CardSearchFragment csFragment;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // material Tabs setup
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager()));
        mTabs = (MaterialTabs) findViewById(R.id.materialTabs);
        mTabs.setViewPager(mPager);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new CardSearchListener());
    }


    private class CardSearchListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            // TODO: should this be less complicated? use global variable?
                //code here to check viabilit of edit text entry
                new JSoupAsync().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, csFragment.getMultiverseID());
        }
    }
    private class JSoupAsync extends AsyncTask<String, Void, Bundle> {

        @Override
        protected void onPreExecute() {
            mPager.setCurrentItem(VALUES_FRAG, true);
            super.onPreExecute();
            // Todo: add code here for testing an internet connection
        }

        @Override
        protected void onPostExecute(Bundle cardBundle) {
            //TODO: dismiss a loadingbar here
            cvFragment.setValues(cardBundle);
        }

        @Override
        protected Bundle doInBackground(String... params) {
            CardWebScraper scraper = new CardWebScraper(params[0], NewMainActivity.this);

            Bundle cardBundle = new Bundle();

            cardBundle.putString("name", scraper.getcardName());
            cardBundle.putString("types", scraper.getCardTypes());
            cardBundle.putString("flavor", scraper.getCardFlavor());
            cardBundle.putString("CMC", scraper.getCardCMC());
            cardBundle.putStringArrayList("arrayList", scraper.getCardTextArray());

            return cardBundle;

        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{

        private final String[] tabTitles = {"One", "Two", "Three", "Four", "Five", "Six", "Seven"};

        public ScreenSlidePagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case SEARCH_FRAG:
                    csFragment = (csFragment != null) ? csFragment : new CardSearchFragment();
                    return csFragment;
//                    return (csFragment != null) ? csFragment = new CardSearchFragment() : csFragment;
                case VALUES_FRAG:
                    cvFragment = (cvFragment != null) ? cvFragment : new CardValuesFragment();
                    return cvFragment;
//                    return (cvFragment != null) ? cvFragment = new CardValuesFragment() : cvFragment;
                default:
                    return new CardSearchFragment();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        // we can override this method if we want to set back the page instead
        // of closing the activity altogether
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
