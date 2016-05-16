package com.example.mark.pheonix2.Presentation.Dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.mark.pheonix2.Presentation.NewMainActivity;
import com.example.mark.pheonix2.R;

/**
 * Created by Mark on 3/26/2016.
 */
public class DeckSearchDialog extends AppCompatDialogFragment{
    private Toolbar toolbar;
    private EditText deckNameEditText;
    private RadioGroup radioGroup;
    private EditText profileNameEditText;
    private CheckBox loadDecksCheckbox;
    private CheckBox updateDecksCheckbox;


    public DeckSearchDialog() {
        super();
        Log.d(NewMainActivity.AppTag, "inside the constructor");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //TODO do our initializations here
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(NewMainActivity.AppTag, "inside onCreateView");
        View view =  inflater.inflate(R.layout.dialog_search, container, false);
        view.setFitsSystemWindows(true);
        initialize(view);
        return view;

        //TODO consider overriding onViewCreated and intializing there like in our other fragments
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.d(NewMainActivity.AppTag, "inside onCreateDialog");
        return super.onCreateDialog(savedInstanceState);
    }

    public void initialize(View view){
        Log.d(NewMainActivity.AppTag, "inside intialize");
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        deckNameEditText = (EditText) view.findViewById(R.id.deck_name_edit_text);
        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        profileNameEditText = (EditText) view.findViewById(R.id.profile_name_edit_text);
        loadDecksCheckbox = (CheckBox) view.findViewById(R.id.load_all_profile_checkbox);
        updateDecksCheckbox = (CheckBox) view.findViewById(R.id.update_deck_checkbox);

        toolbar.setTitle("Dialog Search");

//        toolbar.setNavigationIcon(android.R.drawable.ic_menu_close_clear_cancel);
        toolbar.setNavigationIcon(R.mipmap.delete_sign);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        toolbar.inflateMenu(R.menu.dialog_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.search_item) {
                    dismiss();
                    //TODO: change this up later to start up a search
                }

                return true;
            }
        });

        //TODO: continue here for setting our listeners and such
    }

}
