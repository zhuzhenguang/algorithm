package org.algorithm.sort;

/**
 * User: zhenguang.zhu
 * Date: 14-1-7
 * Time: 上午10:54
 */
public class Partition extends SortTemplate {
    public static int partitionIt(Integer[] a, int left, int right, Integer pivot) {
        int leftPtr  = left - 1;
        int rightPtr = right + 1;

        while (true) {
            while (leftPtr < right && a[++leftPtr] < pivot);
            while (rightPtr > left && a[--rightPtr] > pivot);
            if (leftPtr >= rightPtr)
                break;
            else
                change(a, leftPtr, rightPtr);
        }
        return leftPtr;
    }

    public static void main(String[] args) {
        Integer[] a = {12, 32, 12, 5, 2, 8};
        int r = partitionIt(a, 0, a.length - 1, 9);
        System.out.println(r);
        display(a);
    }
}
