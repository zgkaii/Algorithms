package search;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.lang.String.format;

/**
 * @Author: Mr.Z
 * @DateTime: 2020/12/23 15:09
 * @Description: 二分查找
 *
 * <p>Binary Search is one of the most popular algorithms.The algorithm finds the position of a target
 * value within a sorted array.
 *
 * <p>Worst-case performance O(log n) Best-case performance O(1) Average performance O(log n)
 * Worst-case space complexity O(1)
 */
class BinarySearch implements SearchUtil {

    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        return search(array, key, 0, array.length);
    }

    private <T extends Comparable<T>> int search(T array[], T key, int left, int right) {
        if (right < left) {
            return -1;// this means that the key not found
        }

        int medium = (left + right) >>> 1;
        int comp = key.compareTo(array[medium]);

        if (comp == 0) {
            return medium;
        } else if (comp < 0) {
            return search(array, key, left, medium - 1);
        } else {
            return search(array, key, medium + 1, right);
        }
    }

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        // Just generate data
        Random r = ThreadLocalRandom.current();

        int size = 100;
        int maxElement = 100000;

        Integer[] integers =
                IntStream.generate(() -> r.nextInt(maxElement))
                        .limit(size)
                        .sorted()
                        .boxed()
                        .toArray(Integer[]::new);

        // The element that should be found
        int shouldBeFound = integers[r.nextInt(size - 1)];

        BinarySearch search = new BinarySearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(format("Should be found: %d. Found %d at index %d. An array length %d",
                shouldBeFound, integers[atIndex], atIndex, size));

        int toCheck = Arrays.binarySearch(integers, shouldBeFound);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b",
                toCheck, toCheck == atIndex));
    }
}
