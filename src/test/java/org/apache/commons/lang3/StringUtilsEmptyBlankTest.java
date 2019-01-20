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

import java.lang.CharSequence;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.StringUtils} - Empty/Blank methods
 */
public class StringUtilsEmptyBlankTest  {

    @Test
    public void testIsEmpty() {
        assertTrue(StringUtils.isEmpty(null));
        assertTrue(StringUtils.isEmpty(""));
        assertFalse(StringUtils.isEmpty(" "));
        assertFalse(StringUtils.isEmpty("foo"));
        assertFalse(StringUtils.isEmpty("  foo  "));
    }

    @Test
    public void testIsNotEmpty() {
        assertFalse(StringUtils.isNotEmpty(null));
        assertFalse(StringUtils.isNotEmpty(""));
        assertTrue(StringUtils.isNotEmpty(" "));
        assertTrue(StringUtils.isNotEmpty("foo"));
        assertTrue(StringUtils.isNotEmpty("  foo  "));
    }

    @Test
	public void testIsAnyEmpty() {
		this.stringUtilsEmptyBlankTestTestIsEmptyTemplate(new StringUtilsEmptyBlankTestTestIsAnyEmptyAdapterImpl());
	}

    @Test
	public void testIsNoneEmpty() {
		this.stringUtilsEmptyBlankTestTestIsEmptyTemplate(new StringUtilsEmptyBlankTestTestIsNoneEmptyAdapterImpl());
	}

    @Test
    public void testIsAllEmpty() {
        assertTrue(StringUtils.isAllEmpty());
        assertTrue(StringUtils.isAllEmpty(new String[]{}));
        assertTrue(StringUtils.isAllEmpty((String) null));
        assertTrue(StringUtils.isAllEmpty((String[]) null));
        assertFalse(StringUtils.isAllEmpty(null, "foo"));
        assertFalse(StringUtils.isAllEmpty("", "bar"));
        assertFalse(StringUtils.isAllEmpty("bob", ""));
        assertFalse(StringUtils.isAllEmpty("  bob  ", null));
        assertFalse(StringUtils.isAllEmpty(" ", "bar"));
        assertFalse(StringUtils.isAllEmpty("foo", "bar"));
        assertTrue(StringUtils.isAllEmpty("", null));
    }

    @Test
    public void testIsBlank() {
        assertTrue(StringUtils.isBlank(null));
        assertTrue(StringUtils.isBlank(""));
        assertTrue(StringUtils.isBlank(StringUtilsTest.WHITESPACE));
        assertFalse(StringUtils.isBlank("foo"));
        assertFalse(StringUtils.isBlank("  foo  "));
    }

    @Test
    public void testIsNotBlank() {
        assertFalse(StringUtils.isNotBlank(null));
        assertFalse(StringUtils.isNotBlank(""));
        assertFalse(StringUtils.isNotBlank(StringUtilsTest.WHITESPACE));
        assertTrue(StringUtils.isNotBlank("foo"));
        assertTrue(StringUtils.isNotBlank("  foo  "));
    }

    @Test
	public void testIsAnyBlank() {
		this.stringUtilsEmptyBlankTestTestIsBlankTemplate(new StringUtilsEmptyBlankTestTestIsAnyBlankAdapterImpl());
	}

    @Test
	public void testIsNoneBlank() {
		this.stringUtilsEmptyBlankTestTestIsBlankTemplate(new StringUtilsEmptyBlankTestTestIsNoneBlankAdapterImpl());
	}

    @Test
    public void testIsAllBlank() {
        assertTrue(StringUtils.isAllBlank((String) null));
        assertTrue(StringUtils.isAllBlank((String[]) null));
        assertTrue(StringUtils.isAllBlank(null, null));
        assertTrue(StringUtils.isAllBlank(null, " "));
        assertFalse(StringUtils.isAllBlank(null, "foo"));
        assertFalse(StringUtils.isAllBlank("", "bar"));
        assertFalse(StringUtils.isAllBlank("bob", ""));
        assertFalse(StringUtils.isAllBlank("  bob  ", null));
        assertFalse(StringUtils.isAllBlank(" ", "bar"));
        assertFalse(StringUtils.isAllBlank("foo", "bar"));
    }

