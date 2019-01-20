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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Class to test BitField functionality
 */
public class BitFieldTest  {

    private static final BitField bf_multi  = new BitField(0x3F80);
    private static final BitField bf_single = new BitField(0x4000);
    private static final BitField bf_zero = new BitField(0);

    /**
	 * test the getValue() method
	 */
	@Test
	public void testGetValue() {
		this.bitFieldTestTestGetValueTemplate(new BitFieldTestTestGetValueAdapterImpl(), 127, 1);
	}

    /**
	 * test the getShortValue() method
	 */
	@Test
	public void testGetShortValue() {
		this.bitFieldTestTestGetShortValueTemplate(new BitFieldTestTestGetShortValueAdapterImpl(), 127, 1);
	}

    /**
	 * test the getRawValue() method
	 */
	@Test
	public void testGetRawValue() {
		this.bitFieldTestTestGetValueTemplate(new BitFieldTestTestGetRawValueAdapterImpl(), 0x3F80, 0x4000);
	}

    /**
	 * test the getShortRawValue() method
	 */
	@Test
	public void testGetShortRawValue() {
		this.bitFieldTestTestGetShortValueTemplate(new BitFieldTestTestGetShortRawValueAdapterImpl(), 0x3F80, 0x4000);
	}

    /**
     * test the isSet() method
     */
    @Test
    public void testIsSet() {
        assertFalse(bf_multi.isSet(0));
        assertFalse(bf_zero.isSet(0));
        for (int j = 0x80; j <= 0x3F80; j += 0x80) {
            assertTrue(bf_multi.isSet(j));
        }
        for (int j = 0x80; j <= 0x3F80; j += 0x80) {
            assertFalse(bf_zero.isSet(j));
        }
        assertFalse(bf_single.isSet(0));
        assertTrue(bf_single.isSet(0x4000));
    }

    /**
     * test the isAllSet() method
     */
    @Test
    public void testIsAllSet() {
        for (int j = 0; j < 0x3F80; j += 0x80) {
            assertFalse(bf_multi.isAllSet(j));
            assertTrue(bf_zero.isAllSet(j));
        }
        assertTrue(bf_multi.isAllSet(0x3F80));
        assertFalse(bf_single.isAllSet(0));
        assertTrue(bf_single.isAllSet(0x4000));
    }

    /**
     * test the setValue() method
     */
    @Test
    public void testSetValue() {
        for (int j = 0; j < 128; j++) {
            assertEquals(bf_multi.getValue(bf_multi.setValue(0, j)), j);
            assertEquals(bf_multi.setValue(0, j), j << 7);
        }
        for (int j = 0; j < 128; j++) {
          assertEquals(bf_zero.getValue(bf_zero.setValue(0, j)), 0);
          assertEquals(bf_zero.setValue(0, j), 0);
      }

        // verify that excess bits are stripped off
        assertEquals(bf_multi.setValue(0x3f80, 128), 0);
        for (int j = 0; j < 2; j++) {
            assertEquals(bf_single.getValue(bf_single.setValue(0, j)), j);
            assertEquals(bf_single.setValue(0, j), j << 14);
        }

        // verify that excess bits are stripped off
        assertEquals(bf_single.setValue(0x4000, 2), 0);
    }

    /**
     * test the setShortValue() method
     */
    @Test
    public void testSetShortValue() {
        for (int j = 0; j < 128; j++) {
            assertEquals(bf_multi.getShortValue(bf_multi.setShortValue((short) 0, (short) j)), (short) j);
            assertEquals(bf_multi.setShortValue((short) 0, (short) j), (short) (j << 7));
        }
        for (int j = 0; j < 128; j++) {
            assertEquals(bf_zero.getShortValue(bf_zero.setShortValue((short) 0, (short) j)), (short) 0);
            assertEquals(bf_zero.setShortValue((short) 0, (short) j), (short) 0);
        }

        // verify that excess bits are stripped off
        assertEquals(bf_multi.setShortValue((short) 0x3f80, (short) 128), (short) 0);
        for (int j = 0; j < 2; j++) {
            assertEquals(bf_single.getShortValue(bf_single.setShortValue((short) 0, (short) j)), (short) j);
            assertEquals(bf_single.setShortValue((short) 0, (short) j), (short) (j << 14));
        }

        // verify that excess bits are stripped off
        assertEquals(bf_single.setShortValue((short) 0x4000, (short) 2), (short) 0);
    }

