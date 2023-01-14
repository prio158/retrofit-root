package com.example.proxy.staticproxy.static_proxy;


/*
 * 这个代理对象也是实现了Proxy接口
 * 代理作用是什么？
 *         创建一个隔离层，降低模块耦合度
 *         例子：在早期，要进行网络请求，使用Volley框架，但后来想换成Retrofit框架
 *         如果 Client ---直接依赖---> Volley，那么你要切换到Retrofit框架就很麻烦
 *         如果 Client ---> Proxy ---> Volley,
 *
 *                               Client网络请求
 *
 *          代理层（隔离层）: 实现Interface接口，里面维护一个成员HttpRequest代理对象（实现Interface接口）
 *
 *          实际对象：Volley封装层     Retrofit封装层   ====》 封装层实现Interface接口
 *                      ｜｜              ｜｜
 *                     Volley          Retrofit
 *        那么这个时候，如果要将Volley替换为Retrofit框架，只需要将隔离层HttpRequest代理对象
 *        赋值为Retrofit封装层对象
 *
 * */
public class ProxySubject implements Proxy {

  private Proxy realProxy = new RealSubject();

  public ProxySubject(Proxy proxy) {
    this.realProxy = proxy;
  }

  public ProxySubject() {

  }

  @Override
  public void message() {
    System.out.println("我是代理，下面开始操作：");
    System.out.println("Before");
    realProxy.message();
    System.out.println("after");
  }
}
