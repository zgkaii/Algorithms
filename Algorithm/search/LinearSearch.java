package search;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/05 21:05
 * @Description: Linear search is the easiest search algorithm.It works with sorted and unsorted arrays
 * (an binary search works only with sorted array) This algorithm just compares all elements of an array to
 * find a value.
 *
 * <p>Worst-case performance O(n) Best-case performance O(1) Average performance O(n) Worst-case
 * space complexity
 **/
public class LinearSearch implements SearchUtil {
    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // just generate data
        Random r = new Random();
        int size = 200;
        int maxElement = 100;
        Integer[] integers =
                Stream.generate(() -> r.nextInt(maxElement)).limit(size).toArray(Integer[]::new);

        // the element that should be found
        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        LinearSearch search = new LinearSearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d",
                        shouldBeFound, integers[atIndex], atIndex, size));
    }
}
