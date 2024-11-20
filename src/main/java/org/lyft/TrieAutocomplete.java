package org.lyft;

import java.util.HashMap;
import java.util.Map;

public class TrieAutocomplete {
    class Trie {

        // using map we can extend our solution to other english characters apart from lowercase
        public Map<Character, Trie> children;
        public Character curr;
        // denotes if current character marks end of word
        public boolean isWord = false;

        public Trie() {
            children = new HashMap<>();
            // dummy character for root trie
            curr = '-';
        }

        public Trie(Character curr) {
            children = new HashMap<>();
            this.curr = curr;
        }

        public void insert(String word) {
            // traverse similar to linked list but next node is
            //determined by characters of word
            Trie temp = this;
            for (char ch : word.toCharArray()) {
                temp.children.putIfAbsent(ch, new Trie(ch));
                temp = temp.children.get(ch);
            }
            // for word we assign last character trie's isWord property to be true
            temp.isWord = true;
        }

        public boolean search(String word) {
            // traverse similar to linked list but next node is
            //determined by characters of word
            Trie temp = this;
            for (char ch : word.toCharArray()) {
                if (!temp.children.containsKey(ch)) {
                    return false;
                }
                temp = temp.children.get(ch);
            }
            // for word it is necessary for isWord property to be true
            return temp.isWord;
        }

        public boolean startsWith(String prefix) {
            // traverse similar to linked list but next node is
            //determined by characters of word
            Trie temp = this;
            for (char ch : prefix.toCharArray()) {
                if (!temp.children.containsKey(ch)) {
                    return false;
                }
                temp = temp.children.get(ch);
            }
            // for prefix it is not necessary for isWord property to be true
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

}
