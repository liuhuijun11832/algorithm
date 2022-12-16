package com.joy.string;

/**
 * Trie树
 *
 * @author Joy
 * @date 2022-12-15
 */
public class TrieTree {

    private TrieNode root = new TrieNode('/');

    public void insert(char[] text){
        TrieNode p = root;
        for (char c : text) {
            int index = c - 'a';
            if (p.getChildren()[index] == null) {
                TrieNode trieNode = new TrieNode(c);
                p.getChildren()[index] = trieNode;
            }
            p = p.getChildren()[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] pattern){
        TrieNode p = root;
        for (char c : pattern) {
            int index = c - 'a';
            if (p.getChildren()[index] == null) {
                return false;
            }
            p = p.getChildren()[index];
        }
        return p.isEndingChar;
    }



    public static class TrieNode{
        private char data;
        private TrieNode[] children = new TrieNode[26];

        private boolean isEndingChar = false;

        public boolean isEndingChar() {
            return isEndingChar;
        }

        public void setEndingChar(boolean endingChar) {
            isEndingChar = endingChar;
        }

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public void setChildren(TrieNode[] children) {
            this.children = children;
        }

        public TrieNode(char data) {
            this.data = data;
        }
    }

}
