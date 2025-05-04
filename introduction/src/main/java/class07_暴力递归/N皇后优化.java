package class07_暴力递归;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/2 15:25
 * @Description:
 */
public class N皇后优化 {

    /**
     * @param n 这里的n表示是多少位，我们这里只看就是32位以内的，其他太大的先暂时不考虑
     * @return
     */
    public static int NQueenBinary(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }

        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }


    public static int process2(int limit,
                               int collim,
                               int leftlim,
                               int rightlim) {
        // 首先判断，如果可选的点都选完了，那就没有必要再选了
        if (limit == collim) {
            return 1;
        }
        // 可选位置
        int pos = limit & (~(collim | leftlim | rightlim));
        int res = 0;
        int mostRightOne = 0;
        while (pos != 0) {
            // 这里根据之前学的，选出最右边的一个1占位表示选择这个点位皇后点
            mostRightOne = pos & (~pos + 1);
            // 更新可选点
            pos = pos - mostRightOne;
            res += process2(limit, collim | mostRightOne,
                    (collim | mostRightOne) << 1,
                    (collim | mostRightOne) >> 1
            );
        }
        return res;
    }
}
