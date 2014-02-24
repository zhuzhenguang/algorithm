package org.algorithm.array;

/**
 * 一般数组
 * <p/>
 * User: zhenguang.zhu
 * Date: 13-8-13
 * Time: 下午2:00
 */
public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] == searchKey)
                break;
        return j != nElems;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (value == a[j])
                break;

        if (j == nElems)
            return false;
        else {
            /*for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];*/
            System.arraycopy(a, j + 1, a, j, nElems - j);
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    public long getMax() {
        long max = -1;
        for (int i = 0; i < nElems; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    public long removeMax() {
        long max = -1;
        for (int i = 0; i < nElems; i++)
            if (a[i] > max)
                max = a[i];

        if (max != -1)
            delete(max);
        return max;
    }

    public void noDup() {
        for (int i = 0; i < nElems; i++) {
            long p = a[i];
            for (int j = 0; j < nElems; j++) {
                if (j != i && a[j] == p)
                    a[j] = 0;
            }
        }

        display();

        for (int k = 0; k < nElems; ) {
            if (a[k] == 0) {
                /*for (int l = k; l < nElems; l++)
                    a[l] = a[l + 1];*/
                System.arraycopy(a, k + 1, a, k, nElems - k);
                nElems--;
            } else {
                k++;
            }
        }
    }

    public static void main(String[] args) {
        HighArray highArray = new HighArray(100);
        highArray.insert(1);
        highArray.insert(6);
        highArray.insert(3);
        highArray.insert(4);
        highArray.insert(2);
        highArray.insert(5);
        highArray.insert(4);
        highArray.insert(5);
        highArray.insert(8);
        highArray.insert(13);
        highArray.insert(7);
        highArray.insert(8);
        highArray.insert(10);
        highArray.insert(12);
        highArray.insert(11);
        highArray.insert(9);
        highArray.insert(12);
        highArray.display();

        highArray.noDup();
        highArray.display();

        /*System.out.println(highArray.find(10));

        System.out.println(highArray.delete(10));

        System.out.println(highArray.find(10));

        System.out.println(highArray.getMax());

        System.out.println(highArray.removeMax());

        highArray.display();

        long[] n = new long[highArray.nElems];
        int i = 0;
        while (highArray.nElems > 0) {
            long v = highArray.removeMax();
            n[i++] = v;
        }
        for (long aN : n) {
            System.out.print(aN + " ");
        }*/

    }

}
