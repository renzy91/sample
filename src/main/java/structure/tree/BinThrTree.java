package structure.tree;

        import org.springframework.util.CollectionUtils;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

/**
 * @author renzhiyong
 * @description:线索二叉树,中序遍历左孩子节点为空 设置指向前驱， 右孩子为空 设置指向后继
 * @date 2018-05-12 12:48
 */
public class BinThrTree<E> {
    private Node<E> root;
    private List<Node<E>> nodeList;
    private Node<E> pre;

    public BinThrTree(List<E> list) {
        nodeList = new ArrayList<>();
        for (E e : list) {
            nodeList.add(new Node<>(e));
        }

        for (int i = 0; i < nodeList.size(); i++) {
            if (2*i+1 >= nodeList.size()) {
                break;
            }
            nodeList.get(i).left = nodeList.get(2*i+1);
            if (2*i+2 >= nodeList.size()) {
                break;
            }
            nodeList.get(i).right = nodeList.get(2*i+2);
        }

        root = nodeList.get(0);
    }

    /**
     * lTag,rTag用于表示左右指向孩子节点还是线索节点
     * @param <E>
     */
    class Node<E> {
        E ele;
        Node<E> left;
        Node<E> right;
        TagEnum lTag = TagEnum.CHILD;
        TagEnum rTag = TagEnum.CHILD;

        public Node(E ele) {
            this.ele = ele;
        }
    }

    //中序遍历 线索化
    public void infThr() {
        pre = root;
        doInfThr(root);
    }

    private void doInfThr(Node<E> node) {
        if (node == null) {
            return;
        }

        doInfThr(node.left);
        if (node.left == null) {
            node.left = pre;
            node.lTag = TagEnum.THREAD;
        }

        if (pre.right == null) {
            pre.right = node;
            pre.rTag = TagEnum.THREAD;
        }
        pre = node;
        doInfThr(node.right);


    }

    enum TagEnum {
        THREAD,
        CHILD
    }

    public static void main(String[] args) {
        BinThrTree<Integer> tree = new BinThrTree<>(Arrays.asList(0, 1, 2, 3));
        tree.infThr();
        System.out.println();
    }
}
