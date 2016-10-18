

package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;

import ibmmobileappbuilder.ui.BaseListingActivity;
/**
 * RecommendationsActivity list activity
 */
public class RecommendationsActivity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.recommendationsActivity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return RecommendationsFragment.class;
    }

}

