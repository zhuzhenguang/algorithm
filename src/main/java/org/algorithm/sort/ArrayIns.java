package org.algorithm.sort;

/**
 * User: zhenguang.zhu
 * Date: 13-8-22
 * Time: 下午4:00
 */
public class ArrayIns {
    private long[] a;
    private int nElems;

    public ArrayIns(int max) {
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

    public void insertSort() {
        int in, out;

        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }

    public static void main(String[] args) {
        ArrayIns arrayIns = new ArrayIns(100);
        arrayIns.insert(12);
        arrayIns.insert(123);
        arrayIns.insert(124);
        arrayIns.insert(1234);
        arrayIns.insert(34);
        arrayIns.insert(98);
        arrayIns.insert(34);
        arrayIns.insert(56);
        arrayIns.insert(21);
        arrayIns.insert(12);
        arrayIns.display();

        arrayIns.insertSort();

        arrayIns.display();
    }
}
