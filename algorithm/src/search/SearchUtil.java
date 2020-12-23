package search;

/**
 * @Author: Mr.Z
 * @DateTime: 2020/12/23 15:12
 * @Description: The common interface of most searching algorithms
 */
public interface SearchUtil {
    /**
     * @param array is an array where the element should be found
     * @param key is an element which should be found
     * @param <T> Comparable type
     * @return first found index of the element
     */
    <T extends Comparable<T>> int find(T array[], T key);
}
