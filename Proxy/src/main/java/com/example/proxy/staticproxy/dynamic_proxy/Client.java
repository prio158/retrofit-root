package com.example.proxy.staticproxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		ProxyImpl proxy = new ProxyImpl();

		/*
		 * newProxyInstance如何生成Object object
		 *  Java源文件 --> Javac --> .class文件（磁盘） --> 类加载器加载进JVM --> Class对象模版（JVM 内存） --> 实例化（内存）
		 *   ProxyClassFactory里面的方法会调用：
		 * 				1、ProxyGenerator.generateProxyClass方法生成文件的字节数组
		 *        2、根据byte[]数组通过io流操作，将其生成.class文件，在里面会里面的Proxy1和Proxy2接口方法进行hook
		 *           也就是将InvocationHandler接口的invoke方法hook进去，所以执行Proxy1和Proxy2接口方法时，会先
		 * 					 执行InvocationHandler接口的invoke方法。
		 *        3、加载进JVM内存中，然后实例化object出来 
		 *  */

		Object object = Proxy.newProxyInstance(ProxyImpl.class.getClassLoader(),
			new Class[]{Proxy1.class, Proxy2.class}, new InvocationHandler() {
				@Override
				public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
					System.out.println("invoke hook");
					return method.invoke(proxy, objects);
				}
			});

		String val = object.toString();
		Proxy1 proxy1 = (Proxy1) object;
		proxy1.doSomeThing1();
		Proxy2 proxy2 = (Proxy2) object;
		proxy2.doSomeThing2();

	}


}
