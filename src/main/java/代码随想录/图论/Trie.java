package 代码随想录.图论;

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
    public void insert(String word) {
        //得到根节点
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            //根节点的字节点没有这个节点就创建，并挂载
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            //然后把cur变成新增节点
            node = node.children[index];
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
    public boolean startsWith(String prefix) {
        //只要路径里有他即可
        return searchPrefix(prefix) != null;
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
}
