package com.example.mark.pheonix2.Presentation;

import android.support.v4.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mark.pheonix2.Presentation.Dialogs.DeckSearchDialog;
import com.example.mark.pheonix2.Presentation.NewMainActivityFragments.CardValuesFragment;
import com.example.mark.pheonix2.Presentation.NewMainActivityFragments.DeckListFragment;
import com.example.mark.pheonix2.Presentation.NewMainActivityFragments.DeckSearchFragment;
import com.example.mark.pheonix2.R;
import com.example.mark.pheonix2.Util.Interfaces.AsyncScroller;

import io.karim.MaterialTabs;

/**
 * Created by Mark on 1/26/2016.
 */
public class NewMainActivity extends AppCompatActivity implements AsyncScroller {
    public static final int NUM_PAGES = 3;

    public static final int SEARCH_FRAG = 0;
    public static final int DECKLIST_FRAG = 1;
    public static final int VALUES_FRAG = 2;

    public static final int AUTOCOMPLETE_DATA = 100, DECKS_DATA = 200, DECKLIST_DATA = 300, CARD_DATA = 400;

    private CardValuesFragment cvFragment;
    private DeckSearchFragment dsFragment;
    private DeckListFragment dlFragment;

    private FloatingActionButton fab;
    private ViewPager mPager;
    private MaterialTabs mTabs;

    public static final String AppTag = "AppTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // material Tabs setup
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new ScreenSlidePagerAdapter(getSupportFragmentManager()));
        mTabs = (MaterialTabs) findViewById(R.id.materialTabs);
        mTabs.setViewPager(mPager);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: test small screen, large screen aspects, maybe we can work this in with varialbes from the builds / flavors
                Log.d(NewMainActivity.AppTag, "here in fab listener");
                DeckSearchDialog dialog = new DeckSearchDialog();
                FragmentManager fm = getSupportFragmentManager();

                Log.d(NewMainActivity.AppTag, "after initializeing class");

                if ((getResources().getConfiguration().screenLayout &
                        Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE){
                    Log.d(NewMainActivity.AppTag, "in the if()");
                    //make it a dialog (.show)
                    dialog.show(fm, "dialog");
                }
                else{
                    // make it fullscreen
                    Log.d(NewMainActivity.AppTag, "in the else()");
                    FragmentTransaction transaction = fm.beginTransaction();
                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    transaction.add(android.R.id.content, dialog);
                    transaction.addToBackStack(null).commit();

                }
            }
        });
    }

    @Override
    public void handleScroll(int posistion){
        mPager.setCurrentItem(posistion);
    }

    @Override
    public void setFragmentData(int what, Bundle data){
        switch (what){
            case NewMainActivity.AUTOCOMPLETE_DATA:
                DeckSearchFragment.AutoCompleteAdapter autoAdapter =
                        (DeckSearchFragment.AutoCompleteAdapter) dsFragment.autoView.getAdapter();
                autoAdapter.setSearchResults(data);
                break;

            case NewMainActivity.DECKS_DATA:
                //TODO: fill this in with dsFragment as we handle filling out our list of decks or with deck search dialog

            case NewMainActivity.DECKLIST_DATA:
                DeckListFragment.DeckListAdapter dlAdapter =
                        (DeckListFragment.DeckListAdapter) dlFragment.listView.getAdapter();
                dlAdapter.setDeckList(data);
                break;

            case NewMainActivity.CARD_DATA:
                cvFragment.setValues(data);
                break;

            default:
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
            return NewMainActivity.NUM_PAGES;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case NewMainActivity.SEARCH_FRAG:
                    dsFragment = (dsFragment != null) ? dsFragment : new DeckSearchFragment();
                    return dsFragment;
                case NewMainActivity.DECKLIST_FRAG:
                    dlFragment = (dlFragment != null) ? dlFragment : new DeckListFragment();
                    return dlFragment;

                case NewMainActivity.VALUES_FRAG:
                    cvFragment = (cvFragment != null) ? cvFragment : new CardValuesFragment();
                    return cvFragment;
                default:
                    // TODO: get something better here when hitting the default
                    return new DeckSearchFragment();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        //TODO: we can override this method if we want to set back the page instead
        // of closing the activity altogether
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent();
            ComponentName cn = new ComponentName(NewMainActivity.this, UserSettingsActivity.class);
            intent.setComponent(cn);
            startActivity(intent);
            Log.d(NewMainActivity.AppTag, "made it to here");

            return true;
        }
        else{
            return super.onOptionsItemSelected(item);
        }
    }
}
