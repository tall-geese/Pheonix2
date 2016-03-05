package com.example.mark.pheonix2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2/13/2016.
 */
public class DeckListFragment extends Fragment{
    public ListView listView;
    public static final String DL_CATEGORIES = "categories";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.decklist_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new DeckListAdapter(getActivity(), R.layout.my_simple_list_item));

        super.onViewCreated(view, savedInstanceState);
    }

    public class DeckListAdapter extends ArrayAdapter<String>{
        private ArrayList<String> deckList = new ArrayList<>();

        public DeckListAdapter(Context context, int resource){
            super(context, resource);
        }

        @Override
        public int getCount() {
            return deckList.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.my_simple_list_item, parent, false);
            }
            TextView textView = (TextView) convertView.findViewById(R.id.text1);
            textView.setText(deckList.get(position));

            return convertView;
        }

        public void setDeckList(Bundle data){
            deckList = data.getStringArrayList(DeckListFragment.DL_CATEGORIES);
            this.notifyDataSetChanged();
        }
    }
}
