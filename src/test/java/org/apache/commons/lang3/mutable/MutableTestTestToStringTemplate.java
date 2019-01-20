package org.apache.commons.lang3.mutable;
import java.lang.String;
import static org.junit.Assert.assertEquals;
public class MutableTestTestToStringTemplate {
  public static <TMutableNumber,T1>void mutableTestTestToStringTemplate(  MutableTestTestToStringAdapter<TMutableNumber> adapter,  Class<TMutableNumber> clazzTMutableNumber,  Class<T1> clazzT1) throws Exception {
    assertEquals("0",adapter.toString(clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(0)));
    assertEquals("10",adapter.toString(clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(10)));
    assertEquals("-123",adapter.toString(clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(-123)));
  }
}

interface MutableTestTestToStringAdapter<TMutableNumber> {
	String toString(TMutableNumber tMutableNumber1);
}
