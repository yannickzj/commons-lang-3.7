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
package org.apache.commons.lang3.mutable;

import java.lang.Number;
import java.lang.Object;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * JUnit tests.
 *
 * @see MutableShort
 */
public class MutableShortTest {

    // ----------------------------------------------------------------
    @Test
    public void testConstructors() {
        assertEquals((short) 0, new MutableShort().shortValue());

        assertEquals((short) 1, new MutableShort((short) 1).shortValue());

        assertEquals((short) 2, new MutableShort(Short.valueOf((short) 2)).shortValue());
        assertEquals((short) 3, new MutableShort(new MutableShort((short) 3)).shortValue());

        assertEquals((short) 2, new MutableShort("2").shortValue());

        try {
            new MutableShort((Number)null);
            fail();
        } catch (final NullPointerException ex) {}
    }

    @Test
    public void testGetSet() {
        final MutableShort mutNum = new MutableShort((short) 0);
        assertEquals((short) 0, new MutableShort().shortValue());
        assertEquals(Short.valueOf((short) 0), new MutableShort().getValue());

        mutNum.setValue((short) 1);
        assertEquals((short) 1, mutNum.shortValue());
        assertEquals(Short.valueOf((short) 1), mutNum.getValue());

        mutNum.setValue(Short.valueOf((short) 2));
        assertEquals((short) 2, mutNum.shortValue());
        assertEquals(Short.valueOf((short) 2), mutNum.getValue());

        mutNum.setValue(new MutableShort((short) 3));
        assertEquals((short) 3, mutNum.shortValue());
        assertEquals(Short.valueOf((short) 3), mutNum.getValue());
        try {
            mutNum.setValue(null);
            fail();
        } catch (final NullPointerException ex) {}
    }

    @Test
	public void testEquals() throws Exception {
		MutableTestTestEqualsTemplate.mutableTestTestEqualsTemplate(new MutableShortTestTestEqualsAdapterImpl(),
				MutableShort.class, short.class);
	}

    @Test
    public void testHashCode() {
        final MutableShort mutNumA = new MutableShort((short) 0);
        final MutableShort mutNumB = new MutableShort((short) 0);
        final MutableShort mutNumC = new MutableShort((short) 1);

        assertTrue(mutNumA.hashCode() == mutNumA.hashCode());
        assertTrue(mutNumA.hashCode() == mutNumB.hashCode());
        assertFalse(mutNumA.hashCode() == mutNumC.hashCode());
        assertTrue(mutNumA.hashCode() == Short.valueOf((short) 0).hashCode());
    }

    @Test
    public void testCompareTo() {
        final MutableShort mutNum = new MutableShort((short) 0);

        assertEquals((short) 0, mutNum.compareTo(new MutableShort((short) 0)));
        assertEquals((short) +1, mutNum.compareTo(new MutableShort((short) -1)));
        assertEquals((short) -1, mutNum.compareTo(new MutableShort((short) 1)));
        try {
            mutNum.compareTo(null);
            fail();
        } catch (final NullPointerException ex) {}
    }

    @Test
    public void testPrimitiveValues() {
        final MutableShort mutNum = new MutableShort( (short) 1 );

        assertEquals( 1.0F, mutNum.floatValue(), 0 );
        assertEquals( 1.0, mutNum.doubleValue(), 0 );
        assertEquals( (byte) 1, mutNum.byteValue() );
        assertEquals( (short) 1, mutNum.shortValue() );
        assertEquals( 1, mutNum.intValue() );
        assertEquals( 1L, mutNum.longValue() );
    }

    @Test
    public void testToShort() {
        assertEquals(Short.valueOf((short) 0), new MutableShort((short) 0).toShort());
        assertEquals(Short.valueOf((short) 123), new MutableShort((short) 123).toShort());
    }

    @Test
    public void testIncrement() {
        final MutableShort mutNum = new MutableShort((short) 1);
        mutNum.increment();

        assertEquals(2, mutNum.intValue());
        assertEquals(2L, mutNum.longValue());
    }

    @Test
    public void testIncrementAndGet() {
        final MutableShort mutNum = new MutableShort((short) 1);
        final short result = mutNum.incrementAndGet();

        assertEquals(2, result);
        assertEquals(2, mutNum.intValue());
        assertEquals(2L, mutNum.longValue());
    }

    @Test
    public void testGetAndIncrement() {
        final MutableShort mutNum = new MutableShort((short) 1);
        final short result = mutNum.getAndIncrement();

        assertEquals(1, result);
        assertEquals(2, mutNum.intValue());
        assertEquals(2L, mutNum.longValue());
    }

    @Test
    public void testDecrement() {
        final MutableShort mutNum = new MutableShort((short) 1);
        mutNum.decrement();

        assertEquals(0, mutNum.intValue());
        assertEquals(0L, mutNum.longValue());
    }

    @Test
    public void testDecrementAndGet() {
        final MutableShort mutNum = new MutableShort((short) 1);
        final short result = mutNum.decrementAndGet();

        assertEquals(0, result);
        assertEquals(0, mutNum.intValue());
        assertEquals(0L, mutNum.longValue());
    }

    @Test
    public void testGetAndDecrement() {
        final MutableShort mutNum = new MutableShort((short) 1);
        final short result = mutNum.getAndDecrement();

        assertEquals(1, result);
        assertEquals(0, mutNum.intValue());
        assertEquals(0L, mutNum.longValue());
    }

