

package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Arrays;

import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;

import ibmmobileappbuilder.ui.BaseFragment;
import ibmmobileappbuilder.ui.FilterActivity;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;

import ibmmobileappbuilder.views.DateRangePicker;
import java.util.Date;

/**
 * MoviesMenuItem1FilterActivity filter activity
 */
public class MoviesMenuItem1FilterActivity extends FilterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // set title
        setTitle(R.string.moviesMenuItem1FilterActivity);
    }

    @Override
    protected Fragment getFragment() {
        return new PlaceholderFragment();
    }

    public static class PlaceholderFragment extends BaseFragment {
        private SearchOptions.Builder searchOptionsBuilder = SearchOptions.Builder.searchOptions();
        private SearchOptions searchOptions;

        // filter field values
            
    long releaseDate_min = -1;
    long releaseDate_max = -1;

        public PlaceholderFragment() {
              searchOptions = SearchOptions.Builder.searchOptions().build();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.moviesmenuitem1_filter, container, false);
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            // Get saved values
            Bundle bundle = savedInstanceState;
            if(bundle == null) {
                bundle = getArguments();
            }
            // get initial data
                        
            releaseDate_max = bundle.getLong("releaseDate_max", -1);
            releaseDate_min = bundle.getLong("releaseDate_min", -1);

            // bind pickers
                        
            final DateRangePicker releaseDate_view = (DateRangePicker) view.findViewById(R.id.releaseDate_filter);
            releaseDate_view.setMinDate(releaseDate_min != -1? new Date(releaseDate_min) : null)
                .setMaxDate(releaseDate_max != -1? new Date(releaseDate_max) : null)
                .setRangeSelectedListener(new DateRangePicker.DateRangeSelectedListener() {
                @Override
                public void onRangeSelected(Date dateMin, Date dateMax) {
                    releaseDate_min = dateMin != null ? dateMin.getTime() : -1;
                    releaseDate_max = dateMax != null ? dateMax.getTime() : -1;
                }
            });

            // Bind buttons
            Button okBtn = (Button) view.findViewById(R.id.ok);
            okBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();

                    // send filter result back to caller
                                        
                    intent.putExtra("releaseDate_min", releaseDate_min);
                    intent.putExtra("releaseDate_max", releaseDate_max);

                    getActivity().setResult(RESULT_OK, intent);
                    getActivity().finish();
                }
            });

            Button cancelBtn = (Button) view.findViewById(R.id.reset);
            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Reset values
                                        
                    releaseDate_view.setMinDate(null);
                    releaseDate_min = -1;
                    releaseDate_view.setMaxDate(null);
                    releaseDate_max = -1;
                }
            });
        }

        @Override
        public void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);

            // save current status
                        
            bundle.putLong("releaseDate_max", releaseDate_max);
            bundle.putLong("releaseDate_min", releaseDate_min);
        }
    }

}

