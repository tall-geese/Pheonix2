package com.example.mark.pheonix2;

import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.test.InstrumentationTestCase;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import android.content.Context;


/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest extends InstrumentationTestCase{

    //TODO: get tests running properly again

    @Mock
    Context mockContext;
    @Mock
    Resources mockResources;
    @Mock
    ConnectivityManager mockCM;
    @Mock
    NetworkInfo mockActiveNetwork;

//    @Override
//    protected void setUp() throws Exception{
//        super.setUp();
//    }
//
//    @Test
//    public void testNetworkConnection(){
//        //TODO: update this test so it doesn't hit a runtimexception for a successful test
//        // check that the isConnectedToNetwork returns null and our contstructor tries to make
//        // a toast instead of doing web activities.
//        when(mockContext.getResources()).thenReturn(mockResources);
//        when(mockResources.getString(anyInt())).thenReturn("string");
//        when(mockContext.getSystemService(mockContext.CONNECTIVITY_SERVICE)).thenReturn(mockCM);
//        when(mockCM.getActiveNetworkInfo()).thenReturn(mockActiveNetwork);
//        when(mockActiveNetwork.isConnectedOrConnecting()).thenReturn(false);
//
//        GathererWebScraper scraper = new GathererWebScraper("multiverseID", mockContext);
//        assertNull(scraper.document);
//    }
//
//
//
//    @Override
//    protected void tearDown() throws Exception {
//        super.tearDown();
//    }
}
