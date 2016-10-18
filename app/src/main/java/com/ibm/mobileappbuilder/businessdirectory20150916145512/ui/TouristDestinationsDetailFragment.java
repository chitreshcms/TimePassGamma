
package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;
import ibmmobileappbuilder.behaviors.ShareBehavior;
import ibmmobileappbuilder.ds.restds.AppNowDatasource;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import ibmmobileappbuilder.util.StringUtils;
import java.net.URL;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.ds.TouristDSItem;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.ds.TouristDS;

public class TouristDestinationsDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<TouristDSItem> implements ShareBehavior.ShareListener  {

    private Datasource<TouristDSItem> datasource;
    public static TouristDestinationsDetailFragment newInstance(Bundle args){
        TouristDestinationsDetailFragment fr = new TouristDestinationsDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public TouristDestinationsDetailFragment(){
        super();
    }

    @Override
    public Datasource<TouristDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = TouristDS.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        addBehavior(new ShareBehavior(getActivity(), this));

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.touristdestinationsdetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final TouristDSItem item, View view) {
        if (item.tPName != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.tPName);
            
        }
        if (item.tPAddress != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText(item.tPAddress);
            
        }
        
        ImageView view2 = (ImageView) view.findViewById(R.id.view2);
        URL view2Media = ((AppNowDatasource) getDatasource()).getImageUrl(item.tPPhoto);
        if(view2Media != null){
          ImageLoader imageLoader = new PicassoImageLoader(view2.getContext());
          imageLoader.load(imageLoaderRequest()
                                   .withPath(view2Media.toExternalForm())
                                   .withTargetView(view2)
                                   .fit()
                                   .build()
                    );
        	
        } else {
          view2.setImageDrawable(null);
        }
        if (item.tPDescription != null){
            
            TextView view3 = (TextView) view.findViewById(R.id.view3);
            view3.setText(item.tPDescription);
            
        }
    }

    @Override
    protected void onShow(TouristDSItem item) {
        // set the title for this fragment
        getActivity().setTitle(null);
    }
    @Override
    public void onShare() {
        TouristDSItem item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.tPName != null ? item.tPName : "" ) + "\n" +
                    (item.tPAddress != null ? item.tPAddress : "" ) + "\n" +
                    (item.tPDescription != null ? item.tPDescription : "" ));
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}

