
package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;
import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.util.ColorUtils;
import ibmmobileappbuilder.util.StringUtils;

import android.widget.TextView;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.ds.MTMDataDSItem;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.ds.MTMDataDS;

import static ibmmobileappbuilder.analytics.injector.PageViewBehaviorInjector.pageViewBehavior;

public class RevenueDataFragment extends ibmmobileappbuilder.charts.ui.BarChartFragment<MTMDataDSItem> {

    private Datasource<MTMDataDSItem> datasource;
    private SearchOptions searchOptions;

    public static RevenueDataFragment newInstance(Bundle args){
        RevenueDataFragment fragment = new RevenueDataFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public RevenueDataFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
    }

    @Override
      protected Datasource<MTMDataDSItem> getDatasource() {
        if (datasource != null) {
          return datasource;
        }
          searchOptions = SearchOptions.Builder.searchOptions().build();
         datasource = MTMDataDS.getInstance(searchOptions);
            return datasource;
      }

    @Override
    public void loadChart(List<MTMDataDSItem> items) {
        if (items.size() != 0) {

            setChartTitle("Revenue Data");
            setXAxisLabel("NetProfit");

            List<String> XAxisValues = new ArrayList<String>();
            for (MTMDataDSItem item : items) {
                XAxisValues.add((item.mTMNetProfit != null) ? StringUtils.doubleToString(item.mTMNetProfit, true) : "");
            }
            setXAxisValues(XAxisValues);

            List<Number> series;
            
            series = new ArrayList<Number>();
            for (MTMDataDSItem item : items){
                //StringToNumber is used to maintain backward compatibility with older apps
                series.add(StringUtils.StringToNumber(StringUtils.doubleToString(item.mTMNetProfit, true)));
            }
            addSeries(series, Color.parseColor("#17B9ED"), "Proft");
        }
    }
}

