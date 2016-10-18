
package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;
import ibmmobileappbuilder.ds.Datasource;
import android.widget.TextView;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.ds.Item;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.ds.EmptyDatasource;

public class ProfileFragment extends ibmmobileappbuilder.ui.DetailFragment<Item>  {

    private Datasource<Item> datasource;
    private SearchOptions searchOptions;

    public static ProfileFragment newInstance(Bundle args){
        ProfileFragment card = new ProfileFragment();
        card.setArguments(args);

        return card;
    }

    public ProfileFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            searchOptions = SearchOptions.Builder.searchOptions().build();
    }

    @Override
    public Datasource getDatasource() {
      if (datasource != null) {
          return datasource;
      }
          datasource = EmptyDatasource.getInstance(searchOptions);
          return datasource;
    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.profile_custom;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Item item, View view) {
    }

    @Override
    protected void onShow(Item item) {
        // set the title for this fragment
        getActivity().setTitle("Profile");
    }

}

