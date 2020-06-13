//problem link https://www.hackerrank.com/challenges/contacts/problem

import java.util.*;

public class Contacts {
    private static Trie trie;

    static int[] contacts(String[][] queries) {
        trie = new Trie();
        ArrayList<Integer> results = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0].equals("add")) {
                trie.insert(queries[i][1]);
            } else {
                results.add(trie.hasNodes(queries[i][1]));
            }
        }
        return results.stream().mapToInt(e -> e.intValue()).toArray();
    }


    public static void main(String[] args) {
        String[][] q = new String[][]{
                {"add", "s"},
                {"add", "ss"},
                {"add", "sss"},
                {"add", "ssss"},
                {"add", "sssss"},
                {"add","hack"},
                {"add","hackerrank"},
                {"find", "s"},
                {"find", "ss"},
                {"find", "sss"},
                {"find","ha"}

        };
        int[] r = contacts(q);
        Arrays.stream(r).forEach(System.out::println);
    }
}


class TrieNode {
    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean endOfWord;
    public int c=0;

    Map<Character, TrieNode> getChildren() {
        return children;
    }

    boolean isEndOfWord() {
        return endOfWord;
    }

    void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}

class Trie {
    private TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode current = root;

        for (char l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
            current.c++;
        }
        current.setEndOfWord(true);
    }

    int hasNodes(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return 0;
            }
            current = node;
        }
        return current.c;
    }

}
