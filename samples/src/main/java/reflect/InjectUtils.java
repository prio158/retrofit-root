package reflect;


import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import Annonation.TestAnnotation;

public class InjectUtils {

  /*获取一个类的指定属性*/
  public static void injectView(ReflectTest test) throws IllegalAccessException {

    Class<? extends ReflectTest> clazz = test.getClass();

    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      /*判断这个属性是否被InjectView注解标注*/
      if (field.isAnnotationPresent(InjectView.class)) {
        /*获取这个属性的注解*/
        InjectView ann = (InjectView) field.getAnnotation(InjectView.class);
        /*获取这个注解的值*/
        int id = ann.value();
        System.out.println("ID：" + id);
        /*操作注解修饰的属性*/
        field.setAccessible(true); //设置访问权限，允许操作private的属性
        field.set(clazz, new TestAnnotation(23, "czr")); //设置这个属性

      }
    }
  }

  /*获取对应属性的泛型类型*/
  public static void injectGenericView(ReflectTest test) {
    Class<? extends ReflectTest> clazz = test.getClass();
    Field[] Fields = clazz.getDeclaredFields();
    for (Field field : Fields) {
      if (field.isAnnotationPresent(InjectView.class)) {

        InjectView ann = field.getAnnotation(InjectView.class);
        int id = ann.value();
        /*TypeVariable： 泛型类型变量。可以泛型上下限等信息;*/
        if (field.getGenericType() instanceof TypeVariable) {
          System.out.println("TypeVariable：");
          TypeVariable keyType = (TypeVariable) field.getGenericType();
          System.out.println(keyType.getName() + " ID:" + id);//getName：输出K，V，即泛型代名
          System.out.println(keyType.getGenericDeclaration()); //获取这个属性的类名
          for (Type type : keyType.getBounds()) {
            System.out.println(type.getTypeName());
          }
        }

        if (field.getGenericType() instanceof ParameterizedType) {
          System.out.println("ParameterizedType：");
          /*获取具体的泛型类型*/
          ParameterizedType pType = (ParameterizedType) field.getGenericType();
          //System.out.println(pType.getRawType() + " ID:" + id);
          for (Type type : pType.getActualTypeArguments()) {
            System.out.println(type.getTypeName() + " ID:" + id);
          }
        }

        if(field.getGenericType() instanceof GenericArrayType){
          System.out.println("GenericArrayType:");
          GenericArrayType genericType = (GenericArrayType) field.getGenericType();
          System.out.println(genericType.getGenericComponentType() + " ID:" + id);
        }


        System.out.println("---------------");


      }
    }


  }

}
