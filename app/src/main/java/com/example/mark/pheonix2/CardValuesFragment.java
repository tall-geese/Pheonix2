package com.example.mark.pheonix2;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mark.pheonix2.Util.SymbolGetter;
import com.example.mark.pheonix2.Util.TagGetter;

import java.util.List;

/**
 * Created by Mark on 1/27/2016.
 */
public class CardValuesFragment extends Fragment {
    public static final String CV_NAME = "name", CV_TYPE = "types",
            CV_FLAVOR = "flavor", CV_CMC = "cmc", CV_CARD_TEXT = "cardtext";

    TextView cardName;
    TextView cardTypes;

    LinearLayout cardCMCLayout;
    LinearLayout cardTextLayout;
    LinearLayout flavorLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cardName = (TextView) view.findViewById(R.id.CardName);
        cardCMCLayout = (LinearLayout) view.findViewById(R.id.cardCMCLayout);
        cardTypes = (TextView) view.findViewById(R.id.CardTypes);
        cardTextLayout = (LinearLayout) view.findViewById(R.id.cardTextLayout);
        flavorLayout = (LinearLayout) view.findViewById(R.id.flavorLayout);
    }

    public void setValues(Bundle cardBundle) {
        cardName.setText(cardBundle.getString(CardValuesFragment.CV_NAME, "Name"));
        cardTypes.setText(cardBundle.getString(CardValuesFragment.CV_TYPE, "Types"));

        cardCMCLayout.removeAllViews();
        TextView cmcView = viewMaker(cardBundle.getString(CardValuesFragment.CV_CMC), 0);
        cardCMCLayout.addView(cmcView);

        List<String> flavorTextList = cardBundle.getStringArrayList(CardValuesFragment.CV_FLAVOR);
        flavorLayout.removeAllViews();
        for (String s : flavorTextList){
            TextView view = viewMaker(s, Typeface.ITALIC);
            flavorLayout.addView(view);
        }

        List<String> cardTextList = cardBundle.getStringArrayList(CardValuesFragment.CV_CARD_TEXT);
        cardTextLayout.removeAllViews();
        for (String s : cardTextList) {
            TextView view = viewMaker(s, 0);
            cardTextLayout.addView(view);
        }
    }
    private TextView viewMaker (String html, int typefaceStyle){
        // TODO: so far we are using the same padding for everything that we got fromcardText, we may want to update this in the future.
        TextView view = new TextView(getActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        view.setPadding(0, 0, 0, 5);
        view.setText(Html.fromHtml(html, new SymbolGetter(getActivity()), new TagGetter()));
        if (typefaceStyle != 0)
            view.setTypeface(Typeface.defaultFromStyle(typefaceStyle));
        return view;
    }

}