    @Test
    public void testByte() {
        assertEquals(0, new BitField(0).setByteBoolean((byte) 0, true));
        assertEquals(1, new BitField(1).setByteBoolean((byte) 0, true));
        assertEquals(2, new BitField(2).setByteBoolean((byte) 0, true));
        assertEquals(4, new BitField(4).setByteBoolean((byte) 0, true));
        assertEquals(8, new BitField(8).setByteBoolean((byte) 0, true));
        assertEquals(16, new BitField(16).setByteBoolean((byte) 0, true));
        assertEquals(32, new BitField(32).setByteBoolean((byte) 0, true));
        assertEquals(64, new BitField(64).setByteBoolean((byte) 0, true));
        assertEquals(-128, new BitField(128).setByteBoolean((byte) 0, true));
        assertEquals(1, new BitField(0).setByteBoolean((byte) 1, false));
        assertEquals(0, new BitField(1).setByteBoolean((byte) 1, false));
        assertEquals(0, new BitField(2).setByteBoolean((byte) 2, false));
        assertEquals(0, new BitField(4).setByteBoolean((byte) 4, false));
        assertEquals(0, new BitField(8).setByteBoolean((byte) 8, false));
        assertEquals(0, new BitField(16).setByteBoolean((byte) 16, false));
        assertEquals(0, new BitField(32).setByteBoolean((byte) 32, false));
        assertEquals(0, new BitField(64).setByteBoolean((byte) 64, false));
        assertEquals(0, new BitField(128).setByteBoolean((byte) 128, false));
        assertEquals(-2, new BitField(1).setByteBoolean((byte) 255, false));
        final byte clearedBit = new BitField(0x40).setByteBoolean((byte) - 63, false);

        assertFalse(new BitField(0x40).isSet(clearedBit));
    }

    /**
     * test the clear() method
     */
    @Test
    public void testClear() {
        assertEquals(bf_multi.clear(-1), 0xFFFFC07F);
        assertEquals(bf_single.clear(-1), 0xFFFFBFFF);
        assertEquals(bf_zero.clear(-1), 0xFFFFFFFF);
    }

    /**
	 * test the clearShort() method
	 */
	@Test
	public void testClearShort() {
		this.bitFieldTestTestShortTemplate(new BitFieldTestTestClearShortAdapterImpl(), -1, 0xC07F, -1, 0xBFFF, -1,
				0xFFFF);
	}

    /**
     * test the set() method
     */
    @Test
    public void testSet() {
        assertEquals(bf_multi.set(0), 0x3F80);
        assertEquals(bf_single.set(0), 0x4000);
        assertEquals(bf_zero.set(0), 0);
    }

    /**
	 * test the setShort() method
	 */
	@Test
	public void testSetShort() {
		this.bitFieldTestTestShortTemplate(new BitFieldTestTestSetShortAdapterImpl(), 0, 0x3F80, 0, 0x4000, 0, 0);
	}

    /**
     * test the setBoolean() method
     */
    @Test
    public void testSetBoolean() {
        assertEquals(bf_multi.set(0), bf_multi.setBoolean(0, true));
        assertEquals(bf_single.set(0), bf_single.setBoolean(0, true));
        assertEquals(bf_zero.set(0), bf_zero.setBoolean(0, true));
        assertEquals(bf_multi.clear(-1), bf_multi.setBoolean(-1, false));
        assertEquals(bf_single.clear(-1), bf_single.setBoolean(-1, false));
        assertEquals(bf_zero.clear(-1), bf_zero.setBoolean(-1, false));
    }

