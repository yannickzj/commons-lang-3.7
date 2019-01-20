package org.apache.commons.lang3.mutable;
import java.lang.Number;
import static org.junit.Assert.assertEquals;
public class MutableTestTestCompareToTemplate {
  public static <TMutableNumber extends Number,T1>void mutableTestTestCompareToTemplate(  MutableTestTestCompareToAdapter<TMutableNumber> adapter,  Class<TMutableNumber> clazzTMutableNumber,  Class<T1> clazzT1) throws Exception {
    final TMutableNumber mutNum=clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(0);
    assertEquals(0,adapter.compareTo(mutNum,clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(0)));
    assertEquals(+1,adapter.compareTo(mutNum,clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(-1)));
    assertEquals(-1,adapter.compareTo(mutNum,clazzTMutableNumber.getDeclaredConstructor(clazzT1).newInstance(1)));
  }
}

interface MutableTestTestCompareToAdapter<TMutableNumber> {
	int compareTo(TMutableNumber tMutableNumber1, TMutableNumber tMutableNumber2);
}
