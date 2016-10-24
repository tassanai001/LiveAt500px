package com.example.tassanai.onlinecourse.liveat500px.manager.http;


import com.example.tassanai.onlinecourse.liveat500px.dao.PhotoItemCollectionDao;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Tassanai on 10/16/2016.
 */
public interface ApiService {

    @POST("list")
    Call<PhotoItemCollectionDao> loadPhotoList();
}