package list;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/04/26 19:13
 * @Description: The realization method of Skip List.
 * This jump table stores non-repeated positive integers.
 **/
public class SkipList {
    private static final float SKIPLIST_P = 0.5f;
    private static final float MAX_LEVEL = 16;

    private int levelCount = 1;

    private SkipNode head = new SkipNode();

    /**
     * find the element equals to value
     */
    private SkipNode find(int value) {
        SkipNode p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    /**
     * insert an element to SkipList
     */
    private void insert(int value) {
        int level = randomLevel();
        SkipNode newNode = new SkipNode();
        newNode.data = value;
        newNode.maxLevel = value;
        SkipNode update[] = new SkipNode[level];
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        // recode every level largest value which smaller than insert value in update[]
        SkipNode p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;// use update save node in search path
        }

        // in search path node next node become new node forwords(next)
        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // update node hight
        if (levelCount < level) levelCount = level;
    }

    public void delete(int value) {
        SkipNode[] update = new SkipNode[levelCount];
        SkipNode p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }

        while (levelCount > 1 && head.forwards[levelCount] == null) {
            levelCount--;
        }
    }

    /**
     * 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
     * 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
     * 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
     * 50%的概率返回 1; 25%的概率返回 2; 12.5%的概率返回 3 ...
     */
    private int randomLevel() {
        int level = 1;

        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) {
            level += 1;
        }
        return level;
    }

    public void printAll() {
        SkipNode p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    public class SkipNode {
        private int data = -1;
        private SkipNode forwards[] = new SkipNode[(int) MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        SkipList list = new SkipList();
        list.insert(3);
        list.insert(3);
        list.insert(2);
        list.insert(4);
        list.insert(10);
        list.insert(4);
        list.insert(5);
        list.insert(4);
        list.printAll();
    }
}


