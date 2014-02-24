package org.algorithm.sort;

/**
 * User: zhenguang.zhu
 * Date: 13-8-21
 * Time: 下午4:06
 */
public class ArraySel {
    private long[] a;
    private int nElems;

    public ArraySel(int max) {
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

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) {
            min = out;
            for (in = out + 1; in < nElems; in++)
                if (a[in] < a[min])
                    min = in;
            swap(out, min);
        }
    }

    public static void main(String[] args) {
        ArraySel arraySel = new ArraySel(100);
        arraySel.insert(12);
        arraySel.insert(123);
        arraySel.insert(124);
        arraySel.insert(1234);
        arraySel.insert(34);
        arraySel.insert(98);
        arraySel.insert(34);
        arraySel.insert(56);
        arraySel.insert(21);
        arraySel.insert(12);
        arraySel.display();

        arraySel.selectionSort();
        arraySel.display();
    }
}
