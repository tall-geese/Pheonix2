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

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    // Declare method-usable variables
    private String cardName;
    private String cardType;
    private String cardSubtypes;
    private String cardText;
    private String cardFlavorText;
    private int multiverseID;
    private String gathererURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // declare the views we'll be using
        TextView cardNameView = (TextView) findViewById(R.id.CardName);
        TextView cardTypeView = (TextView) findViewById(R.id.Types);
        TextView cardSubtypesView = (TextView) findViewById(R.id.Subtypes);
        TextView cardTextView = (TextView) findViewById(R.id.CardText);
        TextView cardFlavorTextView = (TextView) findViewById(R.id.FlavorText);
        final EditText multiverseIDEditText = (EditText) findViewById(R.id.MultiverseID);

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

    private class JSoupAsync extends AsyncTask<String, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Todo: add code here for testing an internet connection
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(String... params) {
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
