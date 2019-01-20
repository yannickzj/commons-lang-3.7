package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyleTest.Person;
import java.lang.String;
import java.lang.Integer;
import java.lang.System;
import static org.junit.Assert.assertEquals;
public class ToStringStyleTestTestPersonTemplate {
  public static void toStringStyleTestTestPersonTemplate(  String string1,  int i1,  String string2){
    final Person p=new Person();
    p.name=string1;
    p.age=i1;
    p.smoker=false;
    final String pBaseStr=p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p));
    assertEquals(pBaseStr + string2,new ToStringBuilder(p).append("name",p.name).append("age",p.age).append("smoker",p.smoker).toString());
  }
}
