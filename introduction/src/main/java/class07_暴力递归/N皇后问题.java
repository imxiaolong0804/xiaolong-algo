package class07_暴力递归;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/2 14:47
 * @Description:
 */
public class N皇后问题 {


    public static int Nqueen(int n) {
        if (n <= 3) {
            return 0;
        }

        int[] records = new int[n]; // 相当于records[0] = k表示第零行第k个位置
        return process(0, records);
    }


    public static int process(int i, int[] records) {
        // 这表明已经到达最后走完最后一行了，说明有这种走法
        if (i == records.length) {
            return 1;
        }
        int res = 0;
        // 尝试所有的列
        for (int j = 0; j < records.length; j++) {
            if (isValid(records, i, j)) {
                records[i] = j;
                process(i + 1, records);
            }
        }
        return res;
    }


    public static boolean isValid(int[] records, int i, int j) {
        // 这里只需要判断前i-1行的records就可以了，因为后面的数据还没有记录
        for (int k = 0; k < i; k++) {
            // 因为已经不可能是同一行了，所以只需要判断是否是同一列就可以了
            if (records[k] == j || Math.abs(records[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }
}
