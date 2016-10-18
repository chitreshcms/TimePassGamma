package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;

import android.os.Bundle;
import android.view.View;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;
import ibmmobileappbuilder.behaviors.SearchBehavior;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ui.ListGridFragment;
import ibmmobileappbuilder.util.ViewHolder;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.ds.Item;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.ds.EmptyDatasource;
import android.content.Intent;
import ibmmobileappbuilder.util.Constants;

import static ibmmobileappbuilder.util.NavigationUtils.generateIntentToAddOrUpdateItem;

/**
 * "RecommendationsFragment" listing
 */
public class RecommendationsFragment extends ListGridFragment<Item>  {

    private Datasource<Item> datasource;


    public static RecommendationsFragment newInstance(Bundle args) {
        RecommendationsFragment fr = new RecommendationsFragment();

        fr.setArguments(args);
        return fr;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addBehavior(new SearchBehavior(this));
    }

    protected SearchOptions getSearchOptions() {
      SearchOptions.Builder searchOptionsBuilder = SearchOptions.Builder.searchOptions();
      return searchOptionsBuilder.build();
    }


    /**
    * Layout for the list itselft
    */
    @Override
    protected int getLayout() {
        return R.layout.fragment_grid;
    }

    /**
    * Layout for each element in the list
    */
    @Override
    protected int getItemLayout() {
        return R.layout.recommendations_item;
    }

    @Override
    protected Datasource<Item> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
      datasource = EmptyDatasource.getInstance(getSearchOptions());
      return datasource;
    }

    @Override
    protected void bindView(Item item, View view, int position) {
    }


    @Override
    public void showDetail(Item item, int position) {
        Bundle args = new Bundle();
        args.putInt(Constants.ITEMPOS, position);
        args.putParcelable(Constants.CONTENT, item);
        Intent intent = new Intent(getActivity(), RecommendationsDetailActivity.class);
        intent.putExtras(args);

        if (!getResources().getBoolean(R.bool.tabletLayout)) {
            startActivityForResult(intent, Constants.DETAIL);
        } else {
            startActivity(intent);
        }
    }

}

