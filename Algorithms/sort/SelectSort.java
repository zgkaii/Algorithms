package sort;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/06 14:52
 * @Description: 选择排序
 */
public class SelectSort implements SortAlgorithms {
    /**
     * This method implements the Generic Selection Sort
     *
     * @param array The array to be sorted Sorts the array in increasing order
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // Initial index of min
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[min].compareTo(array[j]) < 0) {
                    min = j;
                }
            }
            // Swapping if index of min is changed
            if (min != i) {
                swap(array, i, min);
            }
        }
        return array;
    }

    /**
     * This method swaps the two elements in the array
     *
     * @param <T>
     * @param arr, i, j The array for the swap and the indexes of the to-swap elements
     */
    public <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        SelectSort selectionSort = new SelectSort();
        Integer[] sorted = selectionSort.sort(arr);

        // Output => 1	  4	 6	9	12	23	54	78	231
        SortUtils.print(sorted);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        String[] sortedStrings = selectionSort.sort(strings);

        // Output => a	b	 c  d	e
        SortUtils.print(sortedStrings);
    }
}
