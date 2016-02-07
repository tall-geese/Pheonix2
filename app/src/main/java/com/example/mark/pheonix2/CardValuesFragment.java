package com.example.mark.pheonix2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mark on 1/27/2016.
 */
public class CardValuesFragment extends Fragment {
    View fragLayout;
    TextView cardName;
    LinearLayout cardCMCLayout;
    TextView cardTypes;
    LinearLayout cardTextLayout;
    TextView flavorText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //this may be incorrect, might need to cast as a viewgroup here then return that
        fragLayout = inflater.inflate(R.layout.content_main, container, false);
        return fragLayout;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        cardName = (TextView) view.findViewById(R.id.CardName);
        cardCMCLayout = (LinearLayout) view.findViewById(R.id.cardCMCLayout);
        cardTypes = (TextView) view.findViewById(R.id.CardTypes);
        cardTextLayout = (LinearLayout) view.findViewById(R.id.cardTextLayout);
        flavorText = (TextView) view.findViewById(R.id.FlavorText);
    }

    public void setValues(Bundle cardBundle) {
        cardName.setText(cardBundle.getString("name", "Name"));
        cardTypes.setText(cardBundle.getString("types", "Types"));
        flavorText.setText(cardBundle.getString("flavor", "Flavor"));

        //TODO: CMC is all one view? does this need to be a linear layout?
        cardCMCLayout.removeAllViews();
        TextView cmcView = viewMaker(cardBundle.getString("CMC"));
        cardCMCLayout.addView(cmcView);

        List<String> cardTextList = cardBundle.getStringArrayList("arrayList");
        cardTextLayout.removeAllViews();
        for (String s : cardTextList) {
            TextView view = viewMaker(s);
            cardTextLayout.addView(view);
        }
    }
    private TextView viewMaker (String html){
        // TODO: so far we are using the same padding for everything that we got fromcardText, we may want to update this in the future.
        TextView view = new TextView(getActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        view.setPadding(0, 0, 0, 5);
        view.setText(Html.fromHtml(html, new SymbolGetter(getActivity()), new TagGetter()));
        return view;
    }

}
