package disjointsets;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/08 23:35
 * @Description: 130. 被围绕的区域 https://leetcode-cn.com/problems/surrounded-regions/
 **/
public class SurroundedRegions {
    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        // 边界上'O'的父节点都是 虚拟节点dummyBorder
        int row = board.length, col = board[0].length, dummyBorder = row * col;
        DisjointSets ds = new DisjointSets(dummyBorder + 1);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    // 遇到'O'进行并查集操作合并
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        // 边界上'O'与dummyNode合并成一个连通区域
                        ds.union(dummyBorder, node(i, col, j));
                        continue;
                    }
                    // 合并上下左右与'O'连接的节点
                    for (int[] dir : directions) {
                        int nx = i + dir[0], ny = j + dir[1];
                        if (nx >= 0 && ny >= 0 && nx < row && ny < col && board[nx][ny] == 'O') {
                            ds.union(node(i, col, j), node(nx, col, ny));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 不与虚拟节点相连的'O'修改为'X'
                if (board[i][j] == 'O' && !ds.isConnected(dummyBorder, node(i, col, j))) board[i][j] = 'X';
            }
        }
    }

    /**
     * 二维坐标转换一维坐标
     */
    public int node(int i, int col, int j) {
        return i * col + j;
    }
}

/**
 * 并查集
 * 周围的‘O’和一个虚拟节点合并
 * 把不和虚拟节点连接的‘O’都改为‘X‘
 */
class DisjointSets {
    int[] parent;

    public DisjointSets(int totalNodes) {
        parent = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parent[i] = i;
        }
    }

    /**
     * 查找m根节点
     */
    public int find(int m) {
        if (m == parent[m]) return m;
        return parent[m] = find(parent[m]);
//        return parent[m] = (m == parent[m] ? m : find(parent[m]));
    }

    /**
     * 合并 m，n 两个点所在的连通区域
     */
    public void union(int m, int n) {
        int rootM = find(m);
        int rootN = find(n);
        if (rootM != rootN) parent[rootM] = rootN;
    }

    /**
     * 判断 m，n 两个点是否在一个连通区域。
     */
    boolean isConnected(int m, int n) {
        return find(m) == find(n);
    }
}
