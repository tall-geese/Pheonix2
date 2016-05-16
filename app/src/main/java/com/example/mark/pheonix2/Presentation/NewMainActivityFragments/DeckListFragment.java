package com.example.mark.pheonix2.Presentation.NewMainActivityFragments;

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

import com.example.mark.pheonix2.Presentation.NewMainActivity;
import com.example.mark.pheonix2.R;
import com.example.mark.pheonix2.Util.Models.DeckListModel;
import com.example.mark.pheonix2.Util.ViewHolders.CardViewHolder;
import com.example.mark.pheonix2.Util.ViewHolders.HeaderViewHolder;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Mark on 2/13/2016.
 */
public class DeckListFragment extends Fragment{
    private static final int HEADER_ITEM = 1;
    private static final int CARD_ITEM = 0;

    public ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.decklist_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new DeckListAdapter(getActivity(), R.layout.category_list_item));

        super.onViewCreated(view, savedInstanceState);
    }

    public class DeckListAdapter extends ArrayAdapter<DeckListModel>{
        private ArrayList<DeckListModel> modelList = new ArrayList<>();

        public DeckListAdapter(Context context, int resource){
            super(context, resource);
        }

        @Override
        public int getCount() {
            return modelList.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            DeckListModel model = modelList.get(position);

            switch (getItemViewType(position)){
                case (DeckListFragment.HEADER_ITEM):
                    if(convertView == null){
                        convertView = LayoutInflater.from(getActivity()).inflate(R.layout.category_list_item, parent, false);
                        HeaderViewHolder headerHolder = new HeaderViewHolder();
                        headerHolder.category = (TextView) convertView.findViewById(R.id.text2);
                        headerHolder.name = (TextView) convertView.findViewById(R.id.text1);
                        convertView.setTag(headerHolder);
                    }
                    HeaderViewHolder headerHolder = (HeaderViewHolder) convertView.getTag();
                    headerHolder.category.setText(model.getParentCatgeroy());
                    headerHolder.name.setText(model.getName());
                    return convertView;
                case(DeckListFragment.CARD_ITEM):
                    if(convertView == null){
                        convertView = LayoutInflater.from(getActivity()).inflate(R.layout.card_list_item, parent, false);
                        CardViewHolder cardHolder = new CardViewHolder();
                        cardHolder.name = (TextView) convertView.findViewById(R.id.text3);
                        convertView.setTag(cardHolder);
                    }
                    CardViewHolder cardHolder = (CardViewHolder) convertView.getTag();
                    cardHolder.name.setText(model.getName());
                    return convertView;
                default:
                    return convertView;
            }
        }

        public void setDeckList(Bundle data){
            modelList = data.getParcelableArrayList(getActivity().getResources().getString(R.string.model_key));
            this.notifyDataSetChanged();
        }

        @Override
        public int getItemViewType(int position) {
            DeckListModel model = modelList.get(position);
            switch (model.getIsCategoryHeader()){
                case (0):
                    return DeckListFragment.CARD_ITEM;
                case(1):
                    return DeckListFragment.HEADER_ITEM;
                default:
                    Log.d(NewMainActivity.AppTag, "reached an error in the isCategoryHeader()");
                    return 0;
            }
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }
    }
}
