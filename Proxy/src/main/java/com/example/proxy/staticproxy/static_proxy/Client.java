package com.example.proxy.staticproxy.static_proxy;

public class Client {


  public static void main(String[] args) {

    ProxySubject agent = new ProxySubject();

    agent.message();

  }


}
