package structure.tree;

/**
 * @author renzhiyong
 * @description: 未完成，删除根节点错误
 * @date 2018-06-01 11:31
 */
public class BinarySearchTree {
    private Node root;

    public boolean delete(int i) {
        if (root == null) {
            return false;
        }

        //要删除的为根节点
        if (root.getE() == i) {
            //没有左右节点
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                return true;
            }
            //只有左孩子
            if (root.getRight() == null) {
                root = root.getLeft();
                return true;
            }
            //只有右孩子
            if (root.getLeft() == null) {
                root = root.getRight();
                return true;
            }
            //有左右孩子
            Node n = findAndDelPre(root);
            root.e = n.e;
            return true;
        }

        Node node = root;
        Node upper = null;
        while(node != null) {
            if (i == node.getE())
                break;

            upper = node;

            if (i < node.getE()) {
                node = node.getLeft();
                continue;
            }
            if (i > node.getE()) {
                node = node.getRight();
                continue;
            }
        }

        //未找到
        if (node == null)
            return false;

        //没有孩子节点
        if (node.getLeft() == null && node.getRight() == null) {
            if (node == upper.getLeft()) {
                upper.left  = null;
            } else {
                upper.right = null;
            }
            return true;
        }

        //只有左孩子
        if (node.getRight() == null) {
            if (node == upper.getLeft()) {
                upper.left  = node.getLeft();
            } else {
                upper.right = node.getLeft();
            }
            return true;
        }

        //只有右孩子
        if (node.getLeft() == null) {
            if (node == upper.getLeft()) {
                upper.left  = node.getRight();
            } else {
                upper.right = node.getRight();
            }
            return true;
        }

        //有两个孩子
        if (node.getLeft() != null && node.getRight() != null) {
            Node pre = findAndDelPre(node);
            node.e = pre.e;
            return true;
        }
        return false;

    }

    private Node findAndDelPre(Node node) {
        //查找删除node直接前驱
        Node n = node.left;
        Node f = node;
        while (n.right != null) {
            f = n;
            n = n.right;
        }

        if (n == f.right) {
            f.right = null;
        } else {
            f.left = null;
        }

        return n;
    }

    public boolean add (int i) {
        //没有root节点
        if (root == null) {
            root = new Node(i);
            return true;
        }

        Node node = root;
        while (true) {
            if (i < node.getE()) {
                if (node.getLeft() != null) {
                    node = node.getLeft();
                    continue;
                }
                node.left = new Node(i);
                return true;
            }

            if (i > node.getE()) {
                if (node.getRight() != null) {
                    node = node.getRight();
                    continue;
                }
                node.right = new Node(i);
                return true;
            }

            if (i == node.getE()) {
                return false;
            }
        }
    }

    public boolean exist(int i) {
        if (root == null)
            return false;

        Node node = root;
        while (node != null) {
            if (i == node.getE()) {
                return true;
            }

            if (i < node.getE()) {
                node = node.getLeft();
                continue;
            }

            if (i > node.getE()) {
                node = node.getRight();
                continue;
            }
        }

        return false;
    }

    private Node findEle(int i) {
        if (root == null)
            return null;

        Node node = root;
        while (node != null) {
            if (i == node.getE()) {
                return node;
            }

            if (i < node.getE()) {
                node = node.getLeft();
                continue;
            }

            if (i > node.getE()) {
                node = node.getRight();
                continue;
            }
        }

        return null;
    }

    public static class Node {
        private int e;
        private Node left;
        private Node right;

        public Node(int e) {
            this.e = e;
        }

        public int getE() {
            return e;
        }

        public void setE(int e) {
            this.e = e;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(5);
        tree.add(3);
        tree.add(6);
        tree.add(2);
        tree.add(4);

        System.out.println(tree.delete(3));

        System.out.println(tree.exist(3));
    }
}
