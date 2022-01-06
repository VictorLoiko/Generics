package com.epam.jb2.generics.entity;

import java.util.Comparator;

public interface MyList<T extends Number> {
    Object[] add(T obj);
    Object[] add(int index, T obj);
    T remove();
    T remove(int index);
    void sort();
    void sort(Comparator<? super T> comparator);
}
