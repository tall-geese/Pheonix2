package com.example.mark.pheonix2;

import android.test.InstrumentationTestCase;

import java.lang.Exception;
import java.lang.Override;


/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest extends InstrumentationTestCase{





    // Todo: Create more tests here
    @Override
    protected void setUp() throws Exception{
        // copy code from IDE and paste in a 1 row, 1 column table
        super.setUp();
    }


    public void testAddition_isCorrect() throws Exception {
        // use a standard blue border to seperate the code from the notes
        assertEquals(4, 2 + 2);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
