package class08;

import org.junit.jupiter.api.Test;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/5 9:35
 * @Description:
 */
public class abc走与不走问题 {


    @Test
    public void test_abcQ() {
        String str = "abc";
        char[] charArray = str.toCharArray();
        process(charArray, 0);
    }


    public static void process(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }
        // 要这个位置
        process(str, i + 1);
        char temp = str[i];
        str[i] = ' ';
        // 不要这个位置
        process(str, i + 1);
        str[i] = temp;
    }



    @Test
    public void test() {
        String str = "abc";
        char[] charArray = str.toCharArray();
        charArray[0] = 0;
        System.out.printf(String.valueOf(charArray));
    }
}
