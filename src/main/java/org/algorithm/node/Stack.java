package org.algorithm.node;

import org.algorithm.common.StdOut;

import java.util.Iterator;

/**
 * 用链表实现栈
 * <p/>
 * User: zhenguang.zhu
 * Date: 14-2-25
 * Time: 上午10:01
 */
public class Stack<E> implements Iterable<E> {
    private Node<E> last;
    private int size;

    public void push(E element) {
        Node<E> tempNode = last;
        last = new Node<E>(null, last);
        last.setElement(element);
        if (tempNode != null)
            tempNode.setNext(last);
        size++;
    }

    public E pop() {
        if (size() == 0)
            return null;

        Node<E> temp = last;
        last = last.getPrevious();
        if (last != null)
            last.setNext(null);
        size--;
        return temp.getElement();
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int current = size - 1;
            private Node<E> tempLast = last;

            @Override
            public boolean hasNext() {
                return current >= 0;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    return null;
                }
                E result = tempLast.getElement();
                tempLast = tempLast.getPrevious();
                if (tempLast != null)
                    tempLast.setNext(null);
                current--;
                return result;
            }

            @Override
            public void remove() {
                if (hasNext()) {
                    pop();
                    current--;
                }
            }
        };
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("zhu");
        stack.push("zhen");
        stack.push("guang");

        for (String s : stack) {
            StdOut.println(s);
        }

        StdOut.println("======================");

        StdOut.println(stack.pop());

        StdOut.println("======================");

        for (String s : stack) {
            StdOut.println(s);
        }

        Iterator<String> it = stack.iterator();
        while (it.hasNext())
            it.remove();
        System.out.println(stack.size());
    }
}
