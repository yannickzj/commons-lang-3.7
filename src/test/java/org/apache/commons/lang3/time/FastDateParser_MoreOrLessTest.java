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
package org.apache.commons.lang3.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;

public class FastDateParser_MoreOrLessTest {

    private static final TimeZone NEW_YORK = TimeZone.getTimeZone("America/New_York");

    @Test
    public void testInputHasPrecedingCharacters() {
        final FastDateParser parser = new FastDateParser("MM/dd", TimeZone.getDefault(), Locale.getDefault());
        final ParsePosition parsePosition = new ParsePosition(0);
        final Date date = parser.parse("A 3/23/61", parsePosition);
        assertNull(date);
        assertEquals(0, parsePosition.getIndex());
        assertEquals(0, parsePosition.getErrorIndex());
    }

    @Test
    public void testInputHasWhitespace() {
        final FastDateParser parser = new FastDateParser("M/d/y", TimeZone.getDefault(), Locale.getDefault());
        //SimpleDateFormat parser = new SimpleDateFormat("M/d/y");
        final ParsePosition parsePosition = new ParsePosition(0);
        final Date date = parser.parse(" 3/ 23/ 1961", parsePosition);
        assertEquals(12, parsePosition.getIndex());

        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        assertEquals(1961, calendar.get(Calendar.YEAR));
        assertEquals(2, calendar.get(Calendar.MONTH));
        assertEquals(23, calendar.get(Calendar.DATE));
    }

    @Test
    public void testInputHasMoreCharacters() {
        final FastDateParser parser = new FastDateParser("MM/dd", TimeZone.getDefault(), Locale.getDefault());
        final ParsePosition parsePosition = new ParsePosition(0);
        final Date date = parser.parse("3/23/61", parsePosition);
        assertEquals(4, parsePosition.getIndex());

        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        assertEquals(2, calendar.get(Calendar.MONTH));
        assertEquals(23, calendar.get(Calendar.DATE));
    }

    @Test
	public void testInputHasWrongCharacters() {
		this.fastDateParser_MoreOrLessTestTestInputHasCharactersTemplate("MM-dd-yyy", "03/23/1961", 2);
	}

    @Test
	public void testInputHasLessCharacters() {
		this.fastDateParser_MoreOrLessTestTestInputHasCharactersTemplate("MM/dd/yyy", "03/23", 5);
	}

    @Test
	public void testInputHasWrongTimeZone() {
		this.fastDateParser_MoreOrLessTestTestInputHasWrongTemplate("mm:ss z", "11:23 Pacific Standard Time",
				"11:23 Pacific Standard ", 6);
	}

    @Test
	public void testInputHasWrongDay() {
		this.fastDateParser_MoreOrLessTestTestInputHasWrongTemplate("EEEE, MM/dd/yyy", "Thursday, 03/23/61",
				"Thorsday, 03/23/61", 0);
	}

	public void fastDateParser_MoreOrLessTestTestInputHasWrongTemplate(String string1, String string2, String string3,
			int i1) {
		final FastDateParser parser = new FastDateParser(string1, NEW_YORK, Locale.US);
		final String input = string2;
		final ParsePosition parsePosition = new ParsePosition(0);
		assertNotNull(parser.parse(input, parsePosition));
		assertEquals(input.length(), parsePosition.getIndex());
		parsePosition.setIndex(0);
		assertNull(parser.parse(string3, parsePosition));
		assertEquals(i1, parsePosition.getErrorIndex());
	}

	public void fastDateParser_MoreOrLessTestTestInputHasCharactersTemplate(String string1, String string2, int i1) {
		final FastDateParser parser = new FastDateParser(string1, TimeZone.getDefault(), Locale.getDefault());
		final ParsePosition parsePosition = new ParsePosition(0);
		assertNull(parser.parse(string2, parsePosition));
		assertEquals(i1, parsePosition.getErrorIndex());
	}
}
