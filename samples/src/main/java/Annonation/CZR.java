package Annonation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target: 用于修饰Annotation 定义, 用于指定被修饰的Annotation 能用于修饰哪些程序元素。
// @Target 也包含一个名为value 的成员变量。
@Target({ElementType.TYPE,ElementType.PARAMETER})
// @Retention指定该Annotation 的生命周期
/*
* SOURCE:修饰的注解保留在源码阶段，经过javac编译后，这个注解会被抹除掉，在编译生成.class文件时不会保留这个类
* CLASS： 在编译生成.class文件时会保留这个类，当执行的时候就不会保留，不会加载到内存当中。
* RUNTIME：加载到JVM内存中。反射才能获取这个类
* */
@Retention(RetentionPolicy.SOURCE)
//下面的是自定义注解，上面的元注解：修饰注解的注解
public @interface CZR {
  String value() default "CZR"; //这里设置传入注解的值，如果没有这个值，注解就不需要传参

  //不用value,在使用的时候必须指定
  String page();

}

/*
* 注解的运行：
*  .java --> javac --> .class
*  javac:  1、在编译阶段，javac要解析java类， 比如下面的Example类
*          2、在这个过程中，就会采集到所有的注解信息，比如下面的CZR
*          3、将采集到的注解信息封装成一个节点 Element
*          4、Javac调用APT（注解处理器:CZRProcess是自定义的APT），对注解进行处理
*             也就是说在编译阶段，javac会实例化CZRProcess，并调用里面的process方法,对注解进行处理
* */
//@CZR(value = "name",page = "home")
//class Example{
//
//
//
//}