    /**
     * test the setShortBoolean() method
     */
    @Test
    public void testSetShortBoolean() {
        assertEquals(bf_multi.setShort((short) 0), bf_multi.setShortBoolean((short) 0, true));
        assertEquals(bf_single.setShort((short) 0), bf_single.setShortBoolean((short) 0, true));
        assertEquals(bf_zero.setShort((short) 0), bf_zero.setShortBoolean((short) 0, true));
        assertEquals(bf_multi.clearShort((short) - 1), bf_multi.setShortBoolean((short) - 1, false));
        assertEquals(bf_single.clearShort((short) - 1), bf_single.setShortBoolean((short) - 1, false));
        assertEquals(bf_zero.clearShort((short) -1), bf_zero.setShortBoolean((short) -1, false));
    }

	public void bitFieldTestTestGetValueTemplate(BitFieldTestTestGetValueAdapter adapter, int i1, int i2) {
		assertEquals(adapter.getValue(bf_multi, -1), i1);
		assertEquals(adapter.getValue(bf_multi, 0), 0);
		assertEquals(adapter.getValue(bf_single, -1), i2);
		assertEquals(adapter.getValue(bf_single, 0), 0);
		assertEquals(adapter.getValue(bf_zero, -1), 0);
		assertEquals(adapter.getValue(bf_zero, 0), 0);
	}

	interface BitFieldTestTestGetValueAdapter {
		int getValue(BitField bitField1, int i1);
	}

	class BitFieldTestTestGetValueAdapterImpl implements BitFieldTestTestGetValueAdapter {
		public int getValue(BitField bf_multi, int i1) {
			return bf_multi.getValue(i1);
		}
	}

	class BitFieldTestTestGetRawValueAdapterImpl implements BitFieldTestTestGetValueAdapter {
		public int getValue(BitField bf_multi, int i1) {
			return bf_multi.getRawValue(i1);
		}
	}

	public void bitFieldTestTestGetShortValueTemplate(BitFieldTestTestGetShortValueAdapter adapter, int i1, int i2) {
		assertEquals(adapter.getShortValue(bf_multi, (short) -1), (short) i1);
		assertEquals(adapter.getShortValue(bf_multi, (short) 0), (short) 0);
		assertEquals(adapter.getShortValue(bf_single, (short) -1), (short) i2);
		assertEquals(adapter.getShortValue(bf_single, (short) 0), (short) 0);
		assertEquals(adapter.getShortValue(bf_zero, (short) -1), (short) 0);
		assertEquals(adapter.getShortValue(bf_zero, (short) 0), (short) 0);
	}

	interface BitFieldTestTestGetShortValueAdapter {
		short getShortValue(BitField bitField1, short s1);
	}

	class BitFieldTestTestGetShortValueAdapterImpl implements BitFieldTestTestGetShortValueAdapter {
		public short getShortValue(BitField bf_multi, short s1) {
			return bf_multi.getShortValue(s1);
		}
	}

	class BitFieldTestTestGetShortRawValueAdapterImpl implements BitFieldTestTestGetShortValueAdapter {
		public short getShortValue(BitField bf_multi, short s1) {
			return bf_multi.getShortRawValue(s1);
		}
	}

	public void bitFieldTestTestShortTemplate(BitFieldTestTestShortAdapter adapter, int i1, int i2, int i3, int i4,
			int i5, int i6) {
		assertEquals(adapter.shortAction(bf_multi, (short) i1), (short) i2);
		assertEquals(adapter.shortAction(bf_single, (short) i3), (short) i4);
		assertEquals(adapter.shortAction(bf_zero, (short) i5), (short) i6);
	}

	interface BitFieldTestTestShortAdapter {
		short shortAction(BitField bitField1, short s1);
	}

	class BitFieldTestTestClearShortAdapterImpl implements BitFieldTestTestShortAdapter {
		public short shortAction(BitField bf_multi, short s1) {
			return bf_multi.clearShort(s1);
		}
	}

	class BitFieldTestTestSetShortAdapterImpl implements BitFieldTestTestShortAdapter {
		public short shortAction(BitField bf_multi, short s1) {
			return bf_multi.setShort(s1);
		}
	}

}
