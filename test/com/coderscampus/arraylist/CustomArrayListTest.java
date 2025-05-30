package com.coderscampus.arraylist;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {

    private CustomArrayList<String> list;

    @BeforeEach
    public void setUp() {
        list = new CustomArrayList<>();
    }


    @Test
    public void testAddItem() {
        assertTrue(list.add("Apple"));
        assertEquals(1, list.getSize());
        assertEquals("Apple", list.get(0));
    }

    @Test
    public void testAddItemAtIndex() {
        list.add("One");
        list.add("Three");
        list.add(1, "Two");
        assertEquals(3, list.getSize());
        assertEquals("One", list.get(0));
        assertEquals("Two", list.get(1));
        assertEquals("Three", list.get(2));
    }

    @Test
    public void testDynamicArrayResize() {
        for (int i = 0; i < 12; i++) {
            list.add(i, String.valueOf(i));
        }
        assertEquals(12, list.getSize());
    }


    @Test
    public void testAddItemAtInvalidIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, "Five"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-3, "minus three "));
    }


    @Test
    public void testGetItem() {
        list.add("First");
        list.add("Second");
        assertEquals("First", list.get(0));
        assertEquals("Second", list.get(1));
    }

    @Test
    public void testGetInvalidIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-3));
    }

    @Test
    public void testRemoveItem() {
        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.remove(1);
        assertEquals("B", removed);
        assertEquals(2, list.getSize());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    public void testRemoveInvalidIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        list.add("X");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    public void testAddMoreThanInitialCapacity() {
        for (int i = 0; i < 15; i++) {
            list.add("Item " + i);
        }
        assertEquals(15, list.getSize());
        assertEquals("Item 0", list.get(0));
        assertEquals("Item 14", list.get(14));
    }
}