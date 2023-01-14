package com.example.proxy.staticproxy.static_porxy_example;

public class Client {

  public static void main(String[] args) {


    NetWorkRequest retrofitRequest = new NetWorkRequest(new RetrofitNetWork());
    retrofitRequest.get();
    retrofitRequest.post();

    NetWorkRequest volleyRequest = new NetWorkRequest(new VolleyNetWork());
    volleyRequest.get();
    volleyRequest.post();

  }
}
