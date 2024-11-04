package util;

/**
 * @Author: imxiaolong
 * @Date: 2024/10/31 16:48
 * @Description:
 */
public class Edge {

    public int weight;
    public GNode from;
    public GNode to;

    public Edge(int weight, GNode from, GNode to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
