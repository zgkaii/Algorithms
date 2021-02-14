package dp;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/14 00:30
 * @Description: 403. 青蛙过河 https://leetcode-cn.com/problems/frog-jump/
 **/
public class FrogJump {
    public boolean canCross1(int[] stones) {
        int N = stones.length;
        // 最贪心走法 [0, 1, 3, 6, 10, 15, 21, ...] an = a(n-1) + n = (n - 1) * n / 2
        // 最右可达石头 < 0 + (1 + N - 1) * (N - 1) / 2
        if (stones == null || N == 0 || stones[1] != 1 ||
                stones[N - 1] > (N * (N - 1)) / 2) return false;
        // key——石头所在格数; value——从当前石头跳到下一个石头的所有步数集合
        // {0=[1], 1=[1, 2], 3=[1, 2, 3], 5=[1, 2, 3], 6=[1, 2, 3, 4], 8=[1, 2, 3, 4], 12=[3, 4, 5], 17=[]}
        // 可达最后石头，返回true，无需计算到最后一块石头。
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(N);
        for (int i = 0; i < N; i++) map.put(stones[i], new HashSet<>());
        map.get(0).add(1);

        for (int i = 0; i < N - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[N - 1]) return true;
                // 通过step，step+1，step-1来更新该石头达到后面任何石头的步数集合。
                HashSet<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }
        return false;
    }

    public boolean canCross2(int[] stones) {
        // {0=[1], 1=[0, 1, 2], 3=[1, 2, 3], 5=[1, 2, 3], 6=[0, 1, 2, 3, 4], 8=[1, 2, 3, 4], 12=[3, 4, 5], 17=[5, 6, 7]}
        // index:        0   1   2   3   4   5   6   7
        //             +---+---+---+---+---+---+---+---+
        // stone pos:  | 0 | 1 | 3 | 5 | 6 | 8 | 12| 17|
        //             +---+---+---+---+---+---+---+---+
        // k:        0 | 0 | 1 | 0 | 0 | 1 | 0 | 0 | 0 |
        //           1 | 1 | 1 | 1 | 1 | 1 | 1 | 0 | 0 |
        //           2 | 0 | 1 | 1 | 1 | 1 | 1 | 0 | 0 |
        //           3 | 0 | 0 | 1 | 1 | 1 | 1 | 1 | 0 |
        //           4 | 0 | 0 | 0 | 0 | 1 | 1 | 1 | 0 |
        //           5 | 0 | 0 | 0 | 0 | 0 | 0 | 1 | 1 |
        //           6 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |
        //           7 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |
        int N = stones.length;
        boolean[][] dp = new boolean[N][N + 1];
        dp[0][1] = true;

        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                int diff = stones[i] - stones[j];
                if (diff < 0 || diff > N || !dp[j][diff]) continue;
                dp[i][diff] = true;
                if (diff - 1 >= 0) dp[i][diff - 1] = true;
                if (diff + 1 <= N) dp[i][diff + 1] = true;
                if (i == N - 1) return true;
            }
        }
        return false;
    }
}
