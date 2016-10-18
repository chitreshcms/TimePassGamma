
package com.ibm.mobileappbuilder.businessdirectory20150916145512.ds;
import java.net.URL;
import com.ibm.mobileappbuilder.businessdirectory20150916145512.R;
import ibmmobileappbuilder.ds.RestService;
import ibmmobileappbuilder.util.StringUtils;

/**
 * "MTMDataDSService" REST Service implementation
 */
public class MTMDataDSService extends RestService<MTMDataDSServiceRest>{

    public static MTMDataDSService getInstance(){
          return new MTMDataDSService();
    }

    private MTMDataDSService() {
        super(MTMDataDSServiceRest.class);

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

