package structure.graph;

/**
 * @author renzhiyong
 * @description:十字链表网
 * @date 2018-05-15 18:29
 */
public class OrthWeightGraph {
    private VertexNode[] vertexArray;

    public OrthWeightGraph(String[] vertex, LinkInfo[] linkInfos) {
        this.vertexArray = new VertexNode[vertex.length];

        for (int i = 0; i < vertex.length; i++) {
            vertexArray[i] = new VertexNode(vertex[i]);
        }

        int head, tail, weight;
        for (int i = 0; i < linkInfos.length; i++) {
            head = linkInfos[i].getEdgeHead();
            tail = linkInfos[i].getEdgeTail();
            weight = linkInfos[i].getWeight();

//            vertexArray[head].
        }
    }

    class VertexNode {
        private Object data;
        private EdgeNode firstIn;
        private EdgeNode firstOut;

        public VertexNode(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public EdgeNode getFirstIn() {
            return firstIn;
        }

        public void setFirstIn(EdgeNode firstIn) {
            this.firstIn = firstIn;
        }

        public EdgeNode getFirstOut() {
            return firstOut;
        }

        public void setFirstOut(EdgeNode firstOut) {
            this.firstOut = firstOut;
        }
    }
    class EdgeNode {
        private int headVertex;
        private int tailVertex;
        private EdgeNode headLink;
        private EdgeNode tailLink;

        public int getHeadVertex() {
            return headVertex;
        }

        public void setHeadVertex(int headVertex) {
            this.headVertex = headVertex;
        }

        public int getTailVertex() {
            return tailVertex;
        }

        public void setTailVertex(int tailVertex) {
            this.tailVertex = tailVertex;
        }

        public EdgeNode getHeadLink() {
            return headLink;
        }

        public void setHeadLink(EdgeNode headLink) {
            this.headLink = headLink;
        }

        public EdgeNode getTailLink() {
            return tailLink;
        }

        public void setTailLink(EdgeNode tailLink) {
            this.tailLink = tailLink;
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

        LinkInfo[] linkInfo = {
                new LinkInfo(0, 1, 10),
                new LinkInfo(1, 2, 20),
                new LinkInfo(2, 0, 30),
                new LinkInfo(0, 2, 40),
        };

//        AdjWeightGraph graph = new AdjWeightGraph(vertex, linkInfo);

        System.out.println();
    }
}
