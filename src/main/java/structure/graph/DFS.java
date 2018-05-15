package structure.graph;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-15 23:50
 */
public class DFS {
    public static void main(String[] args) {
        String[] vertex = {"v0", "v1", "v2", "v3", "v4", "v5", "v6", "v7"};

        LinkInfo[] linkInfo = {
                new LinkInfo(0, 1),
                new LinkInfo(1, 2),
                new LinkInfo(2, 5),
                new LinkInfo(0, 4),
                new LinkInfo(1, 4),
                new LinkInfo(0, 3),
                new LinkInfo(3, 6),
                new LinkInfo(4, 6),
                new LinkInfo(6, 7),
        };

        MatrixGraph graph = new MatrixGraph(vertex, linkInfo);

        graph.printEdges();

        // v0,v1,v2,v5,v4,v6,v7,v3
        graph.DFS(0);

    }
}

class MatrixGraph {
    private static final int INFINITY = Integer.MAX_VALUE;
    /**
     * 顶点数组
     */
    private Object[] vertex;
    /**
     *邻接矩阵
     */
    private int[][] edges;

    public MatrixGraph(String[] vertex, LinkInfo[] linkInfos) {
        this.vertex = vertex;

        edges = new int[vertex.length][vertex.length];
        for (int i = 0; i < linkInfos.length; i++) {
            edges[linkInfos[i].getIvex()][linkInfos[i].getJvex()] = 1;
            edges[linkInfos[i].getJvex()][linkInfos[i].getIvex()] = 1;
        }
    }

    /**
     * 深度优先搜索
     * @param vertexIndex 开始顶点下标
     */
    public void DFS(int vertexIndex) {
        boolean[] record = new boolean[vertex.length];

        doDFS(vertexIndex, record);
    }

    private void doDFS(int currentVexIndex, boolean[] record) {
        if (record[currentVexIndex]) {
            return;
        }

        System.out.print(vertex[currentVexIndex] + " ");

        for (int i = currentVexIndex; i < edges[currentVexIndex].length; i++) {
            if (edges[currentVexIndex][i] == 1) {
                record[currentVexIndex] = true;
                doDFS(i, record);
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
 */
class LinkInfo {
    int ivex;
    int jvex;

    public LinkInfo(int ivex, int jvex) {
        this.ivex = ivex;
        this.jvex = jvex;
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