package org.algorithm.array;

/**
 * User: zhenguang.zhu
 * Date: 13-7-30
 * Time: 下午3:54
 */
public class MyOrderedArray {
    private int[] orderedArray;
    private int actualLength;

    public MyOrderedArray(int initCapacity) {
        if (initCapacity == 0) {
            throw new IllegalArgumentException("初始数组容量要大于0");
        }
        this.orderedArray = new int[initCapacity];
        this.actualLength = 0;
    }

    public MyOrderedArray(int[] initArray) {
        if (initArray == null) {
            throw new IllegalArgumentException("初始数组为空");
        }
        this.orderedArray = new int[initArray.length];
        this.actualLength = 0;
    }

    /*public SearchResult recursiveSearch(int[] initArray, int value) {
        if (initArray == null || initArray.length == 0) {
            throw new IllegalArgumentException("初始数组错误");
        }

        step++;

        int initLength = initArray.length;
        int start = initArray[0];
        int middle = initArray[initLength / 2];
        int last = initArray[initLength - 1];

        if (start == value) {
            return new SearchResult(step, index, start);
        } else if (middle == value) {
            index += initLength / 2;
            return new SearchResult(step, index, middle);
        } else if (last == value) {
            index += initLength - 1;
            return new SearchResult(step, index, last);
        }

        if (start < value && middle > value) {
            return recursiveSearch(copyArray(initArray, 0, initLength / 2), value);
        } else {
            index += initLength / 2;
            return recursiveSearch(copyArray(initArray, initLength / 2, initLength), value);
        }
    }*/

    /**
     * 使用循环的二分查找
     *
     * @param value
     * @return
     */
    public int search(int value) {
        int startIndex = 0;
        int endIndex = orderedArray.length;

        while (true) {
            int middleIndex = (startIndex + endIndex) / 2;
            int middleValue = orderedArray[middleIndex];

            if (middleValue == value)
                return middleIndex;
            else if (endIndex < startIndex)
                return -1;
            else {
                if (value < middleValue)
                    endIndex = middleIndex - 1;
                else
                    startIndex = middleIndex + 1;
            }
        }
    }

    /**
     * 使用递归的二分查找
     *
     * @param value
     * @param indexes
     * @return
     */
    public int recursiveSearch(int value, int... indexes) {
        if (indexes.length != 0 && indexes.length != 2) {
            throw new IllegalArgumentException("数组起始位置不对");
        }

        int startIndex = indexes.length == 0 ? 0 : indexes[0];
        int endIndex = indexes.length == 0 ? orderedArray.length : indexes[1];

        int middleIndex = (startIndex + endIndex) / 2;
        int middleValue = orderedArray[middleIndex];
        if (middleValue == value)
            return middleIndex;
        else if (endIndex < startIndex)
            return -1;
        else {
            if (value < middleValue)
                return recursiveSearch(value, startIndex, middleIndex - 1);
            else
                return recursiveSearch(value, middleIndex + 1, endIndex);
        }
    }

    /**
     * 增加数据
     *
     * @param value
     */
    public boolean insert(int value) {
        int i;
        for (i = 0; i < actualLength; i++)
            if (getOrderedArray()[i] > value)
                break;

        int j;
        for (j = actualLength; j > i; j--)
            if (j + 1 <= getOrderedArray().length)
                getOrderedArray()[j + 1] = getOrderedArray()[j];

        getOrderedArray()[j] = value;
        actualLength++;
        return true;
    }

    /**
     * 删除数据
     *
     * @param value
     */
    public boolean delete(int value) {
        int deleteIndex = search(value);
        if (deleteIndex == -1) {
            return false;
        }

        int i;
        for (i = deleteIndex; i < getOrderedArray().length; i++) {
            getOrderedArray()[i] = getOrderedArray()[i + 1];
            actualLength--;
        }
        return true;
    }

    public int[] getOrderedArray() {
        return orderedArray;
    }

    private void setOrderedArray(int[] orderedArray) {
        this.orderedArray = orderedArray;
    }

    public static void main(String[] args) {
        //int[] initArray = {2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 56, 212, 214, 435};
        MyOrderedArray orderedArray = new MyOrderedArray(100);

        /*int index = orderedArray.search(10);
        System.out.println(index);

        int recursiveIndex = orderedArray.recursiveSearch(10);
        System.out.println(recursiveIndex);

        orderedArray.delete(7);
        System.out.println(orderedArray);*/

        orderedArray.insert(16);
        orderedArray.insert(17);
        System.out.println(orderedArray);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < actualLength; i++) {
            result.append(String.valueOf(getOrderedArray()[i])).append(", ");
        }
        return result.toString();
    }
}
