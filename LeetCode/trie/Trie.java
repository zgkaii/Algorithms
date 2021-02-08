package trie;

/**
 * @Author: Mr.Z
 * @DateTime: 2021/02/08 14:27
 * @Description: 208. 实现 Trie (前缀树) https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 */
class TrieNode {
    TrieNode[] child;
    boolean end;

    public TrieNode() {
        child = new TrieNode[26];
        end = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (currentNode.child[cur - 'a'] == null) currentNode.child[cur - 'a'] = new TrieNode();
            currentNode = currentNode.child[cur - 'a'];
        }
        currentNode.end = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (currentNode.child[cur - 'a'] == null) return false;
            currentNode = currentNode.child[cur - 'a'];
        }
        return currentNode.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);
            if (currentNode.child[cur - 'a'] == null) return false;
            currentNode = currentNode.child[cur - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}