package com.example.proxy.staticproxy.static_proxy;


/*
 * 静态代理：
 *    代理层 ------------------------------> Interface Proxy
 *        代理层持有ProxySubject              implement
 *                        ProxySubject(代理对象) ---代理---> RealSubject(真实对象)
 *
 *
 *  静态代理的问题：如果还要加其他功能，又要加接口
 *     public class ProxySubject implements Proxy,OtherProxy
 *  久而久之，随着要实现的功能增多，代理接口会逐步增多，一个代理类实现全部代理接口，难以维护
 *  所以需要动态代理
 * */
public interface Proxy {
  void message();

}
