package com.chenxi.test.collections.queue;

/**
 * TODO : description
 * Author : Chen Xi
 * Date : 2016/9/4
 */
public interface Queue<E> {
    void add(E element);
    E remove();
    int size();
}
