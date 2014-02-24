package org.algorithm.sort;

/**
 * User: zhenguang.zhu
 * Date: 13-8-19
 * Time: 下午3:59
 */
public class MySort {
    private long[] array;

    public MySort(long[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("初始化数组错误！");
        this.array = array;
    }

    public void bubSort() {
        int j = array.length - 1;
        while (j >= 0) {
            for (int k = 0; k < j; k++)
                if (array[k] > array[k + 1])
                    swap(k, k + 1);
            j--;
        }
    }

    private void swap(int one, int two) {
        long temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }

    public void selectSort() {
        int j = 0;
        while (j < array.length - 1) {
            int lowest = j;
            for (int i = j + 1; i < array.length; i++)
                if (array[i] < array[lowest])
                    lowest = i;
            swap(j, lowest);
            j++;
        }
    }

    public void insertSort() {
        int mark = 0;
        while (mark < array.length) {
            for (int i = 0; i < mark; i++)
                if (array[i] > array[mark]) {
                    long temp = array[mark];
                    /*for (int j = mark; j > i; j--) {
                        array[j] = array[j - 1];
                    }*/
                    System.arraycopy(array, i, array, i + 1, mark - i);
                    array[i] = temp;
                }
            mark++;
        }
    }

    public void insertSort2() {
        int mark = 1;
        while (mark < array.length) {
            long temp = array[mark];
            int j;
            //System.out.println(temp);
            for (j = mark; j > 0 && array[j - 1] >= temp; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
            mark++;
        }
    }

    public void display() {
        for (long l : array)
            System.out.print(l + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        /*MySort bubbleSort = new MySort(new long[]{23, 5, 45, 232, 56, 123, 4545, 12, 234});
        bubbleSort.display();
        bubbleSort.bubSort();
        bubbleSort.display();*/

        /*MySort selectSort = new MySort(new long[]{23, 5, 45, 232, 56, 123, 4545, 12, 234});
        selectSort.display();
        selectSort.selectSort();
        selectSort.display();*/

        MySort insertSort = new MySort(new long[]{23, 5, 45, 232, 56, 123, 4545, 12, 234});
        insertSort.display();
        insertSort.insertSort2();
        insertSort.display();
    }

}
