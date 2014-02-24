package org.algorithm.search;

import java.util.Arrays;

/**
 * 二分查找
 * <p/>
 * User: zhenguang.zhu
 * Date: 14-2-21
 * Time: 下午5:23
 */
public class BinarySearch {
    private int[] array;

    public BinarySearch(int[] array) {
        this.array = array;
    }

    public int search(int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (key > array[middle])
                low = middle + 1;
            else if (key < array[middle])
                high = middle - 1;
            else
                return middle;
        }

        return -1;
    }

    public void print() {
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {23, 3599, 123, 345, 3, 4, 45, 35, 78, 34, 78, 67, 43};
        Arrays.sort(array);
        BinarySearch aSearch = new BinarySearch(array);
        aSearch.print();
        System.out.println(aSearch.search(23));
        System.out.println(aSearch.search(43));
        System.out.println(aSearch.search(3599));
    }
}
