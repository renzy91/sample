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

        //初始化顶点数组
        for (int i = 0; i < vertex.length; i++) {
            vertexArray[i] = new VertexNode(vertex[i]);
        }

        //建立弧链表
        int head, tail, weight;
        EdgeNode node;
        for (int i = 0; i < linkInfos.length; i++) {
            tail = linkInfos[i].getEdgeTail();
            head = linkInfos[i].getEdgeHead();
            weight = linkInfos[i].getWeight();

            //头插发,同弧尾
            node = new EdgeNode(head, tail, weight);
            node.setTailLink(vertexArray[tail].getFirstOut());
            vertexArray[tail].setFirstOut(node);

            //头插发，同弧头
            node.setHeadLink(vertexArray[head].getFirstIn());
            vertexArray[head].setFirstIn(node);
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
        private int weight;
        private EdgeNode headLink;
        private EdgeNode tailLink;

        public EdgeNode(int headVertex, int tailVertex, int weight) {
            this.headVertex = headVertex;
            this.tailVertex = tailVertex;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

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
        int edgeTail;
        int edgeHead;
        int weight;

        public LinkInfo(int edgeTail, int edgeHead, int weight) {
            this.edgeTail = edgeTail;
            this.edgeHead = edgeHead;
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
                new LinkInfo(2, 1, 50),
        };

        OrthWeightGraph graph = new OrthWeightGraph(vertex, linkInfo);

        System.out.println();
    }
}
