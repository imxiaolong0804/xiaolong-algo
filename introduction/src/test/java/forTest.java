import org.junit.Test;
import util.GeneraticRandomArray;

import java.util.Arrays;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/23 9:39
 * @Description:
 */
public class forTest {



    @Test
    public void test() {

        int[] ints = GeneraticRandomArray.generateRandomArray(10, 20);
        System.out.println(Arrays.toString(ints));
    }
}
