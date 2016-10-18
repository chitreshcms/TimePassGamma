package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import ibmmobileappbuilder.ui.DrawerActivity;

import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;

public class TimePassGammaMain extends DrawerActivity {

    private final SparseArray<Class<? extends Fragment>> sectionFragments = new SparseArray<>();
    {
                sectionFragments.append(R.id.entry0, CategoriesFragment.class);
            sectionFragments.append(R.id.entry1, MTMHomeFragment.class);
            sectionFragments.append(R.id.entry2, ProfileFragment.class);
    }

    @Override
    public SparseArray<Class<? extends Fragment>> getSectionFragmentClasses() {
      return sectionFragments;
    }

}

