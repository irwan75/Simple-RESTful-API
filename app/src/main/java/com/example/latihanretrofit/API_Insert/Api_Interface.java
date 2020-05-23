package com.example.latihanretrofit.API_Insert;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api_Interface {

    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseBody> insertDataa(
        @Field("title") String title,
        @Field("nama") String nama,
        @Field("note") String note
    );

    @GET("read.php")
    Call<List<DAO_Value>> getData();

}
