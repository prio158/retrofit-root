package com.example.proxy.staticproxy.dynamic_proxy;


/*
 *  静态代理的问题：如果还要加其他功能，又要加接口
 *     public class ProxySubject implements Proxy,OtherProxy
 *  久而久之，随着要实现的功能增多，代理接口会逐步增多，一个代理类实现全部代理接口，难以维护
 *  所以需要动态代理，通过创建动态代理对象
 * */
public interface DynamicProxy {



}
