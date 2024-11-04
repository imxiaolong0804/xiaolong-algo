package util;


import java.util.ArrayList;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/31 16:42
 * @Description:
 */
public class GNode {

    public int value;
    public int in;
    public int out;
    public ArrayList<GNode> nexts;
    public ArrayList<Edge> edges;

    public GNode(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
