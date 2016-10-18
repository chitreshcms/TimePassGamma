

package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;

import ibmmobileappbuilder.ui.BaseListingActivity;
/**
 * MoviesMenuItem1Activity list activity
 */
public class MoviesMenuItem1Activity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.moviesMenuItem1Activity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return MoviesMenuItem1Fragment.class;
    }

}

