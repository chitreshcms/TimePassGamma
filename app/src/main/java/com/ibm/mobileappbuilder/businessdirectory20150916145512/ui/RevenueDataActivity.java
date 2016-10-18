
package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;

import ibmmobileappbuilder.ui.BaseDetailActivity;
/**
 * RevenueDataActivity chart screen
 */
public class RevenueDataActivity extends BaseDetailActivity {


    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);        
        
        getSupportActionBar ().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.revenueDataActivity));
    }   

    // DetailActivity interface

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return RevenueDataFragment.class;
    }

}


