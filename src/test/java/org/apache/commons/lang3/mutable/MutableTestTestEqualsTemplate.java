package org.apache.commons.lang3.mutable;
import java.lang.Number;
import java.lang.Object;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class MutableTestTestEqualsTemplate {
  public static <TMutableNumber extends Number,T1>void mutableTestTestEqualsTemplate(  MutableTestTestEqualsAdapter<TMutableNumber> adapter,  Class<TMutableNumber> clazzTMutableNumber,  Class<T1> clazzT1) throws Exception {
    final TMutableNumber mutNumA=clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance((byte)0);
    final TMutableNumber mutNumB=clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance((byte)0);
    final TMutableNumber mutNumC=clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance((byte)1);
    assertTrue(adapter.equals(mutNumA,mutNumA));
    assertTrue(adapter.equals(mutNumA,mutNumB));
    assertTrue(adapter.equals(mutNumB,mutNumA));
    assertTrue(adapter.equals(mutNumB,mutNumB));
    assertFalse(adapter.equals(mutNumA,mutNumC));
    assertFalse(adapter.equals(mutNumB,mutNumC));
    assertTrue(adapter.equals(mutNumC,mutNumC));
    assertFalse(adapter.equals(mutNumA,null));
    assertFalse(adapter.equals(mutNumA,adapter.valueOf((byte)0)));
    assertFalse(adapter.equals(mutNumA,"0"));
  }
}

interface MutableTestTestEqualsAdapter<TMutableNumber> {
	boolean equals(TMutableNumber tMutableNumber1, Object object1);

	Number valueOf(byte byte1);
}