	public void stringUtilsEmptyBlankTestTestIsBlankTemplate(StringUtilsEmptyBlankTestTestIsBlankAdapter adapter) {
		assertTrue(adapter.isBlank((String) null));
		assertFalse(adapter.isBlank((String[]) null));
		adapter.assertAction(adapter.isBlank(null, "foo"));
		adapter.assertAction(adapter.isBlank(null, null));
		adapter.assertAction(adapter.isBlank("", "bar"));
		adapter.assertAction(adapter.isBlank("bob", ""));
		adapter.assertAction(adapter.isBlank("  bob  ", null));
		adapter.assertAction(adapter.isBlank(" ", "bar"));
		adapter.assertAction1(adapter.isBlank("foo", "bar"));
	}

	interface StringUtilsEmptyBlankTestTestIsBlankAdapter {
		boolean isBlank(CharSequence... charSequenceArray1);

		void assertAction(boolean b1);

		void assertAction1(boolean b1);
	}

	class StringUtilsEmptyBlankTestTestIsAnyBlankAdapterImpl implements StringUtilsEmptyBlankTestTestIsBlankAdapter {
		public boolean isBlank(CharSequence... charSequence1) {
			return StringUtils.isAnyBlank(charSequence1);
		}

		public void assertAction(boolean b1) {
			assertTrue(b1);
		}

		public void assertAction1(boolean b1) {
			assertFalse(b1);
		}
	}

	class StringUtilsEmptyBlankTestTestIsNoneBlankAdapterImpl implements StringUtilsEmptyBlankTestTestIsBlankAdapter {
		public boolean isBlank(CharSequence... charSequence1) {
			return StringUtils.isNoneBlank(charSequence1);
		}

		public void assertAction(boolean b1) {
			assertFalse(b1);
		}

		public void assertAction1(boolean b1) {
			assertTrue(b1);
		}
	}

	public void stringUtilsEmptyBlankTestTestIsEmptyTemplate(StringUtilsEmptyBlankTestTestIsEmptyAdapter adapter) {
		assertTrue(adapter.isEmpty((String) null));
		assertFalse(adapter.isEmpty((String[]) null));
		adapter.assertAction(adapter.isEmpty(null, "foo"));
		adapter.assertAction(adapter.isEmpty("", "bar"));
		adapter.assertAction(adapter.isEmpty("bob", ""));
		adapter.assertAction(adapter.isEmpty("  bob  ", null));
		adapter.assertAction1(adapter.isEmpty(" ", "bar"));
		adapter.assertAction1(adapter.isEmpty("foo", "bar"));
	}

	interface StringUtilsEmptyBlankTestTestIsEmptyAdapter {
		boolean isEmpty(CharSequence... charSequenceArray1);

		void assertAction(boolean b1);

		void assertAction1(boolean b1);
	}

	class StringUtilsEmptyBlankTestTestIsAnyEmptyAdapterImpl implements StringUtilsEmptyBlankTestTestIsEmptyAdapter {
		public boolean isEmpty(CharSequence... charSequence1) {
			return StringUtils.isAnyEmpty(charSequence1);
		}

		public void assertAction(boolean b1) {
			assertTrue(b1);
		}

		public void assertAction1(boolean b1) {
			assertFalse(b1);
		}
	}

	class StringUtilsEmptyBlankTestTestIsNoneEmptyAdapterImpl implements StringUtilsEmptyBlankTestTestIsEmptyAdapter {
		public boolean isEmpty(CharSequence... charSequence1) {
			return StringUtils.isNoneEmpty(charSequence1);
		}

		public void assertAction(boolean b1) {
			assertFalse(b1);
		}

		public void assertAction1(boolean b1) {
			assertTrue(b1);
		}
	}
}
