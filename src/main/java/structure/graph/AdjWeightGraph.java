package structure.graph;

/**
 * @author renzhiyong
 * @description:邻接表存储有向网
 * @date 2018-05-15 17:57
 */
public class AdjWeightGraph {
    private VertexNode[] vertexArray;

    public AdjWeightGraph(String[] vertex, LinkInfo[] linkInfos) {
        this.vertexArray = new VertexNode[vertex.length];

        //构建顶点数组
        for (int i = 0; i < vertex.length; i++) {
            vertexArray[i] = new VertexNode(vertex[i]);
        }

        //构建邻接链表
        ArcNode edgeNode;
        int tail, head, weight;
        for (int i = 0; i < linkInfos.length; i++) {
            tail = linkInfos[i].getArcTail();
            head = linkInfos[i].getArcHead();
            weight = linkInfos[i].getWeight();

            if (vertexArray[tail].getFirst() == null) {
                vertexArray[tail].setFirst(new ArcNode(head, weight));
                continue;
            }
            edgeNode = vertexArray[tail].getFirst();
            while (edgeNode.getNext() != null) {
                edgeNode = edgeNode.getNext();
            }
            edgeNode.setNext(new ArcNode(head, weight));
        }

    }

    /**
     * 顶点
     */
    class VertexNode {
        private Object data;
        private ArcNode first;

        public VertexNode(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public ArcNode getFirst() {
            return first;
        }

        public void setFirst(ArcNode first) {
            this.first = first;
        }
    }

    /**
     * 弧节点
     */
    class ArcNode {
        int vertexIndex;
        int weight;
        ArcNode next;

        public ArcNode(int vertexIndex, int weight) {
            this.vertexIndex = vertexIndex;
            this.weight = weight;
        }

        public int getVertexIndex() {
            return vertexIndex;
        }

        public void setVertexIndex(int vertexIndex) {
            this.vertexIndex = vertexIndex;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public ArcNode getNext() {
            return next;
        }

        public void setNext(ArcNode next) {
            this.next = next;
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
        };

        AdjWeightGraph graph = new AdjWeightGraph(vertex, linkInfo);

        System.out.println();
    }
}
