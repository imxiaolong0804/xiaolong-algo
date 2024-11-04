package class07_暴力递归;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: imxiaolong
 * @Date: 2024/11/1 22:09
 * @Description: 会议安排时间，返回安排最多的会议的次数
 */
public class 贪心 {

    @AllArgsConstructor
    public static class Program {
        public int start;
        public int end;
    }

    public static class ProgramComparator implements Comparator<Program> {
        /**
         * 比较两个Program对象，根据它们的结束时间进行排序。
         *
         * @param o1 第一个Program对象
         * @param o2 第二个Program对象
         * @return 如果o1的结束时间早于o2的结束时间，则返回负数；
         *         如果o1的结束时间晚于o2的结束时间，则返回正数；
         *         如果两者的结束时间相同，则返回0。
         */
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int timePoint) {
        // 首先先以结束时间排序，从小到大
        Arrays.sort(programs, new ProgramComparator());
        // 循环遍历progranms里面的元素
        int res = 0;
        for (Program program : programs) {
            // 如果该会议的开始时间要大于timepoint，就安排，同时timepoint往后移
            if (timePoint >= program.start) {
                res++;
                timePoint = program.end;
            }
        }
        return res;
    }

}
