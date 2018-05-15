package structure.graph;

/**
 * @author renzhiyong
 * @description:十字链表有向网
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
        ArcNode node;
        for (int i = 0; i < linkInfos.length; i++) {
            tail = linkInfos[i].getArcTail();
            head = linkInfos[i].getArcHead();
            weight = linkInfos[i].getWeight();

            //头插发,同弧尾
            node = new ArcNode(head, tail, weight);
            node.setTailLink(vertexArray[tail].getFirstOut());
            vertexArray[tail].setFirstOut(node);

            //头插发，同弧头
            node.setHeadLink(vertexArray[head].getFirstIn());
            vertexArray[head].setFirstIn(node);
        }
    }

    class VertexNode {
        private Object data;
        private ArcNode firstIn;
        private ArcNode firstOut;

        public VertexNode(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public ArcNode getFirstIn() {
            return firstIn;
        }

        public void setFirstIn(ArcNode firstIn) {
            this.firstIn = firstIn;
        }

        public ArcNode getFirstOut() {
            return firstOut;
        }

        public void setFirstOut(ArcNode firstOut) {
            this.firstOut = firstOut;
        }
    }
    class ArcNode {
        private int headVertex;
        private int tailVertex;
        private int weight;
        private ArcNode headLink;
        private ArcNode tailLink;

        public ArcNode(int headVertex, int tailVertex, int weight) {
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

        public ArcNode getHeadLink() {
            return headLink;
        }

        public void setHeadLink(ArcNode headLink) {
            this.headLink = headLink;
        }

        public ArcNode getTailLink() {
            return tailLink;
        }

        public void setTailLink(ArcNode tailLink) {
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
