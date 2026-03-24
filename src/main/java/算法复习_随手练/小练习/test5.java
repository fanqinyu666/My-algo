package 算法复习_随手练.小练习;


import java.util.*;

public class test5 {

    class Trie {
        //数组，他是个多叉树
        private Trie[] children;

        private boolean isEnd;

        public Trie() {
            //26个
            children = new Trie[26];
            //是否时末尾节点
            isEnd = false;
        }

        public void insert(String word){
            //得到根节点
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';


            }
            //一直到最后一个值，设置为true
            node.isEnd = true;
        }

        public boolean search(String word) {
            //找到这个节点
            Trie node = searchPrefix(word);
            //必须有这个节点+这个节点最后一个是true
            return node != null && node.isEnd;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
        public boolean startsWith(String prefix) {
            //只要路径里有他即可
            return searchPrefix(prefix) != null;
        }



    }

}