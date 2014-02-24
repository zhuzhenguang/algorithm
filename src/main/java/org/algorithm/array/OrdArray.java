package org.algorithm.array;

/**
 * User: zhenguang.zhu
 * Date: 13-8-13
 * Time: 下午3:17
 */
public class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;
            else if (lowBound > upperBound)
                return -1;
            else {
                if (a[curIn] > searchKey)
                    upperBound = curIn - 1;
                else
                    lowBound = curIn + 1;
            }
        }
    }

    public void insert(long value) {
        int i = findInsertIndex(value);
        /*int i;
        for (i = 0; i < nElems; i++)
            if (a[i] > value)
                break;*/

        int j;
        for (j = nElems; j > i; j--)
            a[j] = a[j - 1];
        a[j] = value;
        nElems++;
    }

    public int findInsertIndex(long searchKey) {
        int lowBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;
            else if (lowBound > upperBound) {
                if (curIn == 0)
                    return curIn;
                else
                    return curIn + 1;
            } else {
                if (a[curIn] > searchKey) {
                    if (curIn - 1 < 0 || a[curIn - 1] < searchKey)
                        return curIn;
                    else
                        upperBound = curIn - 1;
                } else {
                    if (curIn + 1 > nElems - 1 || a[curIn + 1] > searchKey)
                        return curIn + 1;
                    else
                        lowBound = curIn + 1;
                }
            }
        }
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == -1)
            return false;

        /*for (int i=j;i<nElems;i++)
            a[i] = a[i+1];*/
        System.arraycopy(a, j + 1, a, j, nElems - j);
        nElems--;
        return true;
    }

    public long[] merge(long[] src1, long[] src2) {
        long[] dest = new long[src1.length + src2.length];
        int i = 0, j = 0, k;

        for (k = 0; k < dest.length; k++) {
            if (i < src1.length && j < src2.length) {
                if (src1[i] <= src2[j])
                    dest[k] = src1[i++];
                else
                    dest[k] = src2[j++];
            } else if (i == src1.length && j < src2.length)
                dest[k] = src2[j++];
            else if (i < src1.length && j == src2.length)
                dest[k] = src1[i++];
        }
        return dest;
    }

    public void display() {
        for (int i = 0; i < nElems; i++)
            System.out.print(a[i] + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        OrdArray o = new OrdArray(100);
        /*o.insert(21);
        o.insert(24);
        o.insert(234);
        o.insert(33);
        o.insert(455);
        o.insert(44);
        o.insert(75);
        o.insert(13);
        o.insert(34);
        o.insert(57);
        o.insert(12);
        o.insert(87);
        o.display();

        o.insert(66);
        o.display();

        System.out.println(o.find(21));

        o.delete(57);
        o.display();*/

        long[] m = o.merge(new long[]{12, 23, 45}, new long[]{14, 15, 67});
        for (long l : m) {
            System.out.print(l + " ");
        }
        System.out.println("");
    }
}
