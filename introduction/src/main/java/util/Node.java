package util;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/28 21:39
 * @Description:
 */
@Data
@NoArgsConstructor
public class Node {

    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
