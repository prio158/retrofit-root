package com.example.proxy.staticproxy.static_porxy_example;

public class RetrofitNetWork implements NetWorkProxy{


  @Override
  public void get() {
    System.out.println("Retrofit框架发起GET请求");
  }

  @Override
  public void post() {
    System.out.println("Retrofit框架发起POST请求");
  }
}
