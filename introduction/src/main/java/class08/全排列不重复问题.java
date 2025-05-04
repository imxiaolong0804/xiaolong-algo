package class08;

import org.junit.jupiter.api.Test;
import util.Swap;

import java.util.ArrayList;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/5 9:58
 * @Description:
 */
public class 全排列不重复问题 {

    /**
     * 递归处理字符串的全排列
     *
     * @param str 要处理的字符串
     * @param i   当前处理的字符位置
     * @param res 存储所有全排列结果的列表
     */
    public static void process(char[] str, int i, ArrayList<String> res) {
        // 如果已经处理完所有字符，将当前排列加入结果列表
        if (i == str.length) {
            res.add(String.valueOf(str));
        }
        // 用于记录字符是否已经使用过
        boolean[] visted = new boolean[26];
        // 遍历从当前位置到字符串末尾的所有字符
        for (int j = i; j < str.length; j++) {
            // 如果当前字符还没有使用过
            if (!visted[str[j] - 'a']) {
                // 标记当前字符为已使用
                visted[str[j] - 'a'] = true;
                // 交换当前字符和起始字符
                Swap.swap(str, i, j);
                // 递归处理下一个字符
                process(str, i + 1, res);
                // 恢复交换前的状态(回溯）
                Swap.swap(str, j, i);
            }
        }
    }


    @Test
    public void test_sort() {

        char[] chars = {'a', 'b', 'c', 'g', 'd'};
        ArrayList<String> res = new ArrayList<>();
        process(chars, 0, res);
        res.forEach(System.out::println);
    }
}
