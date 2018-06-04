package structure.tree;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-06-04 11:41
 */
public class AVLTree extends BinarySearchTree{
    @Override
    public boolean add(int i) {
        if (exist(i)) {
            return false;
        }
        root = insert(root, i);
        return true;
    }

    private Node insert(Node node, int i) {
        if (node == null) {
            return new Node(i);
        }

        //左侧
        if (i < node.getE()) {
            node.setLeft(insert(node.getLeft(), i));
            //调整平衡
            if (height(node.getLeft()) - height(node.getRight()) == 2) {
                if (i < node.getLeft().getE()) {
                    node = rightRotate(node);
                } else {
                    node = leftRightRotate(node);
                }
            }

        } else {
            node.setRight(insert(node.getRight(), i));
            //调整平衡
            if (height(node.getRight()) - height(node.getLeft()) == 2) {
                if (i > node.getRight().getE()) {
                    node = leftRotate(node);
                } else {
                    node = rightLeftRotate(node);
                }
            }
        }

        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
        return node;
    }

    private Node leftRightRotate(Node node) {
        node.setLeft(leftRotate(node.getLeft()));
        return rightRotate(node);
    }

    private Node rightLeftRotate(Node node) {
        node.setRight(rightRotate(node.getRight()));
        return leftRotate(node);
    }

    public Node leftRotate(Node node) {
        Node right = node.getRight();

        node.setRight(right.getLeft());
        right.setLeft(node);

        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
        right.setHeight(Math.max(height(right.getLeft()), height(right.getRight())) + 1);

        return right;
    }

    public Node rightRotate(Node node) {
        Node left = node.getLeft();

        node.setLeft(left.getRight());
        left.setRight(node);

        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
        left.setHeight(Math.max(height(left.getLeft()), height(left.getRight())) + 1);

        return left;
    }

    private int height(Node node) {
        return node == null ? -1 : node.getHeight();
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.add(6);


        System.out.println();
    }
}
