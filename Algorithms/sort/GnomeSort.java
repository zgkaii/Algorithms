package sort;

import static sort.SortUtils.less;
import static sort.SortUtils.swap;
import static sort.SortUtils.print;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/06 21:23
 * @Description: 愚人排序
 **/
public class GnomeSort implements SortAlgorithms {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int i = 1;
        int j = 2;
        while (i < arr.length) {
            if (less(arr[i - 1], arr[i])) i = j++;
            else {
                swap(arr, i - 1, i);
                if (--i == 0) {
                    i = j++;
                }
            }
        }

        return null;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] integers = {4, 23, 6, 78, 1, 26, 11, 23, 0, -6, 3, 54, 231, 9, 12};
        String[] strings = {"c", "a", "e", "b", "d", "dd", "da", "zz", "AA", "aa", "aB", "Hb", "Z"};
        GnomeSort gnomeSort = new GnomeSort();

        gnomeSort.sort(integers);
        gnomeSort.sort(strings);

        System.out.println("After sort : ");
        print(integers);
        print(strings);
    }
}
