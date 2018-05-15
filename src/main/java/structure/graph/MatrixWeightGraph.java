package structure.graph;

/**
 * @author renzhiyong
 * @description:邻接矩阵存储有向网
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
    private int[][] arc;

    public MatrixWeightGraph(Object[] vertex, LinkInfo[] linkInfos) {
        this.vertex = vertex;
        this.arc = new int[vertex.length][vertex.length];
        initEdge();

        //构建邻接矩阵
        for (LinkInfo linkInfo : linkInfos) {
            arc[linkInfo.arcHead][linkInfo.arcTail] = linkInfo.weight;
        }
    }

    /**
     * 初始化邻接矩阵
     */
    private void initEdge() {
        int length = arc.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    arc[i][j] = 0;
                    continue;
                }
                arc[i][j] = INFINITY;
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
        int arcTail;
        int arcHead;
        int weight;

        public LinkInfo(int arcTail, int arcHead, int weight) {
            this.arcTail = arcTail;
            this.arcHead = arcHead;
            this.weight = weight;
        }

        public int getArcTail() {
            return arcTail;
        }

        public void setArcTail(int arcTail) {
            this.arcTail = arcTail;
        }

        public int getArcHead() {
            return arcHead;
        }

        public void setArcHead(int arcHead) {
            this.arcHead = arcHead;
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
