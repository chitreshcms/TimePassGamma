

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
 * "TouristDS" data source. (e37eb8dc-6eb2-4635-8592-5eb9696050e3)
 */
public class TouristDS extends AppNowDatasource<TouristDSItem>{

    // default page size
    private static final int PAGE_SIZE = 20;

    private TouristDSService service;

    public static TouristDS getInstance(SearchOptions searchOptions){
        return new TouristDS(searchOptions);
    }

    private TouristDS(SearchOptions searchOptions) {
        super(searchOptions);
        this.service = TouristDSService.getInstance();
    }

    @Override
    public void getItem(String id, final Listener<TouristDSItem> listener) {
        if ("0".equals(id)) {
                        getItems(new Listener<List<TouristDSItem>>() {
                @Override
                public void onSuccess(List<TouristDSItem> items) {
                    if(items != null && items.size() > 0) {
                        listener.onSuccess(items.get(0));
                    } else {
                        listener.onSuccess(new TouristDSItem());
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure(e);
                }
            });
        } else {
                      service.getServiceProxy().getTouristDSItemById(id, new Callback<TouristDSItem>() {
                @Override
                public void success(TouristDSItem result, Response response) {
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
    public void getItems(final Listener<List<TouristDSItem>> listener) {
        getItems(0, listener);
    }

    @Override
    public void getItems(int pagenum, final Listener<List<TouristDSItem>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
        int skipNum = pagenum * PAGE_SIZE;
        String skip = skipNum == 0 ? null : String.valueOf(skipNum);
        String limit = PAGE_SIZE == 0 ? null: String.valueOf(PAGE_SIZE);
        String sort = getSort(searchOptions);
                service.getServiceProxy().queryTouristDSItem(
                skip,
                limit,
                conditions,
                sort,
                null,
                null,
                new Callback<List<TouristDSItem>>() {
            @Override
            public void success(List<TouristDSItem> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    private String[] getSearchableFields() {
        return new String[]{"tPName", "tPDescription", "tPAddress"};
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
    public void create(TouristDSItem item, Listener<TouristDSItem> listener) {
                    
        if(item.tPPhotoUri != null){
            service.getServiceProxy().createTouristDSItem(item,
                TypedByteArrayUtils.fromUri(item.tPPhotoUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().createTouristDSItem(item, callbackFor(listener));
        
    }

    private Callback<TouristDSItem> callbackFor(final Listener<TouristDSItem> listener) {
      return new Callback<TouristDSItem>() {
          @Override
          public void success(TouristDSItem item, Response response) {
                            listener.onSuccess(item);
          }

          @Override
          public void failure(RetrofitError error) {
                            listener.onFailure(error);
          }
      };
    }

    @Override
    public void updateItem(TouristDSItem item, Listener<TouristDSItem> listener) {
                    
        if(item.tPPhotoUri != null){
            service.getServiceProxy().updateTouristDSItem(item.getIdentifiableId(),
                item,
                TypedByteArrayUtils.fromUri(item.tPPhotoUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().updateTouristDSItem(item.getIdentifiableId(), item, callbackFor(listener));
        
    }

    @Override
    public void deleteItem(TouristDSItem item, final Listener<TouristDSItem> listener) {
                service.getServiceProxy().deleteTouristDSItemById(item.getIdentifiableId(), new Callback<TouristDSItem>() {
            @Override
            public void success(TouristDSItem result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void deleteItems(List<TouristDSItem> items, final Listener<TouristDSItem> listener) {
                service.getServiceProxy().deleteByIds(collectIds(items), new Callback<List<TouristDSItem>>() {
            @Override
            public void success(List<TouristDSItem> item, Response response) {
                                listener.onSuccess(null);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    protected List<String> collectIds(List<TouristDSItem> items){
        List<String> ids = new ArrayList<>();
        for(TouristDSItem item: items){
            ids.add(item.getIdentifiableId());
        }
        return ids;
    }

}

