package org.apache.commons.lang3.tuple;
import static org.junit.Assert.assertEquals;
import static org.apache.commons.lang3.tuple.ImmutablePair.of;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class PairTestTestEqualsTemplate {
  public static <TPairStringString extends Pair<String,String>>void pairTestTestEqualsTemplate() throws Exception {
    assertEquals(ImmutablePair.of(null,"foo"),ImmutablePair.of(null,"foo"));
    assertFalse(ImmutablePair.of("foo",0).equals(ImmutablePair.of("foo",null)));
    assertFalse(ImmutablePair.of("foo","bar").equals(ImmutablePair.of("xyz","bar")));
    final TPairStringString p=(TPairStringString)ImmutablePair.of("foo","bar");
    assertTrue(p.equals(p));
    assertFalse(p.equals(new Object()));
  }
}
