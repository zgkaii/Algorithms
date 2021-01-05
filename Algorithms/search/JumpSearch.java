package search;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/05 20:56
 * @Description: Jump Search
 **/
public class JumpSearch implements SearchUtil {
    /**
     * @param array the array contains elements
     * @param key   to be searched
     * @return index of {@code key} if found, otherwise <tt>-1</tt>
     */
    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {

        // length of array
        int length = array.length;
        // block size to be jumped
        int blockSize = (int) Math.sqrt(length);

        int limit = blockSize;
        while (key.compareTo(array[limit]) > 0 && limit < array.length - 1) {
            limit = Math.min(limit + blockSize, array.length - 1);
        }

        for (int i = limit - blockSize; i <= limit; i++) {
            if (array[i] == key) {
                // execute linear search
                return i;
            }
        }
        // not found
        return -1;
    }

    /**
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < array.length; i++) {
            assert jumpSearch.find(array, i) == i;
        }
        System.out.println(jumpSearch.find(array, -1) == 3);
        System.out.println(jumpSearch.find(array, 11) == -1);
    }
}
