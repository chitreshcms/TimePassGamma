
package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.ds.Item;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.ds.EmptyDatasource;

public class RecommendationsDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<Item>  {

    private Datasource<Item> datasource;
    public static RecommendationsDetailFragment newInstance(Bundle args){
        RecommendationsDetailFragment fr = new RecommendationsDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public RecommendationsDetailFragment(){
        super();
    }

    @Override
    public Datasource<Item> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = EmptyDatasource.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.recommendationsdetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Item item, View view) {
    }

    @Override
    protected void onShow(Item item) {
        // set the title for this fragment
        getActivity().setTitle(null);
    }
}

