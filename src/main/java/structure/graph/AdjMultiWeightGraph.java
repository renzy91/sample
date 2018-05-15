package structure.graph;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-15 22:50
 */
public class AdjMultiWeightGraph {
    /**
     * 顶点数组
     */
    private VertexNode[] vertexArray;

    public AdjMultiWeightGraph(String[] vertex, LinkInfo[] linkInfos) {
        //构建顶点数组
        vertexArray = new VertexNode[vertex.length];
        for (int i = 0; i < vertex.length; i++) {
            vertexArray[i] = new VertexNode(vertex[i]);
        }
        //构建边链表
        for (int i = 0; i < linkInfos.length; i++) {
            int ivex = linkInfos[i].getIvex();
            int jvex = linkInfos[i].getJvex();
            int weight = linkInfos[i].getWeight();

            EdgeNode node = new EdgeNode(ivex, jvex, weight);
            node.iLink = vertexArray[ivex].getFirst();
            vertexArray[ivex].setFirst(node);

            node.jLink = vertexArray[jvex].getFirst();
            vertexArray[jvex].setFirst(node);
        }
    }

    /**
     * 顶点节点
     */
    class VertexNode {
        private Object data;
        private EdgeNode first;

        public VertexNode(Object data) {
            this.data = data;
        }

        public Object getData() {

            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public EdgeNode getFirst() {
            return first;
        }

        public void setFirst(EdgeNode first) {
            this.first = first;
        }
    }

    /**
     * 边节点
     */
    class EdgeNode {
        private int ivex;
        private int jvex;
        private EdgeNode iLink;
        private EdgeNode jLink;
        private int weight;

        public EdgeNode(int ivex, int jvex, int weight) {
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

        public EdgeNode getiLink() {
            return iLink;
        }

        public void setiLink(EdgeNode iLink) {
            this.iLink = iLink;
        }

        public EdgeNode getjLink() {
            return jLink;
        }

        public void setjLink(EdgeNode jLink) {
            this.jLink = jLink;
        }
    }

    /**
     * 连接信息
     * edgeHead:弧头下标
     * edgeTail：弧尾下标
     * weight:权重
     */
    public static class LinkInfo {
        private int ivex;
        private int jvex;
        private int weight;

        public LinkInfo(int ivex, int jvex, int weight) {
            this.ivex = ivex;
            this.jvex = jvex;
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

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        String[] vertex = {"a", "b", "c"};

        LinkInfo[] linkInfo = {
                new LinkInfo(0, 1, 10),
                new LinkInfo(1, 2, 20),
                new LinkInfo(2, 0, 30),
        };

        AdjMultiWeightGraph graph = new AdjMultiWeightGraph(vertex, linkInfo);

        System.out.println();
    }
}
