package sort;

import static sort.SortUtils.less;
import static sort.SortUtils.print;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/06 20:58
 * @Description: 希尔排序
 **/
public class ShellSort implements SortAlgorithms {

    /**
     * Implements generic shell sort.
     *
     * @param array the array to be sorted.
     * @param <T>   the type of elements in the array.
     * @return the sorted array.
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int length = array.length - 1;
        int gap = 1;

        while (gap < length / 3) {
            gap = 3 * gap + 1;
        }

        for (; gap > 0; gap /= 3) {
            for (int i = gap; i < length; i++) {
                int j;
                T temp = array[i];
                for (j = i; j >= gap && less(temp, array[j - gap]); j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
        return array;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] toSort = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        ShellSort sort = new ShellSort();
        sort.sort(toSort);
        for (int i = 0; i < toSort.length - 1; ++i) {
            assert toSort[i] <= toSort[i + 1];
        }
        print(toSort);
    }
}
