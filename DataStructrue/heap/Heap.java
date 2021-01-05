package heap;

/**
 * @Author: Mr.Z
 * @DateTime: 2020/12/24 10:49
 * @Description: Interface common to heap data structures.<br>
 *
 *  <p>Heaps are tree-like data structures that allow storing elements in a specific way. Each node
 *  corresponds to an element and has one parent node (except for the root) and at most two children
 *  nodes. Every element contains a key, and those keys indicate how the tree shall be built. For
 *  instance, for a min-heap, the key of a node shall be greater than or equal to its parent's and
 *  lower than or equal to its children's (the opposite rule applies to a max-heap).
 *
 *  <p>All heap-related operations (inserting or deleting an element, extracting the min or max) are
 *  performed in O(log n) time.
 */
public interface Heap {
}
