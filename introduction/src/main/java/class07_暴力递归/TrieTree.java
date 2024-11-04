package class07_暴力递归;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/1 19:27
 * @Description: 前缀树，具体可以晚上搜
 */
public class TrieTree {


    public static class TrieNode {

        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26]; // 用26大小的数组来表示a-z的路线
        }
    }

    public static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }


        /**
         * 将单词插入到字典树中。
         *
         * @param word 需要插入的单词
         */
        public void insert(String word) {
            // 先将字符串word转换为array数组
            char[] wordCharArray = word.toCharArray();
            TrieNode cur = root;
            // 然后给root节点的的pass加一
            cur.pass++;
            // 然后开始循环加入next节点
            int index = 0;
            for (int i = 0; i < wordCharArray.length; i++) {
                index = wordCharArray[i] - 'a'; // 这里是ascii码来算出index的
                // 判断next中是否有这个字母，如果有就不用新建了
                if (cur.nexts[index] == null) {
                    cur.nexts[index] = new TrieNode();
                }
                // 从next中拿出这个节点
                cur = cur.nexts[index];
                // 然后自增
                cur.pass++;
            }
            // 最后循环完后将最后一个节点的End加加
            cur.end++;
        }


        public int search(String word) {

            // 同样的将字符串转为char数组
            char[] chars = word.toCharArray();
            // 头节点
            TrieNode cur = root;
            int index = 0;
            for (char c : chars) {
                index = c - 'a'; // 找出这个字符对应的nexts数组中的下标
                // 如果在nexts中没有保存这个word的任何信息，比如abc，其中某个没有保存过
                if (cur.nexts[index] == null) {
                    return 0;
                }
                cur = cur.nexts[index];
            }
            return cur.end;
        }


        /**
         * 根据给定前缀计算其对应的数字。
         *
         * @param prefix 前缀字符串
         * @return 对应前缀的数字
         */
        public int prefixNumber(String prefix) {
            if (prefix == null) {
                return 0;
            }
            char[] chars = prefix.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (char c : chars) {
                index = c - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

        /**
         * 从字典树中删除一个单词。
         *
         * @param word 要删除的单词
         * @return 如果单词存在并成功删除则返回true，否则返回false
         */
        public boolean delete(String word) {
            // 先判断一下是否可以删除，也就是有没有这个东西
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                int index = 0;
                TrieNode node = root;
                // 上来先对root节点的pass减减一下
                node.pass--;
                for (char c : chars) {
                    index = c - 'a';
                    // 对路上的每一个点的pass都减一
                    node.nexts[index].pass--;
                    // 这里再看如果删除pass后为0了，说明这条路都断了，直接删除这个节点了
                    if (node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return true;
                    }
                    node = node.nexts[index];
                }
                node.end--;
                return true;
            }
            return false;
        }
    }
}
