
package com.ibm.mobileappbuilder.businessdirectory20150916145512.ds;
import java.net.URL;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;
import ibmmobileappbuilder.ds.RestService;
import ibmmobileappbuilder.util.StringUtils;

/**
 * "MoviesDSService" REST Service implementation
 */
public class MoviesDSService extends RestService<MoviesDSServiceRest>{

    public static MoviesDSService getInstance(){
          return new MoviesDSService();
    }

    private MoviesDSService() {
        super(MoviesDSServiceRest.class);

    }

    @Override
    public String getServerUrl() {
        return "https://ibm-pods.buildup.io";
    }

    @Override
    protected String getApiKey() {
        return "mdl65Mgz";
    }

    @Override
    public URL getImageUrl(String path){
        return StringUtils.parseUrl("https://ibm-pods.buildup.io/app/57f8d157a6690503002f972e",
                path,
                "apikey=mdl65Mgz");
    }

}

