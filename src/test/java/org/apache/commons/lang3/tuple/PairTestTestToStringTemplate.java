package org.apache.commons.lang3.tuple;
import static org.junit.Assert.assertEquals;
import static org.apache.commons.lang3.tuple.ImmutablePair.of;
public class PairTestTestToStringTemplate {
  public static void pairTestTestToStringTemplate() throws Exception {
    assertEquals("(null,null)",ImmutablePair.of(null,null).toString());
    assertEquals("(null,two)",ImmutablePair.of(null,"two").toString());
    assertEquals("(one,null)",ImmutablePair.of("one",null).toString());
    assertEquals("(one,two)",ImmutablePair.of("one","two").toString());
  }
}
