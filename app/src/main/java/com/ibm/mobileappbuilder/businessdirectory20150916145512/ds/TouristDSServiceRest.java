
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

public interface TouristDSServiceRest{

	@GET("/app/57f8d157a6690503002f972e/r/touristDS")
	void queryTouristDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<TouristDSItem>> cb);

	@GET("/app/57f8d157a6690503002f972e/r/touristDS/{id}")
	void getTouristDSItemById(@Path("id") String id, Callback<TouristDSItem> cb);

	@DELETE("/app/57f8d157a6690503002f972e/r/touristDS/{id}")
  void deleteTouristDSItemById(@Path("id") String id, Callback<TouristDSItem> cb);

  @POST("/app/57f8d157a6690503002f972e/r/touristDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<TouristDSItem>> cb);

  @POST("/app/57f8d157a6690503002f972e/r/touristDS")
  void createTouristDSItem(@Body TouristDSItem item, Callback<TouristDSItem> cb);

  @PUT("/app/57f8d157a6690503002f972e/r/touristDS/{id}")
  void updateTouristDSItem(@Path("id") String id, @Body TouristDSItem item, Callback<TouristDSItem> cb);

  @GET("/app/57f8d157a6690503002f972e/r/touristDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
    
    @Multipart
    @POST("/app/57f8d157a6690503002f972e/r/touristDS")
    void createTouristDSItem(
        @Part("data") TouristDSItem item,
        @Part("tPPhoto") TypedByteArray tPPhoto,
        Callback<TouristDSItem> cb);
    
    @Multipart
    @PUT("/app/57f8d157a6690503002f972e/r/touristDS/{id}")
    void updateTouristDSItem(
        @Path("id") String id,
        @Part("data") TouristDSItem item,
        @Part("tPPhoto") TypedByteArray tPPhoto,
        Callback<TouristDSItem> cb);
}

