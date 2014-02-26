package org.algorithm.collection;

import org.algorithm.common.StdOut;

/**
 * 定容栈
 * <p/>
 * Created by zhu on 14-2-27.
 */
public class FixedCapacityStackOfStrings {
    private String[] array;
    private int size;

    public FixedCapacityStackOfStrings(int cap) {
        this.array = new String[cap];
    }

    public void push(String item) {
        if (size() < array.length)
            this.array[size++] = item;
    }

    public String pop() {
        if (size() != 0) {
            String temp = array[--size];
            array[size] = null;
            return temp;
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stackOfStrings = new FixedCapacityStackOfStrings(3);
        stackOfStrings.push("zhu");
        stackOfStrings.push("zhen");
        stackOfStrings.push("guang");

        StdOut.println(stackOfStrings.size());
        while (!stackOfStrings.isEmpty())
            StdOut.println(stackOfStrings.pop());
        StdOut.println(stackOfStrings.size());
        StdOut.println(stackOfStrings.pop());
    }
}
