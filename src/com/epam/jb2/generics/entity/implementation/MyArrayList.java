package com.epam.jb2.generics.entity.implementation;

import com.epam.jb2.generics.entity.MyList;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T extends Number> implements MyList<T> {
    private Object[] data;
    private int size; //size of dynamic array
    private int length; // number of elements in array

    @Override
    public String toString() {
        return "MyArrayList{" + "data=" + Arrays.toString(data) + ", size=" + size + ", length=" + length + '}';
    }

    public MyArrayList() {
        this.length = 0;
        this.size = 0;
        this.data = new Number[0];
    }

    public MyArrayList(int initialSize) {
        this.length = 0;
        this.size = initialSize;
        this.data = new Number[initialSize];
    }

    @Override
    public Object[] add(T obj) {
        verifySize();
        data[length++] = obj;
        return data;
    }

    @Override
    public Object[] add(int index, T obj) {
        validateIndex(index);
        verifySize();
        int shiftSize = length-index;
        Object[] tmp = new Number[shiftSize];
        System.arraycopy(data, index, tmp, 0, shiftSize);
        data[index] = obj;
        System.arraycopy(tmp, 0, data, index+1, shiftSize);
        length++;
        return data;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove() {
        Object itemToRemove = data[length-1];
        data[--length] = null;
        return (T) itemToRemove;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        validateIndex(index);
        Object itemToRemove = data[index];
        System.arraycopy(data, index+1, data, index, (--length)-index);
        data[length]=null;
        return (T) itemToRemove;
    }

    @Override
    public void sort() {
        Arrays.sort(data,0,length);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super T> comparator) {
        Arrays.sort((T[]) data,0,length, comparator);
    }

    private void verifySize() {
        if (size == length) {
            if (size > 0) {
                Object[] tmp = new Number[size*2];
                System.arraycopy(data, 0, tmp, 0, size);
                data = tmp;
                size *= 2;
            } else {
                data = new Number[1];
                size = 1;
            }

        }
    }

    private void validateIndex(int index) {
        if(index<0 || index>=length)
            throw new IndexOutOfBoundsException();
    }
}
