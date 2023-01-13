package Annonation;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TestAnnotation {

  /*
   * 枚举类内存占用：对象头12字节+成员，还需8字节对齐
   * 所以下面枚举里面每个成员都是一个类，光对象头共占24字节
   * 所以枚举类特别占内存，所以为了降低内存占用，经常可以在源码中
   * 看到用常量代替枚举类
   * */


  public TestAnnotation(int id, String name) {
    System.out.println("id:" + id);
    System.out.println("name:" + name);
  }

  enum WeekDay1 {
    SUNDAY,
    MONDAY
  }


  /*用常量代替枚举类*/
  public static final int SUNDAY1 = 0;
  public static final int MONDAY1 = 1;

  /*用枚举类作为参数，限定用户传入参数类型*/
  public static void setDay(TestAnnotation.WeekDay1 day) {
  }

  /*为了节省内存,用int替换枚举，但用户可能懵逼，不知道该怎么传
   * 我希望用户能够知道传入：
   *    static final int SUNDAY1 = 0;
   *    static final int MONDAY1 = 1;
   * 借助@IntDef,实现语法检查，帮助用户传入参数
   * */
  public static final int SUNDAY2 = 0;
  public static final int MONDAY2 = 1;

  @IntDef({SUNDAY2, MONDAY2})
  @Target({ElementType.FIELD, ElementType.PARAMETER})
  @Retention(RetentionPolicy.SOURCE)
  @interface WeekDay2 {
  }

  public static void setDay2(@WeekDay2 int day) {

  }

  public static void main(String[] args) {
    setDay2(SUNDAY2);
    ANN ann = new ANN();
    ann.printInfo();
    ann.setDrawable(23);
  }
}

@CZR(value = "name", page = "home")
class ANN {


  //参数注解
  public void setDrawable(@CZR(value = "czr", page = "distance") int id) {

  }

  public void printInfo() {
    System.out.println("------------");
  }


}

