package util;


import java.util.HashMap;
import java.util.HashSet;

/**
@Author: imxiaolong
@Date: 2024/10/31 16:40
@Description:
 */
public class Graph {
     public HashMap<Integer, GNode> nodes;
     public HashSet<Edge> edges;

     public Graph() {
         nodes = new HashMap<>();
         edges = new HashSet<>();
     }
}
