package com.example.proxy.staticproxy.static_proxy;

public class RealSubject implements Proxy {
  @Override
  public void message() {
    System.out.println("我是真实操作者");
  }
}
