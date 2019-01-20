package org.apache.commons.lang3.mutable;
import java.lang.Double;
import java.lang.Number;
import static org.junit.Assert.assertTrue;
public class MutableTestTestNanInfiniteTemplate {
  public static <TMutableNumber extends Number,T1>void mutableTestTestNanInfiniteTemplate(  MutableTestTestNanInfiniteAdapter<TMutableNumber> adapter,  Class<TMutableNumber> clazzTMutableNumber,  Class<T1> clazzT1) throws Exception {
    TMutableNumber mutNum=clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(Double.NaN);
    assertTrue(adapter.isNaN(mutNum));
    mutNum=clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(Double.POSITIVE_INFINITY);
    assertTrue(adapter.isInfinite(mutNum));
    mutNum=clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(Double.NEGATIVE_INFINITY);
    assertTrue(adapter.isInfinite(mutNum));
  }
}

interface MutableTestTestNanInfiniteAdapter<TMutableNumber> {
	boolean isNaN(TMutableNumber tMutableNumber1);

	boolean isInfinite(TMutableNumber tMutableNumber1);
}
