package com.example.mark.pheonix2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2/1/2016.
 */
public class CardSearchFragment extends Fragment{
    EditText searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        searchView = (EditText) view.findViewById(R.id.editText);
        super.onViewCreated(view, savedInstanceState);
    }

    public String getMultiverseID(){
        return searchView.getText().toString().trim();
    }

    public class AutoCompleteAdapter extends ArrayAdapter<String> implements
            AdapterView.OnItemClickListener, TextWatcher{

        Context ctx;
        // this should be elemenets instead, keep name and link attr all in one place
        List<String> results = new ArrayList<String>();

        AutoCompleteAdapter(Context context, int resource){
            super(context, resource);
            ctx = context;
        }

        @Override
        public int getCount() {
            return results.size();
        }

        @Override
        public String getItem(int position) {
            return results.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // if convert view is null, inflate a view from our android list and bind to the parent
            // then take convert view and find the textview inside it and put our string from this posistion
            // finallly return convertView

            return super.getView(position, convertView, parent);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // we need to start an async web scrape request here.
            // I'd prefer most of the work to go down in activity, since we can posistion tabs
            // and deal with Jsoup async more easily. JsoupAsync & CardWebscraper
                        // may have to be more modular to accodmodate for word card search (follow redirects & such)

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // depending on when/how this method  is called, we should be setting
            // our array list to null here.

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // probly the only one that we really care about. have a handler outsside of this method already built
            // then we'll send delayed messages to the handler to make a Jsoup request to return some results to us.
            // this method should be populating our araylist of strings

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }


}
