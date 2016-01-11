package com.example.mark.pheonix2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Declare method-usable variables
    private TextView cardNameView;
    private TextView cardTypeView;
    private TextView cardFlavorTextView;
    private EditText multiverseIDEditText;
    private LinearLayout cardTextLayout;
    private LinearLayout cardCMCLayout;

    private String AppTag = "AppTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // declare the views we'll be using
        cardNameView = (TextView) findViewById(R.id.CardName);
        cardTypeView = (TextView) findViewById(R.id.CardTypes);
        cardFlavorTextView = (TextView) findViewById(R.id.FlavorText);
        multiverseIDEditText = (EditText) findViewById(R.id.MultiverseID);
        cardTextLayout = (LinearLayout) findViewById(R.id.cardTextLayout);
        cardCMCLayout = (LinearLayout) findViewById(R.id.cardCMCLayout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if the editText is empty first
                if(multiverseIDEditText.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"You Didn't Enter an ID", Toast.LENGTH_SHORT).show();
                    return;
                }
                // if it isn't then execute our AsyncTask with the full url param
                else{
                    String link = multiverseIDEditText.getText().toString().trim();
                    new JSoupAsync().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, link);
                }
            }
        });
    }

    private class JSoupAsync extends AsyncTask<String, Void, Bundle>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Todo: add code here for testing an internet connection
        }

        @Override
        protected void onPostExecute(Bundle cardBundle) {
            cardNameView.setText(cardBundle.getString("name", "Name"));
            cardTypeView.setText(cardBundle.getString("types", "Types"));
            cardFlavorTextView.setText(cardBundle.getString("flavor", "Flavor"));

            //TODO: find a way to incorporate these two view designs into one, so we're not repeating the same code twice
            cardCMCLayout.removeAllViews();
            TextView cmcView = new TextView(MainActivity.this);
            cmcView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            cmcView.setPadding(0, 0, 0, 5);
            cmcView.setText(Html.fromHtml(cardBundle.getString("CMC"), new SymbolGetter(MainActivity.this), new TagGetter()));
            cardCMCLayout.addView(cmcView);

            List<String> cardTextList = cardBundle.getStringArrayList("arrayList");
            cardTextLayout.removeAllViews();
            for (String s : cardTextList){
                TextView view = new TextView(MainActivity.this);
                view.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                view.setPadding(0, 0, 0, 5);
                view.setText(Html.fromHtml(s, new SymbolGetter(MainActivity.this), new TagGetter()));
                cardTextLayout.addView(view);
            }
        }

        @Override
        protected Bundle doInBackground(String... params) {
            CardScraper scraper = new CardScraper(params[0], MainActivity.this);

            Bundle cardBundle = new Bundle();

            cardBundle.putString("name", scraper.getcardName());
            cardBundle.putString("types", scraper.getCardTypes());
            cardBundle.putString("flavor", scraper.getCardFlavor());
            cardBundle.putString("CMC", scraper.getCardCMC());
            cardBundle.putStringArrayList("arrayList", scraper.getCardTextArray());

            return cardBundle;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
