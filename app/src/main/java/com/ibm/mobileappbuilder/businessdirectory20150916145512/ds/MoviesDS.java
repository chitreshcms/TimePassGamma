

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
 * "MoviesDS" data source. (e37eb8dc-6eb2-4635-8592-5eb9696050e3)
 */
public class MoviesDS extends AppNowDatasource<MoviesDSItem>{

    // default page size
    private static final int PAGE_SIZE = 20;

    private MoviesDSService service;

    public static MoviesDS getInstance(SearchOptions searchOptions){
        return new MoviesDS(searchOptions);
    }

    private MoviesDS(SearchOptions searchOptions) {
        super(searchOptions);
        this.service = MoviesDSService.getInstance();
    }

    @Override
    public void getItem(String id, final Listener<MoviesDSItem> listener) {
        if ("0".equals(id)) {
                        getItems(new Listener<List<MoviesDSItem>>() {
                @Override
                public void onSuccess(List<MoviesDSItem> items) {
                    if(items != null && items.size() > 0) {
                        listener.onSuccess(items.get(0));
                    } else {
                        listener.onSuccess(new MoviesDSItem());
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure(e);
                }
            });
        } else {
                      service.getServiceProxy().getMoviesDSItemById(id, new Callback<MoviesDSItem>() {
                @Override
                public void success(MoviesDSItem result, Response response) {
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
    public void getItems(final Listener<List<MoviesDSItem>> listener) {
        getItems(0, listener);
    }

    @Override
    public void getItems(int pagenum, final Listener<List<MoviesDSItem>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
        int skipNum = pagenum * PAGE_SIZE;
        String skip = skipNum == 0 ? null : String.valueOf(skipNum);
        String limit = PAGE_SIZE == 0 ? null: String.valueOf(PAGE_SIZE);
        String sort = getSort(searchOptions);
                service.getServiceProxy().queryMoviesDSItem(
                skip,
                limit,
                conditions,
                sort,
                null,
                null,
                new Callback<List<MoviesDSItem>>() {
            @Override
            public void success(List<MoviesDSItem> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    private String[] getSearchableFields() {
        return new String[]{"movieName", "description"};
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
    public void create(MoviesDSItem item, Listener<MoviesDSItem> listener) {
                    
        if(item.moviePosterUri != null){
            service.getServiceProxy().createMoviesDSItem(item,
                TypedByteArrayUtils.fromUri(item.moviePosterUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().createMoviesDSItem(item, callbackFor(listener));
        
    }

    private Callback<MoviesDSItem> callbackFor(final Listener<MoviesDSItem> listener) {
      return new Callback<MoviesDSItem>() {
          @Override
          public void success(MoviesDSItem item, Response response) {
                            listener.onSuccess(item);
          }

          @Override
          public void failure(RetrofitError error) {
                            listener.onFailure(error);
          }
      };
    }

    @Override
    public void updateItem(MoviesDSItem item, Listener<MoviesDSItem> listener) {
                    
        if(item.moviePosterUri != null){
            service.getServiceProxy().updateMoviesDSItem(item.getIdentifiableId(),
                item,
                TypedByteArrayUtils.fromUri(item.moviePosterUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().updateMoviesDSItem(item.getIdentifiableId(), item, callbackFor(listener));
        
    }

    @Override
    public void deleteItem(MoviesDSItem item, final Listener<MoviesDSItem> listener) {
                service.getServiceProxy().deleteMoviesDSItemById(item.getIdentifiableId(), new Callback<MoviesDSItem>() {
            @Override
            public void success(MoviesDSItem result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void deleteItems(List<MoviesDSItem> items, final Listener<MoviesDSItem> listener) {
                service.getServiceProxy().deleteByIds(collectIds(items), new Callback<List<MoviesDSItem>>() {
            @Override
            public void success(List<MoviesDSItem> item, Response response) {
                                listener.onSuccess(null);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    protected List<String> collectIds(List<MoviesDSItem> items){
        List<String> ids = new ArrayList<>();
        for(MoviesDSItem item: items){
            ids.add(item.getIdentifiableId());
        }
        return ids;
    }

}

