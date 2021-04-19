package util;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Trie208
{
    public static void main(String[] args)
    {
        Trie208 obj = new Trie208();
        obj.insert("wor");
        obj.insert("word");
        boolean param_2 = obj.search("word");
        boolean param_3 = obj.search("wor");
        boolean param_4 = obj.startsWith("wor");
        System.out.println(param_2 + " " + param_3 + " " + param_4);
    }

    TrieNode head = new TrieNode('#', false);

    /**
     * Initialize your data structure here.
     */
    public Trie208()
    {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word)
    {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] chs = word.toCharArray();
        TrieNode node = head;
        for (int i = 0; i < chs.length - 1; i++) {
            node = node.addChild(chs[i], false);
        }
        node.addChild(chs[chs.length - 1], true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word)
    {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] chs = word.toCharArray();
        Optional<TrieNode> node = Optional.of(head);
        for (char ch : chs) {
            if (node.isPresent()) {
                node = node.get().containChild(ch);
            }
            else {
                return false;
            }
        }
        return node.isPresent() && node.get().isLeaf();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix)
    {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }
        char[] chs = prefix.toCharArray();
        Optional<TrieNode> node = Optional.of(head);
        for (char ch : chs) {
            if (node.isPresent()) {
                node = node.get().containChild(ch);
            }
            else {
                return false;
            }
        }
        return node.isPresent();
    }

    private static class TrieNode
    {
        private final Map<Character, TrieNode> child = new HashMap<>();
        private final char ch;
        private boolean hasEnd;

        public TrieNode(char content, boolean hasEnd)
        {
            if (content < 'a' || content > 'z') {
                if (content != '#') {
                    throw new UnsupportedOperationException("unsupport char:" + content);
                }
            }
            this.hasEnd = hasEnd;
            this.ch = content;
        }

        public boolean isHasEnd()
        {
            return this.hasEnd;
        }

        public void setHasEnd(boolean hasEnd)
        {
            this.hasEnd = hasEnd;
        }

        public char getCh()
        {
            return this.ch;
        }

        public boolean isLeaf()
        {
            return this.hasEnd;
        }

        public TrieNode addChild(char ch, boolean isEnd)
        {
            TrieNode node;
            if (this.child.containsKey(ch)) {
                node = this.child.get(ch);
                if (isEnd) {
                    node.setHasEnd(true);
                }
            }
            else {
                node = new TrieNode(ch, isEnd);
                this.child.put(ch, node);
            }
            return node;
        }

        public Optional<TrieNode> containChild(char ch)
        {
            if (this.child.containsKey(ch)) {
                return Optional.of(this.child.get(ch));
            }
            else {
                return Optional.empty();
            }
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */