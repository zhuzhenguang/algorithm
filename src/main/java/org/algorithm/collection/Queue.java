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

    public Queue(int size) {
        this.array = new Object[size];
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
        return new Iterator<E>() {
            private int current;

            @Override
            public boolean hasNext() {
                return current < realCount;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                if (hasNext())
                    return (E) array[current++];
                else
                    return null;
            }

            @Override
            public void remove() {
                if (!hasNext())
                    return;

                array[current] = null;
                for (int i = current + 1; i < realCount; i++) {
                    array[i - 1] = array[i];
                    array[i] = null;
                }
                realCount--;
            }
        };
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>(3);
        queue.enqueue("zhu");
        queue.enqueue("zhen");
        queue.enqueue("guang");

        for (String q : queue) {
            System.out.println(q);
        }

        System.out.println(queue.size());

        queue.dequeue(1);

        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println(queue.size());

        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }

        System.out.println(queue.size());
    }
}
