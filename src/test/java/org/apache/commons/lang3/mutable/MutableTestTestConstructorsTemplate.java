package org.apache.commons.lang3.mutable;
import static org.junit.Assert.assertEquals;
import java.lang.Double;
import java.lang.Number;
import java.lang.String;
public class MutableTestTestConstructorsTemplate {
  public static <TMutableNumber,T1>void mutableTestTestConstructorsTemplate(  MutableTestTestConstructorsAdapter<TMutableNumber> adapter,  double d1,  Class<TMutableNumber> clazzTMutableNumber,  double d2,  double d3,  Class<T1> clazzT1,  double d4,  double d5,  double d6,  double d7,  double d8,  double d9,  double d10) throws Exception {
    assertEquals(d1,adapter.value(clazzTMutableNumber.newInstance()),d2);
    assertEquals(d3,adapter.value(clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(1d)),d4);
    assertEquals(d5,adapter.value(clazzTMutableNumber.getDeclaredConstructor(Number.class).newInstance(Double.valueOf(2d))),d6);
    assertEquals(d7,adapter.value(clazzTMutableNumber.getDeclaredConstructor(Number.class).newInstance(new MutableDouble(3d))),d8);
    assertEquals(d9,adapter.value(clazzTMutableNumber.getDeclaredConstructor(String.class).newInstance("2.0")),d10);
  }
}

interface MutableTestTestConstructorsAdapter<TMutableNumber> {
	double value(TMutableNumber tMutableNumber1);
}
