package org.algorithm.node;

import org.algorithm.common.StdOut;

import java.util.Iterator;

/**
 * 链表实现的队列
 * <p/>
 * User: zhenguang.zhu
 * Date: 14-2-25
 * Time: 下午1:54
 */
public class Queue<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public void enqueue(E element) {
        if (size() == 0) {
            first = new Node<E>(null, null);
            first.setElement(element);
            last = first;
        } else {
            Node<E> newNode = new Node<E>(null, last);
            newNode.setElement(element);
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    public E dequeue() {
        if (size() == 0)
            return null;

        Node<E> tempNode = first;
        first = first.getNext();
        if (first != null)
            first.setPrevious(null);
        else
            last = null;
        size--;
        return tempNode.getElement();
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int current = size() - 1;
            private Node<E> tempFirst = first;

            @Override
            public boolean hasNext() {
                return current >= 0;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    return null;
                }
                E element = tempFirst.getElement();
                tempFirst = tempFirst.getNext();
                if (tempFirst != null)
                    tempFirst.setPrevious(null);
                current--;
                return element;
            }

            @Override
            public void remove() {
                if (hasNext()) {
                    dequeue();
                    current--;
                }
            }
        };
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("zhu");
        queue.enqueue("zhen");
        queue.enqueue("guang");

        for (String s : queue) {
            StdOut.println(s);
        }

        StdOut.println("========================");

        StdOut.println(queue.dequeue());

        StdOut.println("========================");

        for (String s : queue) {
            StdOut.println(s);
        }

        StdOut.println("========================");

        StdOut.println(queue.size());

        Iterator<String> it = queue.iterator();
        while (it.hasNext())
            it.remove();

        StdOut.println(queue.size());
    }
}
