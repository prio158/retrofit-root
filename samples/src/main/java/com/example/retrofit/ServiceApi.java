package com.example.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/*
 * 请求后台访问数据的接口类
 * */
public interface ServiceApi {

  @GET("project/tree/json")
  Call<ProjectBean> getProject();


}
