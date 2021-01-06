package sort;

import java.util.Arrays;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/06 13:15
 * @Description: The class contains util methods
 */
public class SortUtils {
    /**
     * This method checks if first element is greater than the other element
     *
     * @param v first element
     * @param w second element
     * @return true if the first element is greater than the second element
     */
    static <T extends Comparable<T>> boolean greater(T v, T w) {
        return v.compareTo(w) > 0;
    }

    /**
     * Helper method for swapping places in array
     *
     * @param array The array which elements we want to swap
     * @param idx   index of the first element
     * @param idy   index of the second element
     * @return
     */
    static <T> boolean swap(T[] array, int idx, int idy) {
        T swap = array[idx];
        array[idx] = array[idy];
        array[idy] = swap;
        return true;
    }

    /**
     * Prints an array
     *
     * @param toPrint an array which should be printed
     */
    static void print(Object[] toPrint) {
        System.out.println(Arrays.toString(toPrint));
    }

    /**
     * This method checks if first element is less than the other element
     *
     * @param v first element
     * @param w second element
     * @return true if the first element is less than the second element
     */
    static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }
}
