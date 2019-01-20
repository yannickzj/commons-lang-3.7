/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3;

import java.lang.String;
import java.lang.CharSequence;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Unit tests {@link org.apache.commons.lang3.StringUtils} - StartsWith/EndsWith methods
 */
public class StringUtilsStartsEndsWithTest {
    private static final String foo    = "foo";
    private static final String bar    = "bar";
    private static final String foobar = "foobar";
    private static final String FOO    = "FOO";
    private static final String BAR    = "BAR";
    private static final String FOOBAR = "FOOBAR";

    //-----------------------------------------------------------------------

    /**
	 * Test StringUtils.startsWith()
	 */
	@Test
	public void testStartsWith() {
		this.stringUtilsStartsEndsWithTestTestStartsWithTemplate(
				new StringUtilsStartsEndsWithTestTestStartsWithAdapterImpl(), "startsWith(null, null)",
				"startsWith(FOOBAR, null)", "startsWith(null, FOO)", "startsWith(FOOBAR, \"\")",
				"startsWith(foobar, foo)", "startsWith(FOOBAR, FOO)", "startsWith(foobar, FOO)",
				"startsWith(FOOBAR, foo)", "startsWith(foo, foobar)", "startsWith(foo, foobar)",
				"startsWith(foobar, bar)", "startsWith(FOOBAR, BAR)", "startsWith(foobar, BAR)",
				"startsWith(FOOBAR, bar)");
	}

    /**
	 * Test StringUtils.testStartsWithIgnoreCase()
	 */
	@Test
	public void testStartsWithIgnoreCase() {
		this.stringUtilsStartsEndsWithTestTestStartsWithTemplate(
				new StringUtilsStartsEndsWithTestTestStartsWithIgnoreCaseAdapterImpl(),
				"startsWithIgnoreCase(null, null)", "startsWithIgnoreCase(FOOBAR, null)",
				"startsWithIgnoreCase(null, FOO)", "startsWithIgnoreCase(FOOBAR, \"\")",
				"startsWithIgnoreCase(foobar, foo)", "startsWithIgnoreCase(FOOBAR, FOO)",
				"startsWithIgnoreCase(foobar, FOO)", "startsWithIgnoreCase(FOOBAR, foo)",
				"startsWithIgnoreCase(foo, foobar)", "startsWithIgnoreCase(foo, foobar)",
				"startsWithIgnoreCase(foobar, bar)", "startsWithIgnoreCase(FOOBAR, BAR)",
				"startsWithIgnoreCase(foobar, BAR)", "startsWithIgnoreCase(FOOBAR, bar)");
	}

