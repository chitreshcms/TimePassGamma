

package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;

import android.os.Bundle;

import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.MenuItem;

import ibmmobileappbuilder.actions.StartActivityAction;
import ibmmobileappbuilder.util.Constants;

/**
 * CategoriesFragment menu fragment.
 */
public class CategoriesFragment extends ibmmobileappbuilder.ui.MenuFragment {

    /**
     * Default constructor
     */
    public CategoriesFragment(){
        super();
    }

    // Factory method
    public static CategoriesFragment newInstance(Bundle args) {
        CategoriesFragment fragment = new CategoriesFragment();

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
            .setLabel("MOVIES")
            .setIcon(R.drawable.png_movies427)
            .setAction(new StartActivityAction(MoviesMenuItem1Activity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("TOURIST DESTINATIONS")
            .setIcon(R.drawable.png_tourist613)
            .setAction(new StartActivityAction(TouristDestinationsActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("RECOMMEND ME")
            .setIcon(R.drawable.jpg_recommended521)
            .setAction(new StartActivityAction(RecommendationsActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("RESTAURANTS")
            .setIcon(R.drawable.png_restaurants484)
            .setAction(new StartActivityAction(RestaurantsActivity.class, Constants.DETAIL))
        );
        return items;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_grid;
    }

    @Override
    public int getItemLayout() {
        return R.layout.categories_item;
    }
}

