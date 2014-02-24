package org.algorithm.sort;

/**
 * User: zhenguang.zhu
 * Date: 13-8-19
 * Time: 下午4:24
 */
public class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 1; out--)
            for (in = 0; in < out; in++)
                if (a[in] > a[in + 1])
                    swap(in, in + 1);

    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public static void main(String[] args) {
        ArrayBub arrayBub = new ArrayBub(100);
        arrayBub.insert(12);
        arrayBub.insert(123);
        arrayBub.insert(124);
        arrayBub.insert(1234);
        arrayBub.insert(34);
        arrayBub.insert(98);
        arrayBub.insert(34);
        arrayBub.insert(56);
        arrayBub.insert(21);
        arrayBub.insert(12);
        arrayBub.display();

        arrayBub.bubbleSort();
        arrayBub.display();
    }
}
