
package com.ibm.mobileappbuilder.businessdirectory20150916145512.ds;
import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.POST;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Path;
import retrofit.http.PUT;
import retrofit.mime.TypedByteArray;
import retrofit.http.Part;
import retrofit.http.Multipart;

public interface MoviesDSServiceRest{

	@GET("/app/57f8d157a6690503002f972e/r/moviesDS")
	void queryMoviesDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<MoviesDSItem>> cb);

	@GET("/app/57f8d157a6690503002f972e/r/moviesDS/{id}")
	void getMoviesDSItemById(@Path("id") String id, Callback<MoviesDSItem> cb);

	@DELETE("/app/57f8d157a6690503002f972e/r/moviesDS/{id}")
  void deleteMoviesDSItemById(@Path("id") String id, Callback<MoviesDSItem> cb);

  @POST("/app/57f8d157a6690503002f972e/r/moviesDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<MoviesDSItem>> cb);

  @POST("/app/57f8d157a6690503002f972e/r/moviesDS")
  void createMoviesDSItem(@Body MoviesDSItem item, Callback<MoviesDSItem> cb);

  @PUT("/app/57f8d157a6690503002f972e/r/moviesDS/{id}")
  void updateMoviesDSItem(@Path("id") String id, @Body MoviesDSItem item, Callback<MoviesDSItem> cb);

  @GET("/app/57f8d157a6690503002f972e/r/moviesDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
    
    @Multipart
    @POST("/app/57f8d157a6690503002f972e/r/moviesDS")
    void createMoviesDSItem(
        @Part("data") MoviesDSItem item,
        @Part("moviePoster") TypedByteArray moviePoster,
        Callback<MoviesDSItem> cb);
    
    @Multipart
    @PUT("/app/57f8d157a6690503002f972e/r/moviesDS/{id}")
    void updateMoviesDSItem(
        @Path("id") String id,
        @Part("data") MoviesDSItem item,
        @Part("moviePoster") TypedByteArray moviePoster,
        Callback<MoviesDSItem> cb);
}

