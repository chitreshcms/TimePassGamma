
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

public interface MTMDataDSServiceRest{

	@GET("/app/57f8d157a6690503002f972e/r/mTMDataDS")
	void queryMTMDataDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<MTMDataDSItem>> cb);

	@GET("/app/57f8d157a6690503002f972e/r/mTMDataDS/{id}")
	void getMTMDataDSItemById(@Path("id") String id, Callback<MTMDataDSItem> cb);

	@DELETE("/app/57f8d157a6690503002f972e/r/mTMDataDS/{id}")
  void deleteMTMDataDSItemById(@Path("id") String id, Callback<MTMDataDSItem> cb);

  @POST("/app/57f8d157a6690503002f972e/r/mTMDataDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<MTMDataDSItem>> cb);

  @POST("/app/57f8d157a6690503002f972e/r/mTMDataDS")
  void createMTMDataDSItem(@Body MTMDataDSItem item, Callback<MTMDataDSItem> cb);

  @PUT("/app/57f8d157a6690503002f972e/r/mTMDataDS/{id}")
  void updateMTMDataDSItem(@Path("id") String id, @Body MTMDataDSItem item, Callback<MTMDataDSItem> cb);

  @GET("/app/57f8d157a6690503002f972e/r/mTMDataDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
    
    @Multipart
    @POST("/app/57f8d157a6690503002f972e/r/mTMDataDS")
    void createMTMDataDSItem(
        @Part("data") MTMDataDSItem item,
        @Part("movieTheaterPhoto") TypedByteArray movieTheaterPhoto,
        Callback<MTMDataDSItem> cb);
    
    @Multipart
    @PUT("/app/57f8d157a6690503002f972e/r/mTMDataDS/{id}")
    void updateMTMDataDSItem(
        @Path("id") String id,
        @Part("data") MTMDataDSItem item,
        @Part("movieTheaterPhoto") TypedByteArray movieTheaterPhoto,
        Callback<MTMDataDSItem> cb);
}

