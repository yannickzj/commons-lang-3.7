package org.apache.commons.lang3.mutable;
import java.lang.Number;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class MutableTestTestHashCodeTemplate {
  public static <TMutableNumber extends Number,T1>void mutableTestTestHashCodeTemplate(  MutableTestTestHashCodeAdapter<TMutableNumber> adapter,  Class<TMutableNumber> clazzTMutableNumber,  Class<T1> clazzT1) throws Exception {
    final TMutableNumber mutNumA=clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(0);
    final TMutableNumber mutNumB=clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(0);
    final TMutableNumber mutNumC=clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(1);
    assertTrue(adapter.hashCode(mutNumA) == adapter.hashCode(mutNumA));
    assertTrue(adapter.hashCode(mutNumA) == adapter.hashCode(mutNumB));
    assertFalse(adapter.hashCode(mutNumA) == adapter.hashCode(mutNumC));
    assertTrue(adapter.hashCode(mutNumA) == adapter.hashCode1(adapter.valueOf(0)));
  }
}

interface MutableTestTestHashCodeAdapter<TMutableNumber> {
	int hashCode(TMutableNumber tMutableNumber1);

	Number valueOf(int i1);

	int hashCode1(Number number1);
}
