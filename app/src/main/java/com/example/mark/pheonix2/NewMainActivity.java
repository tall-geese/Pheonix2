package com.example.mark.pheonix2;

import android.content.ComponentName;
import android.content.Intent;
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

import com.example.mark.pheonix2.Util.UserSettingsActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

import io.karim.MaterialTabs;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Mark on 1/26/2016.
 */
public class NewMainActivity extends AppCompatActivity implements AsyncScroller{
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
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                Log.d(NewMainActivity.AppTag, "inside thread");
                                String html = "empty";
                                OkHttpClient client = new OkHttpClient();

                                RequestBody formBody = new FormBody.Builder()
                                        .add("__LASTFOCUS", "")
                                        .add("__VIEWSTATE", "/wEPDwUIMzAxMzk2ODBkGAEFHl9fQ29udHJvbHNSZXF1aXJlUG9zdEJhY2tLZXlfXxYMBUFjdGwwMCRjdGwwMCRNYWluQ29udGVudCRDb250ZW50JFNlYXJjaENvbnRyb2xzJFNlYXJjaFNwZWNpYWxJdGVtcwU9Y3RsMDAkY3RsMDAkTWFpbkNvbnRlbnQkQ29udGVudCRTZWFyY2hDb250cm9scyRTZWFyY2hDYXJkTmFtZQU+Y3RsMDAkY3RsMDAkTWFpbkNvbnRlbnQkQ29udGVudCRTZWFyY2hDb250cm9scyRTZWFyY2hDYXJkVHlwZXMFPWN0bDAwJGN0bDAwJE1haW5Db250ZW50JENvbnRlbnQkU2VhcmNoQ29udHJvbHMkU2VhcmNoQ2FyZFRleHQFOmN0bDAwJGN0bDAwJE1haW5Db250ZW50JENvbnRlbnQkU2VhcmNoQ29udHJvbHMkU2VhcmNoV2hpdGUFOWN0bDAwJGN0bDAwJE1haW5Db250ZW50JENvbnRlbnQkU2VhcmNoQ29udHJvbHMkU2VhcmNoQmx1ZQU6Y3RsMDAkY3RsMDAkTWFpbkNvbnRlbnQkQ29udGVudCRTZWFyY2hDb250cm9scyRTZWFyY2hCbGFjawU4Y3RsMDAkY3RsMDAkTWFpbkNvbnRlbnQkQ29udGVudCRTZWFyY2hDb250cm9scyRTZWFyY2hSZWQFOmN0bDAwJGN0bDAwJE1haW5Db250ZW50JENvbnRlbnQkU2VhcmNoQ29udHJvbHMkU2VhcmNoR3JlZW4FP2N0bDAwJGN0bDAwJE1haW5Db250ZW50JENvbnRlbnQkU2VhcmNoQ29udHJvbHMkU2VhcmNoQ29sb3JFeGFjdAVBY3RsMDAkY3RsMDAkTWFpbkNvbnRlbnQkQ29udGVudCRTZWFyY2hDb250cm9scyRTZWFyY2hDb2xvckV4Y2x1ZGUFP2N0bDAwJGN0bDAwJE1haW5Db250ZW50JENvbnRlbnQkU2VhcmNoQ29udHJvbHMkU2VhcmNoQ29sb3JNdWx0aTTPal1DVvfANwLJhIiUp3DlxKrt")
                                        .add("__VIEWSTATEGENERATOR", "315CBD8D")
                                        .add("__EVENTTARGET", "")
                                        .add("__EVENTARGUMENT", "")
                                        .add("__EVENTVALIDATION", "/wEW5AECupvqowICy/vn+QMCyomI6wkC2r/i3AcC2cLezQcCnvnt8goClqKvhQ0CjsXrhw4C88aSMQLcy7FxAv+mqqMFAvmm9ukNAoGBxPgNAo3D8KUGAqXl3Z0NAs68zN4NAqmh1rcOArvS8MQIAoe348oKAvWim8kHArj8gukIAoDTw6oGArGvrqAFAvLS4fsHAtu/wuAFAu2npuIGAtmdpecMAtbt24YIAvG6y+QOAoTj98oDAszqmfUNAvrGgL0KAoO33rwOAuLtmakOAsbWlqIDApLE2+UGArrKrdEFArG7idEDApv9tIcIAr21suwIAq+hge4FArGAtp4OAqOK0J4CAvisu58EAu2N/94GAsylv7UNAteBjLkOAouFuYkJAvORzI0EAuvC/ZQHAt7unbgBApDp4MMLAr31470DAre4trUNAoXGh7oOAvyUuPAKAoeLvpsDAuvv57AKArbu7vUFAonymakLAqaylLcNAtLLteQDApq8yn4Cm5CGqA8Ckumk4g8C0ezs5gYCt8LB6wwC2rDx5g8C3Pqt7wwC3Pqp7wwC1MXE1wkCx+C26QcCj/fL1w8C3/m7ogIC3YDOlgIC49H2qAIClrHnhQ0CluOdiQwC2om0vQoCofjJjA8CmOnDlAwCn5aFvAYC7NDtgQECh/aq+AYCicP9/g8C28zn8gwCiZvtpwsCk/SR3gcCk+2ytQIC1KjRrQ0CkfSFigEC3ZvJnAoCh7bebAKUhfv+BALj14qOAgKbuvPtAQK+7ITHDgL+94DfBQLm3OrKAgKmp7jEDQKL6qK6CAL/tbagDAK4hoCUBAKkjYeEBQLSgOHrBQKjtKrfCAKA0o/JDgKPrK7JBwLpztXKAgLP4Ps0AojQsb0FAu6mmscOAo2jju8EAp2F28wIAouNrtoLAqz20fwHApOn1aEDAtXc99ICAoiN+uwCAr/h16ABAqH2kLYDAtu3vOIOAr+lu60LAuiE3NYGArafw/YOArmfq+gIAtn30QsCyNK57gMCn8DyzwQCy5eH+QECy5eL+QECy5eP+QECy5eT+QECzaO20AUCzaOCsAQCw9fRnwQC4OeU1goC6LXk+Q8CturL+gwCldi++AoC4uK9tAMCldiq+AoCz8+p5g8CjsD+yA8Cx5r/jAMC08ze2QwCxa+qjwwCkMnM9AQCkfrpZwLVv8fpBwK12Y6cDQLd8+XwCwKCo5SqAwL/45icDALwxsGoBwLHmZTSAwLxkrTKDAL0ybSKBQKZ2+LwCQLpydiiCwLr366xAQKvmuPUDAKWtODFCAK52LrABgLK/ffIBwL7z6yUDQLJvZOMAQKIj9WDDwKR2NCGCwKqqYv3CgL7y7mRDgLJk/P0BALMxPKOCQK6m9faCwKh3KX4DALlnKm5DQLM1+uvBAKn8cOmAwLohp35CgKk6f0SAvPgyokJAq6/nOoGArXX7/EPApauzrwIAqHci6gDAu6RhOMDAseH5iYC9eLGggcCueSz2wIC//v/1wgC6fKyuwYC2PiK+woCtO/6ng0CtsvW6A4Cppqw3AUC/+Cu4QIC7fXB+gEC1f2KzwYCu7XD/AgC6IiA/ggCwuXLmg0Crs/A2wQCwKvS2AwC0JTjgg4C/Mi4jQIC7IH2VAKFtM7HDgLwu/ktAt6BqtoEAuvY2poKAui2xYwNAujMhIIOAvyW1toMAqGY5cYOApbPhb4PApqqjpkDAuKz3fUGAoyft0YC+fbK9AQCvoTDsQMC44+/wA4C27ugswQCvojeyAMCuY3RoAkCjeagigQCpsuY9A4ChtfVigsCq73o0QpOVULPSIOWo11bjyS6yIzxyDaFcg==")
                                        .add("ctl00$ctl00$SearchControls$CardSearchBoxParent$HeaderCardSearchBox", "Search Terms...")
                                        .add("ctl00$ctl00$MainContent$Content$SearchControls$CardSearchBoxParent$CardSearchBox", "secret")
                                        .add("ctl00$ctl00$MainContent$Content$SearchControls$searchSubmitButton", "SEARCH")
                                        .add("ctl00$ctl00$MainContent$Content$SearchControls$SearchCardName", "on")
                                        .add("ctl00$ctl00$MainContent$Content$SearchControls$formatAddText", "")
                                        .add("ctl00$ctl00$MainContent$Content$SearchControls$setAddText", "")
                                        .add("ctl00$ctl00$MainContent$Content$SearchControls$typeAddText", "")
                                        .add("ctl00$ctl00$MainContent$Content$SearchControls$sortOrder", "")
                                        .add("ctl00$ctl00$MainContent$Content$SearchControls$resultsView", "")
                                        .build();


