package org.apache.commons.lang3.tuple;
import static org.junit.Assert.assertEquals;
import static org.apache.commons.lang3.tuple.ImmutableTriple.of;
import static org.apache.commons.lang3.tuple.MutableTriple.of;
public class TripleTestTestToStringTemplate {
  public static void tripleTestTestToStringTemplate() throws Exception {
    assertEquals("(null,null,null)",ImmutableTriple.of(null,null,null).toString());
    assertEquals("(null,two,null)",ImmutableTriple.of(null,"two",null).toString());
    assertEquals("(one,null,null)",ImmutableTriple.of("one",null,null).toString());
    assertEquals("(one,two,null)",ImmutableTriple.of("one","two",null).toString());
    assertEquals("(null,two,three)",ImmutableTriple.of(null,"two","three").toString());
    assertEquals("(one,null,three)",ImmutableTriple.of("one",null,"three").toString());
    assertEquals("(one,two,three)",MutableTriple.of("one","two","three").toString());
  }
}
