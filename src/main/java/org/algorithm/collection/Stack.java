package org.algorithm.collection;

import java.util.Iterator;

/**
 * User: zhenguang.zhu
 * Date: 14-2-24
 * Time: 上午9:57
 */
public class Stack<E> implements Iterable<E> {
    private Object[] array;
    private int realCount;

    public Stack(int size) {
        this.array = new Object[size];
    }

    public E pop() {
        @SuppressWarnings("unchecked")
        E element = (E) array[realCount - 1];
        array[realCount - 1] = null;
        realCount--;
        return element;
    }

    public void push(E element) {
        checkRange();
        array[realCount++] = element;
    }

    private void checkRange() {
        if (realCount >= array.length)
            throw new ArrayIndexOutOfBoundsException("包已经满了");
    }

    public int size() {
        return realCount;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int current = realCount - 1;

            @Override
            public boolean hasNext() {
                return current >= 0;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                if (hasNext())
                    return (E) array[current--];
                else
                    return null;
            }

            @Override
            public void remove() {
                if (hasNext()) {
                    array[current--] = null;
                    realCount--;
                }
            }
        };
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>(3);
        stack.push("zhu");
        stack.push("zhen");
        stack.push("guang");

        for (String s : stack) {
            System.out.println(s);
        }

        String removeData = stack.pop();
        System.out.println(removeData);

        for (String s : stack) {
            System.out.println(s);
        }
    }

}
