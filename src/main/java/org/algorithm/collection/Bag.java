package org.algorithm.collection;

import java.util.Iterator;

/**
 * 背包的数组实现
 * <p/>
 * User: zhenguang.zhu
 * Date: 14-2-24
 * Time: 上午9:57
 */
public class Bag<E> implements Iterable<E> {
    private Object[] array;
    private Iterator<E> it;
    private int realCount;

    public Bag(int size) {
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
                throw new RuntimeException("不支持删除");
            }
        };
    }

    public void add(E element) {
        checkRange();
        array[realCount++] = element;
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

    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>(5);
        bag.add("zhu");
        bag.add("zhen");
        bag.add("guang");
        for (String b : bag) {
            System.out.println(b);
        }
        System.out.println(bag.size());
    }
}
