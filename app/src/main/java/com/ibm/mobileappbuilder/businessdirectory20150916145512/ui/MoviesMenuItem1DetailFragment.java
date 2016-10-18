
package com.ibm.mobileappbuilder.businessdirectory20150916145512.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;
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
import com.ibm.mobileappbuilder.businessdirectory20150916145512.ds.MoviesDSItem;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.ds.MoviesDS;

public class MoviesMenuItem1DetailFragment extends ibmmobileappbuilder.ui.DetailFragment<MoviesDSItem>  {

    private Datasource<MoviesDSItem> datasource;
    public static MoviesMenuItem1DetailFragment newInstance(Bundle args){
        MoviesMenuItem1DetailFragment fr = new MoviesMenuItem1DetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public MoviesMenuItem1DetailFragment(){
        super();
    }

    @Override
    public Datasource<MoviesDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = MoviesDS.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.moviesmenuitem1detail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final MoviesDSItem item, View view) {
        if (item.movieName != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.movieName);
            
        }
        if (item.description != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText(item.description);
            
        }
        
        ImageView view2 = (ImageView) view.findViewById(R.id.view2);
        URL view2Media = ((AppNowDatasource) getDatasource()).getImageUrl(item.moviePoster);
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
    }

    @Override
    protected void onShow(MoviesDSItem item) {
        // set the title for this fragment
        getActivity().setTitle("Movie Details");
    }
}

