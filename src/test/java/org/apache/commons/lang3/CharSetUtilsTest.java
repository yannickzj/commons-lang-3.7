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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.CharSetUtils}.
 */
public class CharSetUtilsTest  {

    //-----------------------------------------------------------------------
    @Test
    public void testConstructor() {
        assertNotNull(new CharSetUtils());
        final Constructor<?>[] cons = CharSetUtils.class.getDeclaredConstructors();
        assertEquals(1, cons.length);
        assertTrue(Modifier.isPublic(cons[0].getModifiers()));
        assertTrue(Modifier.isPublic(CharSetUtils.class.getModifiers()));
        assertFalse(Modifier.isFinal(CharSetUtils.class.getModifiers()));
    }

    @Test
	public void testSqueeze_StringString() {
		this.charSetUtilsTestTestStringStringTemplate(new CharSetUtilsTestTestSqueeze_StringStringAdapterImpl(),
				"hello", "hello", "a-e", "helo", "l-p", "heloo", "helloo", "l", "helloo", "^l");
	}

    @Test
    public void testSqueeze_StringStringarray() {
        assertNull(CharSetUtils.squeeze(null, (String[]) null));
        assertNull(CharSetUtils.squeeze(null, new String[0]));
        assertNull(CharSetUtils.squeeze(null, new String[] {null}));
        assertNull(CharSetUtils.squeeze(null, new String[] {"el"}));

        assertEquals("", CharSetUtils.squeeze("", (String[]) null));
        assertEquals("", CharSetUtils.squeeze(""));
        assertEquals("", CharSetUtils.squeeze("", new String[] {null}));
        assertEquals("", CharSetUtils.squeeze("", "a-e"));

        assertEquals("hello", CharSetUtils.squeeze("hello", (String[]) null));
        assertEquals("hello", CharSetUtils.squeeze("hello"));
        assertEquals("hello", CharSetUtils.squeeze("hello", new String[] {null}));
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));

        assertEquals("helo", CharSetUtils.squeeze("hello", "el"));
        assertEquals("hello", CharSetUtils.squeeze("hello", "e"));
        assertEquals("fofof", CharSetUtils.squeeze("fooffooff", "of"));
        assertEquals("fof", CharSetUtils.squeeze("fooooff", "fo"));
    }

    //-----------------------------------------------------------------------
    @Test
    public void testContainsAny_StringString() {
        assertFalse(CharSetUtils.containsAny(null, (String) null));
        assertFalse(CharSetUtils.containsAny(null, ""));

        assertFalse(CharSetUtils.containsAny("", (String) null));
        assertFalse(CharSetUtils.containsAny("", ""));
        assertFalse(CharSetUtils.containsAny("", "a-e"));

        assertFalse(CharSetUtils.containsAny("hello", (String) null));
        assertFalse(CharSetUtils.containsAny("hello", ""));
        assertTrue(CharSetUtils.containsAny("hello", "a-e"));
        assertTrue(CharSetUtils.containsAny("hello", "l-p"));
    }

    @Test
    public void testContainsAny_StringStringarray() {
        assertFalse(CharSetUtils.containsAny(null, (String[]) null));
        assertFalse(CharSetUtils.containsAny(null));
        assertFalse(CharSetUtils.containsAny(null, new String[] {null}));
        assertFalse(CharSetUtils.containsAny(null, "a-e"));

        assertFalse(CharSetUtils.containsAny("", (String[]) null));
        assertFalse(CharSetUtils.containsAny(""));
        assertFalse(CharSetUtils.containsAny("", new String[] {null}));
        assertFalse(CharSetUtils.containsAny("", "a-e"));

        assertFalse(CharSetUtils.containsAny("hello", (String[]) null));
        assertFalse(CharSetUtils.containsAny("hello"));
        assertFalse(CharSetUtils.containsAny("hello", new String[] {null}));
        assertTrue(CharSetUtils.containsAny("hello", "a-e"));

        assertTrue(CharSetUtils.containsAny("hello", "el"));
        assertFalse(CharSetUtils.containsAny("hello", "x"));
        assertTrue(CharSetUtils.containsAny("hello", "e-i"));
        assertTrue(CharSetUtils.containsAny("hello", "a-z"));
        assertFalse(CharSetUtils.containsAny("hello", ""));
    }

    //-----------------------------------------------------------------------
    @Test
    public void testCount_StringString() {
        assertEquals(0, CharSetUtils.count(null, (String) null));
        assertEquals(0, CharSetUtils.count(null, ""));

        assertEquals(0, CharSetUtils.count("", (String) null));
        assertEquals(0, CharSetUtils.count("", ""));
        assertEquals(0, CharSetUtils.count("", "a-e"));

        assertEquals(0, CharSetUtils.count("hello", (String) null));
        assertEquals(0, CharSetUtils.count("hello", ""));
        assertEquals(1, CharSetUtils.count("hello", "a-e"));
        assertEquals(3, CharSetUtils.count("hello", "l-p"));
    }

    @Test
    public void testCount_StringStringarray() {
        assertEquals(0, CharSetUtils.count(null, (String[]) null));
        assertEquals(0, CharSetUtils.count(null));
        assertEquals(0, CharSetUtils.count(null, new String[] {null}));
        assertEquals(0, CharSetUtils.count(null, "a-e"));

        assertEquals(0, CharSetUtils.count("", (String[]) null));
        assertEquals(0, CharSetUtils.count(""));
        assertEquals(0, CharSetUtils.count("", new String[] {null}));
        assertEquals(0, CharSetUtils.count("", "a-e"));

        assertEquals(0, CharSetUtils.count("hello", (String[]) null));
        assertEquals(0, CharSetUtils.count("hello"));
        assertEquals(0, CharSetUtils.count("hello", new String[] {null}));
        assertEquals(1, CharSetUtils.count("hello", "a-e"));

        assertEquals(3, CharSetUtils.count("hello", "el"));
        assertEquals(0, CharSetUtils.count("hello", "x"));
        assertEquals(2, CharSetUtils.count("hello", "e-i"));
        assertEquals(5, CharSetUtils.count("hello", "a-z"));
        assertEquals(0, CharSetUtils.count("hello", ""));
    }

    @Test
	public void testKeep_StringString() {
		this.charSetUtilsTestTestStringStringTemplate(new CharSetUtilsTestTestKeep_StringStringAdapterImpl(), "", "",
				"a-z", "", "xyz", "ell", "hello", "el", "hello", "oleh");
	}

    @Test
    public void testKeep_StringStringarray() {
        assertNull(CharSetUtils.keep(null, (String[]) null));
        assertNull(CharSetUtils.keep(null, new String[0]));
        assertNull(CharSetUtils.keep(null, new String[] {null}));
        assertNull(CharSetUtils.keep(null, new String[] {"a-e"}));

        assertEquals("", CharSetUtils.keep("", (String[]) null));
        assertEquals("", CharSetUtils.keep(""));
        assertEquals("", CharSetUtils.keep("", new String[] {null}));
        assertEquals("", CharSetUtils.keep("", "a-e"));

        assertEquals("", CharSetUtils.keep("hello", (String[]) null));
        assertEquals("", CharSetUtils.keep("hello"));
        assertEquals("", CharSetUtils.keep("hello", new String[] {null}));
        assertEquals("e", CharSetUtils.keep("hello", "a-e"));

        assertEquals("e", CharSetUtils.keep("hello", "a-e"));
        assertEquals("ell", CharSetUtils.keep("hello", "el"));
        assertEquals("hello", CharSetUtils.keep("hello", "elho"));
        assertEquals("hello", CharSetUtils.keep("hello", "a-z"));
        assertEquals("----", CharSetUtils.keep("----", "-"));
        assertEquals("ll", CharSetUtils.keep("hello", "l"));
    }

    //-----------------------------------------------------------------------
    @Test
    public void testDelete_StringString() {
        assertNull(CharSetUtils.delete(null, (String) null));
        assertNull(CharSetUtils.delete(null, ""));

        assertEquals("", CharSetUtils.delete("", (String) null));
        assertEquals("", CharSetUtils.delete("", ""));
        assertEquals("", CharSetUtils.delete("", "a-e"));

        assertEquals("hello", CharSetUtils.delete("hello", (String) null));
        assertEquals("hello", CharSetUtils.delete("hello", ""));
        assertEquals("hllo", CharSetUtils.delete("hello", "a-e"));
        assertEquals("he", CharSetUtils.delete("hello", "l-p"));
        assertEquals("hello", CharSetUtils.delete("hello", "z"));
    }

    @Test
    public void testDelete_StringStringarray() {
        assertNull(CharSetUtils.delete(null, (String[]) null));
        assertNull(CharSetUtils.delete(null, new String[0]));
        assertNull(CharSetUtils.delete(null, new String[] {null}));
        assertNull(CharSetUtils.delete(null, new String[] {"el"}));

        assertEquals("", CharSetUtils.delete("", (String[]) null));
        assertEquals("", CharSetUtils.delete(""));
        assertEquals("", CharSetUtils.delete("", new String[] {null}));
        assertEquals("", CharSetUtils.delete("", "a-e"));

        assertEquals("hello", CharSetUtils.delete("hello", (String[]) null));
        assertEquals("hello", CharSetUtils.delete("hello"));
        assertEquals("hello", CharSetUtils.delete("hello", new String[] {null}));
        assertEquals("hello", CharSetUtils.delete("hello", "xyz"));

        assertEquals("ho", CharSetUtils.delete("hello", "el"));
        assertEquals("", CharSetUtils.delete("hello", "elho"));
        assertEquals("hello", CharSetUtils.delete("hello", ""));
        assertEquals("hello", CharSetUtils.delete("hello", ""));
        assertEquals("", CharSetUtils.delete("hello", "a-z"));
        assertEquals("", CharSetUtils.delete("----", "-"));
        assertEquals("heo", CharSetUtils.delete("hello", "l"));
    }

	public void charSetUtilsTestTestStringStringTemplate(CharSetUtilsTestTestStringStringAdapter adapter,
			String string1, String string2, String string3, String string4, String string5, String string6,
			String string7, String string8, String string9, String string10) {
		assertNull(adapter.action1(null, (String) null));
		assertNull(adapter.action1(null, ""));
		assertEquals("", adapter.action1("", (String) null));
		assertEquals("", adapter.action1("", ""));
		assertEquals("", adapter.action1("", "a-e"));
		assertEquals(string1, adapter.action1("hello", (String) null));
		assertEquals(string2, adapter.action1("hello", ""));
		assertEquals("hello", adapter.action1("hello", string3));
		assertEquals(string4, adapter.action1("hello", string5));
		assertEquals(string6, adapter.action1(string7, string8));
		assertEquals("hello", adapter.action1(string9, string10));
	}

	interface CharSetUtilsTestTestStringStringAdapter {
		String action1(String string1, String... stringArray1);
	}

	class CharSetUtilsTestTestSqueeze_StringStringAdapterImpl implements CharSetUtilsTestTestStringStringAdapter {
		public String action1(String string1, String... string2) {
			return CharSetUtils.squeeze(string1, string2);
		}
	}

	class CharSetUtilsTestTestKeep_StringStringAdapterImpl implements CharSetUtilsTestTestStringStringAdapter {
		public String action1(String string1, String... string2) {
			return CharSetUtils.keep(string1, string2);
		}
	}

}
