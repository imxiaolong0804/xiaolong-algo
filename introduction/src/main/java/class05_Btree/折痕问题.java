package class05_Btree;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/30 15:11
 * @Description:
 */
public class 折痕问题 {
    public static void main(String[] args) {
        int N = 2;
        printAllFolds(N);
    }


    public static void printAllFolds(int N) {
        process(1, N, true);
    }

    /**
     *
     * @param i 当前次数
     * @param n 折多少次
     * @param b true代表凹， fasle代表凸
     */
    private static void process(int i, int n, boolean b) {
        if (i > n) {
            return;
        }
        process(i + 1, n, true);
        System.out.println(b == true? "凹" : "凸");
        process(i + 1, n, false);
    }
}
