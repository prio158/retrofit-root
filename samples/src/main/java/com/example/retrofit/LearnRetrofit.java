package com.example.retrofit;


import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LearnRetrofit {

  private static final String TAG = "LearnRetrofit";
  private static final OkHttpClient okHttpClient = new OkHttpClient();

  public static void main(String[] args) {

    Retrofit retrofit = new Retrofit.Builder()
      .baseUrl("https://www.wanandroid.com/")
      .addConverterFactory(GsonConverterFactory.create())
      .client(okHttpClient)
      .build();

    ServiceApi mServiceApi = retrofit.create(ServiceApi.class);

    Call<ProjectBean> call = mServiceApi.getProject();

    call.enqueue(new Callback<ProjectBean>() {
      @Override
      public void onResponse(Call<ProjectBean> call, Response<ProjectBean> response) {
        System.out.println(response);
      }

      @Override
      public void onFailure(Call<ProjectBean> call, Throwable t) {

      }
    });

  }


}
