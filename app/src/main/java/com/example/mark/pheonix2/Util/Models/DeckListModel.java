package com.example.mark.pheonix2.Util.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mark on 3/30/2016.
 */
public class DeckListModel implements Parcelable {
    String name;
    String parentCatgeroy;
    int isCategoryHeader = 0;

    public DeckListModel(){
        super();
    }

    private DeckListModel(Parcel in){
        name = in.readString();
        parentCatgeroy = in.readString();
        isCategoryHeader = in.readInt();
    }

    public void setName(String s){
        this.name = s;
    }

    public String getName(){
        return this.name;
    }

    public void setParentCatgeroy(String p){
        this.parentCatgeroy = p;
    }

    public String getParentCatgeroy(){
        return this.parentCatgeroy;
    }

    public void setIsCategoryHeader(int b){
        this.isCategoryHeader = b;
    }

    public int getIsCategoryHeader(){
        return this.isCategoryHeader;
    }

    public static final Parcelable.Creator<DeckListModel> CREATOR
            = new Parcelable.Creator<DeckListModel>() {
        @Override
        public DeckListModel createFromParcel(Parcel source) {
            return new DeckListModel(source);
        }

        @Override
        public DeckListModel[] newArray(int size) {
            return new DeckListModel[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeString(parentCatgeroy);
        out.writeInt(isCategoryHeader);
    }
}