    @Test
    public void testStartsWithAny() {
        assertFalse(StringUtils.startsWithAny(null, (String[])null));
        assertFalse(StringUtils.startsWithAny(null, "abc"));
        assertFalse(StringUtils.startsWithAny("abcxyz", (String[])null));
        assertFalse(StringUtils.startsWithAny("abcxyz"));
        assertTrue(StringUtils.startsWithAny("abcxyz", "abc"));
        assertTrue(StringUtils.startsWithAny("abcxyz", null, "xyz", "abc"));
        assertFalse(StringUtils.startsWithAny("abcxyz", null, "xyz", "abcd"));
        assertTrue(StringUtils.startsWithAny("abcxyz", new String[]{""}));
        assertFalse(StringUtils.startsWithAny("abcxyz", null, "xyz", "ABCX"));
        assertFalse(StringUtils.startsWithAny("ABCXYZ", null, "xyz", "abc"));

        assertTrue("StringUtils.startsWithAny(abcxyz, StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny("abcxyz", new StringBuilder("xyz"), new StringBuffer("abc")));
        assertTrue("StringUtils.startsWithAny(StringBuffer(abcxyz), StringBuilder(xyz), StringBuffer(abc))", StringUtils.startsWithAny(new StringBuffer("abcxyz"), new StringBuilder("xyz"), new StringBuffer("abc")));
    }


    /**
     * Test StringUtils.endsWith()
     */
    @Test
    public void testEndsWith() {
        assertTrue("endsWith(null, null)",    StringUtils.endsWith(null, null));
        assertFalse("endsWith(FOOBAR, null)", StringUtils.endsWith(FOOBAR, null));
        assertFalse("endsWith(null, FOO)",    StringUtils.endsWith(null, FOO));
        assertTrue("endsWith(FOOBAR, \"\")",  StringUtils.endsWith(FOOBAR, ""));

        assertFalse("endsWith(foobar, foo)", StringUtils.endsWith(foobar, foo));
        assertFalse("endsWith(FOOBAR, FOO)", StringUtils.endsWith(FOOBAR, FOO));
        assertFalse("endsWith(foobar, FOO)", StringUtils.endsWith(foobar, FOO));
        assertFalse("endsWith(FOOBAR, foo)", StringUtils.endsWith(FOOBAR, foo));

        assertFalse("endsWith(foo, foobar)", StringUtils.endsWith(foo, foobar));
        assertFalse("endsWith(foo, foobar)", StringUtils.endsWith(bar, foobar));

        assertTrue("endsWith(foobar, bar)",  StringUtils.endsWith(foobar, bar));
        assertTrue("endsWith(FOOBAR, BAR)",  StringUtils.endsWith(FOOBAR, BAR));
        assertFalse("endsWith(foobar, BAR)", StringUtils.endsWith(foobar, BAR));
        assertFalse("endsWith(FOOBAR, bar)", StringUtils.endsWith(FOOBAR, bar));

        // "alpha,beta,gamma,delta".endsWith("delta")
        assertTrue("endsWith(\u03B1\u03B2\u03B3\u03B4, \u03B4)",
                StringUtils.endsWith("\u03B1\u03B2\u03B3\u03B4", "\u03B4"));
        // "alpha,beta,gamma,delta".endsWith("gamma,DELTA")
        assertFalse("endsWith(\u03B1\u03B2\u03B3\u03B4, \u03B3\u0394)",
                StringUtils.endsWith("\u03B1\u03B2\u03B3\u03B4", "\u03B3\u0394"));
    }

    /**
     * Test StringUtils.endsWithIgnoreCase()
     */
    @Test
    public void testEndsWithIgnoreCase() {
        assertTrue("endsWithIgnoreCase(null, null)",    StringUtils.endsWithIgnoreCase(null, null));
        assertFalse("endsWithIgnoreCase(FOOBAR, null)", StringUtils.endsWithIgnoreCase(FOOBAR, null));
        assertFalse("endsWithIgnoreCase(null, FOO)",    StringUtils.endsWithIgnoreCase(null, FOO));
        assertTrue("endsWithIgnoreCase(FOOBAR, \"\")",  StringUtils.endsWithIgnoreCase(FOOBAR, ""));

        assertFalse("endsWithIgnoreCase(foobar, foo)", StringUtils.endsWithIgnoreCase(foobar, foo));
        assertFalse("endsWithIgnoreCase(FOOBAR, FOO)", StringUtils.endsWithIgnoreCase(FOOBAR, FOO));
        assertFalse("endsWithIgnoreCase(foobar, FOO)", StringUtils.endsWithIgnoreCase(foobar, FOO));
        assertFalse("endsWithIgnoreCase(FOOBAR, foo)", StringUtils.endsWithIgnoreCase(FOOBAR, foo));

        assertFalse("endsWithIgnoreCase(foo, foobar)", StringUtils.endsWithIgnoreCase(foo, foobar));
        assertFalse("endsWithIgnoreCase(foo, foobar)", StringUtils.endsWithIgnoreCase(bar, foobar));

        assertTrue("endsWithIgnoreCase(foobar, bar)", StringUtils.endsWithIgnoreCase(foobar, bar));
        assertTrue("endsWithIgnoreCase(FOOBAR, BAR)", StringUtils.endsWithIgnoreCase(FOOBAR, BAR));
        assertTrue("endsWithIgnoreCase(foobar, BAR)", StringUtils.endsWithIgnoreCase(foobar, BAR));
        assertTrue("endsWithIgnoreCase(FOOBAR, bar)", StringUtils.endsWithIgnoreCase(FOOBAR, bar));

        // javadoc
        assertTrue(StringUtils.endsWithIgnoreCase("abcdef", "def"));
        assertTrue(StringUtils.endsWithIgnoreCase("ABCDEF", "def"));
        assertFalse(StringUtils.endsWithIgnoreCase("ABCDEF", "cde"));

        // "alpha,beta,gamma,delta".endsWith("DELTA")
        assertTrue("endsWith(\u03B1\u03B2\u03B3\u03B4, \u0394)",
                StringUtils.endsWithIgnoreCase("\u03B1\u03B2\u03B3\u03B4", "\u0394"));
        // "alpha,beta,gamma,delta".endsWith("GAMMA")
        assertFalse("endsWith(\u03B1\u03B2\u03B3\u03B4, \u0393)",
                StringUtils.endsWithIgnoreCase("\u03B1\u03B2\u03B3\u03B4", "\u0393"));
    }

    @Test
    public void testEndsWithAny() {
        assertFalse("StringUtils.endsWithAny(null, null)", StringUtils.endsWithAny(null, (String)null));
        assertFalse("StringUtils.endsWithAny(null, new String[] {abc})", StringUtils.endsWithAny(null, new String[] {"abc"}));
        assertFalse("StringUtils.endsWithAny(abcxyz, null)", StringUtils.endsWithAny("abcxyz", (String)null));
        assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {\"\"})", StringUtils.endsWithAny("abcxyz", new String[] {""}));
        assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {xyz})", StringUtils.endsWithAny("abcxyz", new String[] {"xyz"}));
        assertTrue("StringUtils.endsWithAny(abcxyz, new String[] {null, xyz, abc})", StringUtils.endsWithAny("abcxyz", new String[] {null, "xyz", "abc"}));
        assertFalse("StringUtils.endsWithAny(defg, new String[] {null, xyz, abc})", StringUtils.endsWithAny("defg", new String[] {null, "xyz", "abc"}));
        assertTrue(StringUtils.endsWithAny("abcXYZ", "def", "XYZ"));
        assertFalse(StringUtils.endsWithAny("abcXYZ", "def", "xyz"));
        assertTrue(StringUtils.endsWithAny("abcXYZ", "def", "YZ"));

        /*
         * Type null of the last argument to method endsWithAny(CharSequence, CharSequence...)
         * doesn't exactly match the vararg parameter type.
         * Cast to CharSequence[] to confirm the non-varargs invocation,
         * or pass individual arguments of type CharSequence for a varargs invocation.
         *
         * assertFalse(StringUtils.endsWithAny("abcXYZ", null)); // replace with specific types to avoid warning
         */
        assertFalse(StringUtils.endsWithAny("abcXYZ", (CharSequence) null));
        assertFalse(StringUtils.endsWithAny("abcXYZ", (CharSequence[]) null));
        assertTrue(StringUtils.endsWithAny("abcXYZ", ""));

        assertTrue("StringUtils.endsWithAny(abcxyz, StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny("abcxyz", new StringBuilder("abc"), new StringBuffer("xyz")));
        assertTrue("StringUtils.endsWithAny(StringBuffer(abcxyz), StringBuilder(abc), StringBuffer(xyz))", StringUtils.endsWithAny(new StringBuffer("abcxyz"), new StringBuilder("abc"), new StringBuffer("xyz")));
    }

	public void stringUtilsStartsEndsWithTestTestStartsWithTemplate(
			StringUtilsStartsEndsWithTestTestStartsWithAdapter adapter, String string1, String string2, String string3,
			String string4, String string5, String string6, String string7, String string8, String string9,
			String string10, String string11, String string12, String string13, String string14) {
		assertTrue(string1, adapter.startsWith(null, null));
		assertFalse(string2, adapter.startsWith(FOOBAR, null));
		assertFalse(string3, adapter.startsWith(null, FOO));
		assertTrue(string4, adapter.startsWith(FOOBAR, ""));
		assertTrue(string5, adapter.startsWith(foobar, foo));
		assertTrue(string6, adapter.startsWith(FOOBAR, FOO));
		adapter.assertAction(string7, adapter.startsWith(foobar, FOO));
		adapter.assertAction(string8, adapter.startsWith(FOOBAR, foo));
		assertFalse(string9, adapter.startsWith(foo, foobar));
		assertFalse(string10, adapter.startsWith(bar, foobar));
		assertFalse(string11, adapter.startsWith(foobar, bar));
		assertFalse(string12, adapter.startsWith(FOOBAR, BAR));
		assertFalse(string13, adapter.startsWith(foobar, BAR));
		assertFalse(string14, adapter.startsWith(FOOBAR, bar));
	}

	interface StringUtilsStartsEndsWithTestTestStartsWithAdapter {
		boolean startsWith(CharSequence charSequence1, CharSequence charSequence2);

		void assertAction(String string1, boolean b1);
	}

	class StringUtilsStartsEndsWithTestTestStartsWithAdapterImpl
			implements StringUtilsStartsEndsWithTestTestStartsWithAdapter {
		public boolean startsWith(CharSequence charSequence1, CharSequence charSequence2) {
			return StringUtils.startsWith(charSequence1, charSequence2);
		}

		public void assertAction(String string1, boolean b1) {
			assertFalse(string1, b1);
		}
	}

	class StringUtilsStartsEndsWithTestTestStartsWithIgnoreCaseAdapterImpl
			implements StringUtilsStartsEndsWithTestTestStartsWithAdapter {
		public boolean startsWith(CharSequence charSequence1, CharSequence charSequence2) {
			return StringUtils.startsWithIgnoreCase(charSequence1, charSequence2);
		}

		public void assertAction(String string1, boolean b1) {
			assertTrue(string1, b1);
		}
	}


}
