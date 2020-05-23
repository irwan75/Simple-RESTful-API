package com.example.latihanretrofit.API_Insert;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String Base_URL = "https://artechgroup.000webhostapp.com/";
//    private static final String Base_URL = "https://localhost/";
    private static ApiClient apiClient;
    private static Retrofit retrofit;

    private ApiClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiClient getInstance(){
        if(apiClient == null){
            apiClient = new ApiClient();
        }
        return apiClient;
    }

    public Api_Interface getApi(){
        return retrofit.create(Api_Interface.class);
    }

}
