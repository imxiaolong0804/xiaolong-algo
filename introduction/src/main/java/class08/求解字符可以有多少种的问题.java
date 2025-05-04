package class08;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/6 21:37
 * @Description:
 */
public class 求解字符可以有多少种的问题 {

    public static int process(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (i == '0') {
            return 0;
        }
        if (i == '1') {
            // 两种情况，一种是i看为一个整体
            int res = process(str, i + 1);
            // 一种是i和i+1看为一个整体，但是要判断i+1是否存在
            if (i + 1 < str.length) {
                res += process(str, i + 2);
            }
            return res;
        }
        if (i == '2') {
            // 两种情况，一种是i看为一个整体
            int res = process(str, i + 1);
            // 一种是i和i+1看为一个整体，但是要判断i+1是否再0-6之间，因为只有26个字母可以选择
            if (i + 1 < str.length && str[i + 1] >= '0' && str[i + 1] <= '6') {
                res += process(str, i + 2);
            }
            return res;
        }
        // 其他情况的话就只能自己单独一组了
        return process(str, i + 1);
    }
}