                                Request request = new Request.Builder().url("http://gatherer.wizards.com/Pages/Default.aspx").post(formBody).build();
                                Log.d(NewMainActivity.AppTag, "built request");
                                try {
                                    client.followRedirects();
                                    Log.d(NewMainActivity.AppTag, html);
                                    Response response = client.newCall(request).execute();
                                    Log.d(NewMainActivity.AppTag, response.toString());

                                    Document document = Jsoup.parse(response.body().string());
                                    Elements elements = document.select(".cardTitle");
                                    for(Element e : elements){
                                        Log.d(NewMainActivity.AppTag, e.text());
                                    }
                                }catch(IOException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                ).start();
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
            case AUTOCOMPLETE_DATA:
                DeckSearchFragment.AutoCompleteAdapter autoAdapter =
                        (DeckSearchFragment.AutoCompleteAdapter) dsFragment.autoView.getAdapter();
                autoAdapter.setSearchResults(data);
                break;

            case DECKS_DATA:
                //TODO: fill this in with dsFragment as we handle filling out our list of decks

            case DECKLIST_DATA:
                DeckListFragment.DeckListAdapter dlAdapter =
                        (DeckListFragment.DeckListAdapter) dlFragment.listView.getAdapter();
                dlAdapter.setDeckList(data);
                break;

            case CARD_DATA:
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
            return NUM_PAGES;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case SEARCH_FRAG:
                    dsFragment = (dsFragment != null) ? dsFragment : new DeckSearchFragment();
                    return dsFragment;
//                    return (csFragment != null) ? csFragment = new DeckSearchFragment() : csFragment;
                case DECKLIST_FRAG:
                    dlFragment = (dlFragment != null) ? dlFragment : new DeckListFragment();
                    return dlFragment;

                case VALUES_FRAG:
                    cvFragment = (cvFragment != null) ? cvFragment : new CardValuesFragment();
                    return cvFragment;
//                    return (cvFragment != null) ? cvFragment = new CardValuesFragment() : cvFragment;
                default:
                    return new DeckSearchFragment();
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
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent();
            ComponentName cn = new ComponentName(NewMainActivity.this, UserSettingsActivity.class);
            intent.setComponent(cn);
            startActivity(intent);

            return true;
        }
        else{
            return super.onOptionsItemSelected(item);
        }
    }
}
