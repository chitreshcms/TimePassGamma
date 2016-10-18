

package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;

import android.os.Bundle;

import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.MenuItem;

import ibmmobileappbuilder.actions.StartActivityAction;
import ibmmobileappbuilder.util.Constants;

/**
 * MTMHomeFragment menu fragment.
 */
public class MTMHomeFragment extends ibmmobileappbuilder.ui.MenuFragment {

    /**
     * Default constructor
     */
    public MTMHomeFragment(){
        super();
    }

    // Factory method
    public static MTMHomeFragment newInstance(Bundle args) {
        MTMHomeFragment fragment = new MTMHomeFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
      public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
                }

    // Menu Fragment interface
    @Override
    public List<MenuItem> getMenuItems() {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new MenuItem()
            .setLabel("Revenue Data")
            .setIcon(R.drawable.jpg_growrevenue155)
            .setAction(new StartActivityAction(RevenueDataActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Add/Remove movie theaters")
            .setIcon(R.drawable.jpg_489123590432)
            .setAction(new StartActivityAction(AddRemovemovietheatersActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Update Showtimes")
            .setIcon(R.drawable.jpg_stockillustration67682843blacksquarebuttonwithmovietheatreicon490)
            .setAction(new StartActivityAction(UpdateShowtimesActivity.class, Constants.DETAIL))
        );
        return items;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_grid;
    }

    @Override
    public int getItemLayout() {
        return R.layout.mtmhome_item;
    }
}

