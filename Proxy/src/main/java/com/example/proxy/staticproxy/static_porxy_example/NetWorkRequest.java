package com.example.proxy.staticproxy.static_porxy_example;

public class NetWorkRequest implements NetWorkProxy {

  NetWorkProxy realNetWorkProxy;

  public NetWorkRequest(NetWorkProxy netWorkProxy) {
    this.realNetWorkProxy = netWorkProxy;
  }

  @Override
  public void get() {
    if (realNetWorkProxy != null) {
      realNetWorkProxy.get();
    }
  }

  @Override
  public void post() {
    if (realNetWorkProxy != null) {
      realNetWorkProxy.post();
    }

  }
}
