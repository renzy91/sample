package structure.graph;

/**
 * @author renzhiyong
 * @description:带权重的邻接矩阵图
 * @date 2018-05-13 23:02
 */
public class MatrixWeightGraph {
    /**
     * 无穷大
     */
    private static final int INFINITY = Integer.MAX_VALUE;
    /**
     * 顶点数组
     */
    private Object[] vertex;
    /**
     *邻接矩阵
     */
    private int[][] edge;

    public MatrixWeightGraph(Object[] vertex, LinkInfo[] linkInfos) {
        this.vertex = vertex;
        this.edge = new int[vertex.length][vertex.length];
        initEdge();

        //构建邻接矩阵
        for (LinkInfo linkInfo : linkInfos) {
            edge[linkInfo.edgeHead][linkInfo.edgeTail] = linkInfo.weight;
        }
    }

    /**
     * 初始化邻接矩阵
     */
    private void initEdge() {
        int length = edge.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    edge[i][j] = 0;
                    continue;
                }
                edge[i][j] = INFINITY;
            }
        }
    }

    /**
     * 连接信息
     * edgeHead:弧头下标
     * edgeTail：弧尾下标
     * weight:权重
     */
    public static class LinkInfo {
        int edgeHead;
        int edgeTail;
        int weight;

        public LinkInfo(int edgeHead, int edgeTail, int weight) {
            this.edgeHead = edgeHead;
            this.edgeTail = edgeTail;
            this.weight = weight;
        }

        public int getEdgeHead() {
            return edgeHead;
        }

        public void setEdgeHead(int edgeHead) {
            this.edgeHead = edgeHead;
        }

        public int getEdgeTail() {
            return edgeTail;
        }

        public void setEdgeTail(int edgeTail) {
            this.edgeTail = edgeTail;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        String[] vertex = {"a", "b", "c"};

        MatrixWeightGraph.LinkInfo[] linkInfo = {
            new MatrixWeightGraph.LinkInfo(0, 1, 10),
            new MatrixWeightGraph.LinkInfo(1, 2, 20),
            new MatrixWeightGraph.LinkInfo(2, 0, 30),
            new MatrixWeightGraph.LinkInfo(0, 2, 40),
        };

        MatrixWeightGraph graph = new MatrixWeightGraph(vertex, linkInfo);

        System.out.println();
    }
}
