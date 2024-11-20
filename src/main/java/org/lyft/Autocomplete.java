package org.lyft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Autocomplete {

    /**
     * Create the dictionary with insert and querry methods
     */
    public static class Node {
        char value;
        int freq;

        HashMap<Character, Node> children = new HashMap<>();

        public Node(char value) {
            value = this.value;
        }

        public void insert(String s, int index) {
            freq++;

            if (s.length() == index) {
                return;
            }
            if (!children.containsKey(s.charAt(index))) {
                children.put(s.charAt(index), new Node(s.charAt(index)));
            }
            children.get(s.charAt(index)).insert(s, index + 1);
        }

        // function to check frequency we get a prefix
        int query(String s, int idx) {
            // we have reached end of prefix, terminate by returning the value
            if (s.length() == idx || freq == 1) {
                return 0;
            }
            return children.get(s.charAt(idx)).query(s, idx + 1) + 1;
        }
    }

    public static int autocomplete(List<String> words) {
        Node trie = new Node('$');
        int total = 0;
        for (String word : words) {
            trie.insert(word, 0);
            total += trie.query(word, 0);
        }
        return total + 1;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = splitWords(scanner.nextLine());
        scanner.close();
        int res = autocomplete(words);
        System.out.println(res);
    }
}
