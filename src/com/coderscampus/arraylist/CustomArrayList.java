package com.coderscampus.arraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
    Object[] items = new Object[10];
    int size = 0;

    public boolean add(T item) {
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        items[size++] = item;
        return true;
    }
    @Override
    public boolean add(int index, T item) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for an array of size " + size);
        }
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = item;
        size++;
        return true;
    }

    public Object[] returnArray() {
        Object[] newArray = new Object[items.length * 2];
        System.arraycopy(items, 0, newArray, 0, items.length);
        return newArray;
    }

    @Override
    public int getSize() {

        return size;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return (T) items[index];
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for an array of size " + size);
        }
        T item = (T) items[index];
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        items[size - 1] = null;
        size--;
        return item;
    }
}
