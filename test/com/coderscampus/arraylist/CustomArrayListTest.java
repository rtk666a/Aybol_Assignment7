package com.coderscampus.arraylist;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {

    private CustomArrayList<String> stringCustomArrayList;
    private CustomArrayList<Integer> integerCustomArrayList;

    @BeforeEach
    public void setUp() {
        stringCustomArrayList = new CustomArrayList<>();
        integerCustomArrayList = new CustomArrayList<>();
    }


    @Test
    public void testAddItem() {
        assertTrue(stringCustomArrayList.add("Apple"));
        assertEquals(1, stringCustomArrayList.getSize());
        assertEquals("Apple", stringCustomArrayList.get(0));
    }

    @Test
    public void testAddItemAtIndex() {
        stringCustomArrayList.add("One");
        stringCustomArrayList.add("Three");
        stringCustomArrayList.add(1, "Two");
        assertEquals(3, stringCustomArrayList.getSize());
        assertEquals("One", stringCustomArrayList.get(0));
        assertEquals("Two", stringCustomArrayList.get(1));
        assertEquals("Three", stringCustomArrayList.get(2));
    }

    @Test
    public void testDynamicArrayResize() {
        for (int i = 0; i < 12; i++) {
            stringCustomArrayList.add(i, String.valueOf(i));
        }
        assertEquals(12, stringCustomArrayList.getSize());
    }


    @Test
    public void testAddItemAtInvalidIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> stringCustomArrayList.add(5, "Five"));
        assertThrows(IndexOutOfBoundsException.class, () -> stringCustomArrayList.add(-3, "minus three "));
    }


    @Test
    public void testGetItem() {
        stringCustomArrayList.add("First");
        stringCustomArrayList.add("Second");
        assertEquals("First", stringCustomArrayList.get(0));
        assertEquals("Second", stringCustomArrayList.get(1));
    }

    @Test
    public void testGetInvalidIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> stringCustomArrayList.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> stringCustomArrayList.get(-3));
    }

    @Test
    public void testRemoveItem() {
        stringCustomArrayList.add("A");
        stringCustomArrayList.add("B");
        stringCustomArrayList.add("C");

        String removed = stringCustomArrayList.remove(1);
        assertEquals("B", removed);
        assertEquals(2, stringCustomArrayList.getSize());
        assertEquals("A", stringCustomArrayList.get(0));
        assertEquals("C", stringCustomArrayList.get(1));
    }

    @Test
    public void testRemoveInvalidIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> stringCustomArrayList.remove(0));
        stringCustomArrayList.add("X");
        assertThrows(IndexOutOfBoundsException.class, () -> stringCustomArrayList.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> stringCustomArrayList.remove(1));
    }

    @Test
    public void testAddMoreThanInitialCapacity() {
        for (int i = 0; i < 15; i++) {
            stringCustomArrayList.add("Item " + i);
        }
        assertEquals(15, stringCustomArrayList.getSize());
        assertEquals("Item 0", stringCustomArrayList.get(0));
        assertEquals("Item 14", stringCustomArrayList.get(14));
    }

    @DisplayName("Kevin add this test !")
    @Test
    public void testAddMillionInteger(){
        for (int i = 0; i < 1000000; i++) {
            integerCustomArrayList.add(i);
        }
        assertEquals(1000000, integerCustomArrayList.getSize());
    }
}