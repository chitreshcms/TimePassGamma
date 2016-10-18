

package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ibmmobileappbuilder.ui.BaseDetailActivity;

/**
 * TouristDestinationsDetailActivity detail activity
 */
public class TouristDestinationsDetailActivity extends BaseDetailActivity {
  
  	@Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return TouristDestinationsDetailFragment.class;
    }
}


