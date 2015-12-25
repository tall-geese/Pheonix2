package com.example.mark.pheonix2;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    // Declare method-usable variables
    private TextView cardNameView;
    private TextView cardTypeView;
    private TextView cardSubtypesView;
    private TextView cardTextView;
    private TextView cardFlavorTextView;
    private EditText multiverseIDEditText;
    private String gathererURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // declare the views we'll be using
        cardNameView = (TextView) findViewById(R.id.CardName);
        cardTypeView = (TextView) findViewById(R.id.Types);
        cardSubtypesView = (TextView) findViewById(R.id.Subtypes);
        cardTextView = (TextView) findViewById(R.id.CardText);
        cardFlavorTextView = (TextView) findViewById(R.id.FlavorText);
        multiverseIDEditText = (EditText) findViewById(R.id.MultiverseID);

        // get the url (without ID) from our string resources
        gathererURL = (String) this.getResources().getString(R.string.url);

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
                    new JSoupAsync().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, gathererURL + link);
                }
            }
        });
    }

    private class JSoupAsync extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Todo: add code here for testing an internet connection
        }

        @Override
        protected void onPostExecute(String linkText) {
            ;
        }

        @Override
        protected String doInBackground(String... params) {
            // Todo: get the background process finished, just for the name for now.
            try {
                Document doc = Jsoup.connect(params[0]).get();
                Elements cardName = doc.select("#ctl00_ctl00_ctl00_MainContent_SubContent_SubContent_nameRow.value");
                String linkText = cardName.text();
                return linkText;


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
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
