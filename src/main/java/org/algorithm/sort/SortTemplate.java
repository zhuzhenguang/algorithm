package org.algorithm.sort;

/**
 * User: zhenguang.zhu
 * Date: 14-1-7
 * Time: 上午8:17
 */
public abstract class SortTemplate {
    public static boolean less(Comparable a, Comparable v) {
        return a.compareTo(v) < 0;
    }

    public static void change(Comparable a[], int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void display(Comparable a[]) {
        System.out.print("Array = ");
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
        }
        System.out.println("");
    }

}
