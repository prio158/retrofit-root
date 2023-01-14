package com.example.proxy.staticproxy.dynamic_proxy;

public class ProxyImpl implements Proxy1,Proxy2{

	@Override
	public void doSomeThing1() {
		System.out.println("Proxy1实现");
	}

	@Override
	public void doSomeThing2() {
		System.out.println("Proxy2实现");
	}
}
