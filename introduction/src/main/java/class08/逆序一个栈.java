package class08;

import java.util.Stack;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/6 21:12
 * @Description:
 */
public class 逆序一个栈 {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = f(stack); // 这里相当于拿到栈底元素
        // 再次递归，这里可以理解为一直递归到最后一个元素后反压回去
        reverse(stack);
        // 第一次执行这个的肯定是栈顶元素
        stack.add(i);
    }


    /**
     * 黑盒函数，将栈中的最后一个数给弹出，其他的相对位置不变
     * @param stack
     * @return
     */
    public static int f(Stack<Integer> stack) {
        int res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        } else {
            int last = f(stack);
            stack.add(res);
            return last;
        }
    }
}
