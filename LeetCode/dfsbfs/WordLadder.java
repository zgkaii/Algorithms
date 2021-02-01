package dfsbfs;

import java.util.*;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/01/31 19:53
 * @Description: 127.单词接龙 https://leetcode-cn.com/problems/word-ladder/
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 **/
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        // 记录单词是否被访问过，如果没被访问过就加入进来
        Set<String> visited = new HashSet<>();
        // 创建两个队列
        Queue<String> startQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        startQueue.add(beginWord);
        endQueue.add(endWord);

        int step = 1;
        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            // 双向广度优先遍历
            int res = dfs(step, startQueue, endQueue, wordSet, visited);
            // -1表明没相遇
            if (res != -1) return res;
            step++;
        }
        return 0;
    }

    private int dfs(int step, Queue<String> startQueue, Queue<String> endQueue, Set<String> wordSet, Set<String> visited) {
        int startCount = startQueue.size(), endCount = endQueue.size();
        boolean start = startCount <= endCount;
        int count = start ? startCount : endCount;

        for (int i = 0; i < count; i++) {
            String word;
            if (start) word = startQueue.poll();
            else word = endQueue.poll();

            // 遍历每一个节点的单词，然后修改其中一个字符，让他成为一个新的单词，
            // 并查看这个新的单词在字典中是否存在，如果存在并且没有被访问过，就加入到队列中
            for (int j = 0; j < word.length(); j++) {
                char[] ch = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == word.charAt(j)) continue;
                    ch[j] = c;
                    // 修改其中的一个字符，然后重新构建一个新的单词
                    String newWord = String.valueOf(ch);
                    if (wordSet.contains(newWord)) {
                        if (start) {
                            //从前往后
                            if (endQueue.contains(newWord)) return step + 1;
                            if (visited.add(newWord)) startQueue.add(newWord);
                        } else {//从后往前
                            if (startQueue.contains(newWord)) return step + 1;
                            if (visited.add(newWord)) endQueue.add(newWord);
                        }
                    }
                }
            }
        }
        //如果没有相遇就返回-1
        return -1;
    }
}
