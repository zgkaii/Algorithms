package sort;

import static sort.SortUtils.greater;
import static sort.SortUtils.swap;
import static sort.SortUtils.print;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/06 13:08
 * @Description: 冒泡排序
 */
public class BubbleSort implements SortAlgorithms {
    /**
     * Implements generic bubble sort algorithm.
     *
     * @param array the array to be sorted.
     * @return the sorted array.
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0, size = array.length; i < size - 1; ++i) {
            boolean swapped = false;
            for (int j = 0; j < size - 1; j++) {
                if (greater(array[j], array[j + 1])) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
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
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(integers);

        for (int i = 0; i < integers.length - 1; ++i) {
            assert integers[i] <= integers[i + 1];
        }
        print(integers); /* output: [1, 4, 6, 9, 12, 23, 54, 78, 231] */

        String[] strings = {"c", "a", "e", "b", "d"};
        bubbleSort.sort(strings);
        for (int i = 0; i < strings.length - 1; i++) {
            assert strings[i].compareTo(strings[i + 1]) <= 0;
        }
        print(bubbleSort.sort(strings)); /* output: [a, b, c, d, e] */
    }
}
