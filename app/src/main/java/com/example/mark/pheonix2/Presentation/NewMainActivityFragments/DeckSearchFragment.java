package com.example.mark.pheonix2.Presentation.NewMainActivityFragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;

import com.example.mark.pheonix2.Domain.DeckListAsync;
import com.example.mark.pheonix2.Domain.DeckSearchAsync;
import com.example.mark.pheonix2.Presentation.NewMainActivity;
import com.example.mark.pheonix2.R;

/**
 * Created by Mark on 2/1/2016.
 */
public class DeckSearchFragment extends Fragment{
    public AutoCompleteTextView autoView;
    private AutoCompleteAdapter adapter;

    public static final String DS_NAME = "name", DS_URL = "url";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.card_value_fragment_content, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        autoView = (AutoCompleteTextView) view.findViewById(R.id.autoText);
        adapter = new AutoCompleteAdapter(getActivity(), R.layout.category_list_item);
        autoView.setAdapter(adapter);
        autoView.setOnItemClickListener(adapter);
        autoView.addTextChangedListener(adapter);

        super.onViewCreated(view, savedInstanceState);
    }

    public class AutoCompleteAdapter extends ArrayAdapter<String> implements
            AdapterView.OnItemClickListener, TextWatcher{
        List<String> results = new ArrayList<>();
        List<String> urls = new ArrayList<>();

        private static final int MESSAGE_DELAY = 500;
        private static final int MESSAGE_SEARCH = 101;
        private final Handler mHandler;


        AutoCompleteAdapter(Context context, int resource){
            super(context, resource);
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    DeckSearchAsync async = new DeckSearchAsync(getActivity());
                    async.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, (String) msg.obj);
                }
            };
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
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null){
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.card_list_item, parent, false);
            }
            TextView textView = (TextView) convertView.findViewById(R.id.text3);
            textView.setText(results.get(position));

            return convertView;
        }

        public void setSearchResults(Bundle data){
            results = data.getStringArrayList(DeckSearchFragment.DS_NAME);
            urls = data.getStringArrayList(DeckSearchFragment.DS_URL);
            this.notifyDataSetChanged();
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d(NewMainActivity.AppTag, "" + position + " " + urls.get(position));
            new DeckListAsync(getActivity()).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, urls.get(position));
        }


        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s.toString().trim().length() > 4){
                mHandler.removeMessages(MESSAGE_SEARCH);
                mHandler.sendMessageDelayed(mHandler.obtainMessage(MESSAGE_SEARCH, s.toString().trim()), MESSAGE_DELAY);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }


}
