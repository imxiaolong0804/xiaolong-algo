package class08;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/4 21:51
 * @Description:
 */
public class 汉诺塔问题 {

    public static void hanoi(int n) {
        func(n, "左", "中", "右");
    }

    private static void func(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            func(n - 1, from, other, to);
            System.out.println("Move " + n + " from " + from + " to " + to);
            func(n - 1, other, to, from);
        }
    }

    public static void main(String[] args) {
        hanoi(3);
    }

}
