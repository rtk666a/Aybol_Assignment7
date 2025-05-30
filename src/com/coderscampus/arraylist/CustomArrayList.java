package com.coderscampus.arraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
    private Object[] items = new Object[10];
    private int size = 0;
    
    @Override
    public boolean add(T item) {
        return add(size,item);
    }



    @Override
    public boolean add(int index, T item) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for an array of size " + size);
        }

        resize();
        
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = item;
        size++;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        IndexOutOfBoundsExceptionChek(index);
        return (T) items[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {
        IndexOutOfBoundsExceptionChek(index);
        T item = (T) items[index];
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        items[size - 1] = null;
        size--;
        return item;
    }

    private void IndexOutOfBoundsExceptionChek(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for an array of size " + size);
        }
    }

    private void resize() {
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
    }
}
