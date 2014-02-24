package org.algorithm.collection;

import java.util.Iterator;

/**
 * 队列的数组实现
 * <p/>
 * User: zhenguang.zhu
 * Date: 14-2-24
 * Time: 上午9:57
 */
public class Queue<E> implements Iterable<E> {
    private Object[] array;
    private int realCount;
    private Iterator<E> it;

    public Queue(int size) {
        this.array = new Object[size];
        it = new Iterator<E>() {
            private int current;

            @Override
            public boolean hasNext() {
                return current < realCount && array[current] != null;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                checkRange();
                return (E) array[current++];
            }

            @Override
            public void remove() {
                checkRange();
                array[current] = null;
                for (int i = current + 1; i < realCount; i++) {
                    array[i - 1] = array[i];
                    array[i] = null;
                }
                realCount--;
            }
        };
    }

    public void enqueue(E element) {
        checkRange();
        array[realCount++] = element;
    }

    public void dequeue(int index) {
        if (index > realCount || index < 0)
            throw new ArrayIndexOutOfBoundsException("索引超过数组的边界");
        for (int i = index + 1; i < realCount; i++) {
            array[i - 1] = array[i];
            array[i] = null;
        }
        realCount--;
    }

    public int size() {
        return realCount;
    }

    private void checkRange() {
        if (realCount >= array.length)
            throw new ArrayIndexOutOfBoundsException("包已经满了");
    }

    @Override
    public Iterator<E> iterator() {
        return it;
    }
}
