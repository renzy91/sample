package structure.graph;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-19 20:51
 */
public class MinTree {
    public static void main(String[] args) {
        Object[] vertex = {0, 1, 2, 3, 4, 5};

        LinkInfo[] linkInfo = {
                new LinkInfo(0, 1, 6),
                new LinkInfo(0, 2, 1),
                new LinkInfo(0, 3, 5),
                new LinkInfo(1, 2, 5),
                new LinkInfo(1, 4, 3),
                new LinkInfo(2, 4, 5),
                new LinkInfo(2, 3, 7),
                new LinkInfo(2, 5, 4),
                new LinkInfo(3, 5, 2),
                new LinkInfo(4, 5, 6),
        };

        MatrixGraph graph = new MatrixGraph(vertex, linkInfo);
        graph.printEdges();
        graph.prim(0);

    }

    public static class MatrixGraph {
        private static final int INFINITY = Integer.MAX_VALUE;
        /**
         * 顶点数组
         */
        private Object[] vertex;
        /**
         * 邻接矩阵
         */
        private int[][] edges;

        public MatrixGraph(Object[] vertex, LinkInfo[] linkInfos) {
            this.vertex = vertex;

            edges = new int[vertex.length][vertex.length];
            for (int i = 0; i < vertex.length; i++) {
                for (int j = 0; j < vertex.length; j++) {
                    if (i != j) {
                        edges[i][j] = INFINITY;
                    }
                }
            }

            for (int i = 0; i < linkInfos.length; i++) {
                edges[linkInfos[i].getIvex()][linkInfos[i].getJvex()] = linkInfos[i].getWeight();
                edges[linkInfos[i].getJvex()][linkInfos[i].getIvex()] = linkInfos[i].getWeight();
            }
        }

        /**
         * Prim算法
         *
         * @param verxIndex
         */
        public void prim(int verxIndex) {
            /**
             * 存储相关顶点间权值
             */
            int[] lowWeight = new int[vertex.length];
            /**
             * 下一顶点
             */
            int curVex = verxIndex;
            /**
             * 保存相关顶点下标
             */
            int[] adjvex = new int[vertex.length];

            /**
             * lowWeight初始为verxIndex对应连接的权重
             * adjvex初始为起始节点下标
             */
            for (int i = 0; i < vertex.length; i++) {
                lowWeight[i] = edges[curVex][i];
                adjvex[i] = curVex;
            }

            int minWeight;
            for (int k = 1; k < vertex.length; k++) {
                minWeight = INFINITY;

                for (int i = 0; i < vertex.length; i++) {
                    if (lowWeight[i] != 0 && lowWeight[i] < minWeight) {
                        minWeight = lowWeight[i];
                        curVex = i;
                    }
                }

                //访问该顶点
                System.out.print(adjvex[curVex] + ":" + curVex + " ");
                //将该顶点置为已访问
                lowWeight[curVex] = 0;

                for (int i = 0; i < vertex.length; i++) {
                    if (edges[curVex][i] != 0 && edges[curVex][i] < lowWeight[i]) {
                        lowWeight[i] = edges[curVex][i];
                        adjvex[i] = curVex;
                    }
                }
            }
        }

        public void printEdges() {
            for (int[] edge : edges) {
                for (int i : edge) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }

    }
    /**
     * 连接信息
     * ivex:顶点i下标
     * jvex：顶点j下标
     * weight:权重
     */
    public static class LinkInfo {
        int ivex;
        int jvex;
        int weight;

        public LinkInfo(int ivex, int jvex, int weight) {
            this.ivex = ivex;
            this.jvex = jvex;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getIvex() {
            return ivex;
        }

        public void setIvex(int ivex) {
            this.ivex = ivex;
        }

        public int getJvex() {
            return jvex;
        }

        public void setJvex(int jvex) {
            this.jvex = jvex;
        }
    }
}





