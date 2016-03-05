package com.example.mark.pheonix2;

import android.os.Bundle;

import java.util.List;

/**
 * Created by Mark on 2/13/2016.
 */
public interface AsyncScroller {
    public void handleScroll(int posistion);

    public void setFragmentData (int where, Bundle data);
}