    @Test
    public void testAddValuePrimitive() {
        final MutableShort mutNum = new MutableShort((short) 1);
        mutNum.add((short) 1);

        assertEquals((short) 2, mutNum.shortValue());
    }

    @Test
	public void testAddValueObject() {
		this.mutableShortTestTestValueObjectTemplate(new MutableShortTestTestAddValueObjectAdapterImpl(), 2);
	}

    @Test
	public void testGetAndAddValuePrimitive() {
		this.mutableShortTestTestAddAndGetValuePrimitiveTemplate(
				new MutableShortTestTestGetAndAddValuePrimitiveAdapterImpl(), 0);
	}

    @Test
	public void testGetAndAddValueObject() {
		this.mutableShortTestTestAddAndGetValueObjectTemplate(new MutableShortTestTestGetAndAddValueObjectAdapterImpl(),
				0);
	}

    @Test
	public void testAddAndGetValuePrimitive() {
		this.mutableShortTestTestAddAndGetValuePrimitiveTemplate(
				new MutableShortTestTestAddAndGetValuePrimitiveAdapterImpl(), 1);
	}

    @Test
	public void testAddAndGetValueObject() {
		this.mutableShortTestTestAddAndGetValueObjectTemplate(new MutableShortTestTestAddAndGetValueObjectAdapterImpl(),
				1);
	}

    @Test
    public void testSubtractValuePrimitive() {
        final MutableShort mutNum = new MutableShort((short) 1);
        mutNum.subtract((short) 1);

        assertEquals((short) 0, mutNum.shortValue());
    }

    @Test
	public void testSubtractValueObject() {
		this.mutableShortTestTestValueObjectTemplate(new MutableShortTestTestSubtractValueObjectAdapterImpl(), 0);
	}

    @Test
    public void testToString() {
        assertEquals("0", new MutableShort((short) 0).toString());
        assertEquals("10", new MutableShort((short) 10).toString());
        assertEquals("-123", new MutableShort((short) -123).toString());
    }

	class MutableShortTestTestEqualsAdapterImpl implements MutableTestTestEqualsAdapter<MutableShort> {
		public boolean equals(MutableShort mutNumA, Object mutNumA1) {
			return mutNumA.equals(mutNumA1);
		}

		public Number valueOf(byte byte1) {
			return (Number) Short.valueOf(byte1);
		}
	}

	public void mutableShortTestTestAddAndGetValuePrimitiveTemplate(
			MutableShortTestTestAddAndGetValuePrimitiveAdapter adapter, int i1) {
		final MutableShort mutableShort = new MutableShort((short) 0);
		final short result = adapter.addAndGet(mutableShort, (short) 1);
		assertEquals((short) i1, result);
		assertEquals((short) 1, mutableShort.shortValue());
	}

	interface MutableShortTestTestAddAndGetValuePrimitiveAdapter {
		short addAndGet(MutableShort mutableShort1, short s1);
	}

	class MutableShortTestTestGetAndAddValuePrimitiveAdapterImpl
			implements MutableShortTestTestAddAndGetValuePrimitiveAdapter {
		public short addAndGet(MutableShort mutableShort, short s1) {
			return mutableShort.getAndAdd(s1);
		}
	}

	class MutableShortTestTestAddAndGetValuePrimitiveAdapterImpl
			implements MutableShortTestTestAddAndGetValuePrimitiveAdapter {
		public short addAndGet(MutableShort mutableShort, short s1) {
			return mutableShort.addAndGet(s1);
		}
	}

	public void mutableShortTestTestAddAndGetValueObjectTemplate(
			MutableShortTestTestAddAndGetValueObjectAdapter adapter, int i1) {
		final MutableShort mutableShort = new MutableShort((short) 0);
		final short result = adapter.addAndGet(mutableShort, Short.valueOf((short) 1));
		assertEquals((short) i1, result);
		assertEquals((short) 1, mutableShort.shortValue());
	}

	interface MutableShortTestTestAddAndGetValueObjectAdapter {
		short addAndGet(MutableShort mutableShort1, Number number1);
	}

	class MutableShortTestTestGetAndAddValueObjectAdapterImpl
			implements MutableShortTestTestAddAndGetValueObjectAdapter {
		public short addAndGet(MutableShort mutableShort, Number number1) {
			return mutableShort.getAndAdd(number1);
		}
	}

	class MutableShortTestTestAddAndGetValueObjectAdapterImpl
			implements MutableShortTestTestAddAndGetValueObjectAdapter {
		public short addAndGet(MutableShort mutableShort, Number number1) {
			return mutableShort.addAndGet(number1);
		}
	}

	public void mutableShortTestTestValueObjectTemplate(MutableShortTestTestValueObjectAdapter adapter, int i1) {
		final MutableShort mutNum = new MutableShort((short) 1);
		adapter.action1(mutNum, Short.valueOf((short) 1));
		assertEquals((short) i1, mutNum.shortValue());
	}

	interface MutableShortTestTestValueObjectAdapter {
		void action1(MutableShort mutableShort1, Number number1);
	}

	class MutableShortTestTestAddValueObjectAdapterImpl implements MutableShortTestTestValueObjectAdapter {
		public void action1(MutableShort mutNum, Number number1) {
			mutNum.add(number1);
		}
	}

	class MutableShortTestTestSubtractValueObjectAdapterImpl implements MutableShortTestTestValueObjectAdapter {
		public void action1(MutableShort mutNum, Number number1) {
			mutNum.subtract(number1);
		}
	}

}
