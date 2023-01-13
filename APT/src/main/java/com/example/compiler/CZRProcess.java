package com.example.compiler;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

/*自定义注解处理器
* APT注解处理器
* APT全称为:"Anotation Processor Tools"，意为注解处理器。顾名思义，其用于处理注解。
* 编写好的Java源文件，需要经过 javac 的编译，翻译为虚拟机能够加载解析的字节码Class文件。
* 注解处理器是 javac 自带的一个工 具，用来在编译时期扫描处理注解信息。你可以为某些注解注册
* 自己的注解处理器。 注册的注解处理器由 javac 调起，并将注解信息传递给注解处理器进行处理。
* 注解处理器是对注解应用最为广泛的场景。在Glide、EventBus3、Butterknifer、Tinker、
* ARouter等等常用 框架中都有注解处理器的身影。但是你可能会发现，这些框架中对注解的定义并不是
* SOURCE 级别，更多的 是 CLASS 级别，别忘了:CLASS包含了SOURCE，RUNTIME包含SOURCE、CLASS。
* */
/*
 * 作用：在编译期能够获取注解与注解声明的类包括类中所有成员信息，一般用于生成额外的辅助类。ARouter
 * javac程序在编译期执行注解处理器，针对CZR这个注解，注意此时处在源码期：@Retention(RetentionPolicy.SOURCE)
 * */
@SupportedAnnotationTypes("Annonation.CZR")
public class CZRProcess extends AbstractProcessor {

  @Override
  public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
    Messager messager = processingEnv.getMessager();
    messager.printMessage(Diagnostic.Kind.NOTE, "=========");
    return false;
  }
}
