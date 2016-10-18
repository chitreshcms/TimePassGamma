

package com.ibm.mobileappbuilder.businessdirectory20150916145512.ds;

import android.content.Context;

import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.restds.AppNowDatasource;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.restds.TypedByteArrayUtils;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * "MTMDataDS" data source. (e37eb8dc-6eb2-4635-8592-5eb9696050e3)
 */
public class MTMDataDS extends AppNowDatasource<MTMDataDSItem>{

    // default page size
    private static final int PAGE_SIZE = 20;

    private MTMDataDSService service;

    public static MTMDataDS getInstance(SearchOptions searchOptions){
        return new MTMDataDS(searchOptions);
    }

    private MTMDataDS(SearchOptions searchOptions) {
        super(searchOptions);
        this.service = MTMDataDSService.getInstance();
    }

    @Override
    public void getItem(String id, final Listener<MTMDataDSItem> listener) {
        if ("0".equals(id)) {
                        getItems(new Listener<List<MTMDataDSItem>>() {
                @Override
                public void onSuccess(List<MTMDataDSItem> items) {
                    if(items != null && items.size() > 0) {
                        listener.onSuccess(items.get(0));
                    } else {
                        listener.onSuccess(new MTMDataDSItem());
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure(e);
                }
            });
        } else {
                      service.getServiceProxy().getMTMDataDSItemById(id, new Callback<MTMDataDSItem>() {
                @Override
                public void success(MTMDataDSItem result, Response response) {
                                        listener.onSuccess(result);
                }

                @Override
                public void failure(RetrofitError error) {
                                        listener.onFailure(error);
                }
            });
        }
    }

    @Override
    public void getItems(final Listener<List<MTMDataDSItem>> listener) {
        getItems(0, listener);
    }

    @Override
    public void getItems(int pagenum, final Listener<List<MTMDataDSItem>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
        int skipNum = pagenum * PAGE_SIZE;
        String skip = skipNum == 0 ? null : String.valueOf(skipNum);
        String limit = PAGE_SIZE == 0 ? null: String.valueOf(PAGE_SIZE);
        String sort = getSort(searchOptions);
                service.getServiceProxy().queryMTMDataDSItem(
                skip,
                limit,
                conditions,
                sort,
                null,
                null,
                new Callback<List<MTMDataDSItem>>() {
            @Override
            public void success(List<MTMDataDSItem> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    private String[] getSearchableFields() {
        return new String[]{"mTMUserName", "mTMTheaterName", "mTMTheaterAddress", "movieName"};
    }

    // Pagination

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getUniqueValuesFor(String searchStr, final Listener<List<String>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
                service.getServiceProxy().distinct(searchStr, conditions, new Callback<List<String>>() {
             @Override
             public void success(List<String> result, Response response) {
                                  result.removeAll(Collections.<String>singleton(null));
                 listener.onSuccess(result);
             }

             @Override
             public void failure(RetrofitError error) {
                                  listener.onFailure(error);
             }
        });
    }

    @Override
    public URL getImageUrl(String path) {
        return service.getImageUrl(path);
    }

    @Override
    public void create(MTMDataDSItem item, Listener<MTMDataDSItem> listener) {
                    
        if(item.movieTheaterPhotoUri != null){
            service.getServiceProxy().createMTMDataDSItem(item,
                TypedByteArrayUtils.fromUri(item.movieTheaterPhotoUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().createMTMDataDSItem(item, callbackFor(listener));
        
    }

    private Callback<MTMDataDSItem> callbackFor(final Listener<MTMDataDSItem> listener) {
      return new Callback<MTMDataDSItem>() {
          @Override
          public void success(MTMDataDSItem item, Response response) {
                            listener.onSuccess(item);
          }

          @Override
          public void failure(RetrofitError error) {
                            listener.onFailure(error);
          }
      };
    }

    @Override
    public void updateItem(MTMDataDSItem item, Listener<MTMDataDSItem> listener) {
                    
        if(item.movieTheaterPhotoUri != null){
            service.getServiceProxy().updateMTMDataDSItem(item.getIdentifiableId(),
                item,
                TypedByteArrayUtils.fromUri(item.movieTheaterPhotoUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().updateMTMDataDSItem(item.getIdentifiableId(), item, callbackFor(listener));
        
    }

    @Override
    public void deleteItem(MTMDataDSItem item, final Listener<MTMDataDSItem> listener) {
                service.getServiceProxy().deleteMTMDataDSItemById(item.getIdentifiableId(), new Callback<MTMDataDSItem>() {
            @Override
            public void success(MTMDataDSItem result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void deleteItems(List<MTMDataDSItem> items, final Listener<MTMDataDSItem> listener) {
                service.getServiceProxy().deleteByIds(collectIds(items), new Callback<List<MTMDataDSItem>>() {
            @Override
            public void success(List<MTMDataDSItem> item, Response response) {
                                listener.onSuccess(null);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    protected List<String> collectIds(List<MTMDataDSItem> items){
        List<String> ids = new ArrayList<>();
        for(MTMDataDSItem item: items){
            ids.add(item.getIdentifiableId());
        }
        return ids;
    }

}

