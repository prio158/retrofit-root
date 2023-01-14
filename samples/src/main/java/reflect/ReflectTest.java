package reflect;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


public class ReflectTest<K extends Serializable, V> {

  public String type = "ddd";

  @SuppressWarnings("unused")
  @InjectView(1)
  private K key1;

  @SuppressWarnings("unused")
  @InjectView(2)
  private V key2;

  @SuppressWarnings("unused")
  @InjectView(3)
  private HashMap<String, String> map;

  @SuppressWarnings("unused")
  @InjectView(4)
  private List<Integer> list;

  @SuppressWarnings("unused")
  @InjectView(5)
  private List<String>[] lists;

  public static void main(String[] args) throws IllegalAccessException {

    ReflectTest test1 = new ReflectTest<Serializable, String>();

    InjectUtils.injectGenericView(test1);


  }
}
