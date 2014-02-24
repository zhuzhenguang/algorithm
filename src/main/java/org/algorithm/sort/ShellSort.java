package org.algorithm.sort;

/**
 * User: zhenguang.zhu
 * Date: 14-1-7
 * Time: 上午8:16
 */
public class ShellSort extends SortTemplate {
    public static void sort(Integer[] a) {
        int N = a.length;
        int h = 1;
        while (h <= N / 3)
            h = h * 3 + 1;
        System.out.println(h);

        int outer, inner, temp;
        while (h > 0) {
            for (outer = h; outer < N; outer++) {
                temp = a[outer];
                inner = outer;
                while (inner > h - 1 && a[inner - h] >= temp) {
                    a[inner] = a[inner - h];
                    inner -= h;
                }
                a[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    public static void sort2(Integer[] a) {
        int h = 1;
        while (h <= a.length / 3) h = h * 3 + 1;
        System.out.println(h);

        while (h >= 1) {
            for (int i = h; i < a.length; i++)
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    change(a, j, j - h);

            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {12, 34, 13, 4, 2, 1};
        sort2(a);
        display(a);
    }
}
