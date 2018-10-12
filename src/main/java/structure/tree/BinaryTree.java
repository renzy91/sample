package structure.tree;

import java.util.*;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-10 23:37
 */
public class BinaryTree<E> {
    private Node<E> root;
    private List<Node<E>> nodeList;

    public BinaryTree() {
    }

    public BinaryTree(List<E> list) {
        nodeList = new ArrayList<>();
        for (E e : list) {
            Node<E> node = new Node<>();
            node.ele = e;
            nodeList.add(node);
        }

        root = nodeList.get(0);
        for (int i = 0; i < nodeList.size(); i++) {
            //左子树
            if ((2*i+1) >= nodeList.size()) {
                break;
            } else {
                nodeList.get(i).left = nodeList.get(2*i+1);
            }
            //右子树
            if ((2*i+2) >= nodeList.size()) {
                break;
            } else {
                nodeList.get(i).right = nodeList.get(2*i+2);
            }
        }
    }

    //后序遍历 左-根-右
    public void suf() {
        doSuf(root);
    }

    private void doSuf(Node<E> node) {
        if (node == null) {
            return;
        }
        doSuf(node.left);
        doSuf(node.right);
        System.out.print(node.ele);
    }

    //中序遍历 左-根-右
    public void inf() {
        doInf(root);
    }

    private void doInf(Node<E> node) {
        if (node == null) {
            return;
        }

        doInf(node.left);
        System.out.print(node.ele);
        doInf(node.right);
    }

    //先序遍历  根-左-右
    public void pre() {
        doPre(root);
        System.out.println();
    }

    private void doPre(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.ele + " ");
        doPre(node.left);
        doPre(node.right);
    }

    /**
     * 层序-递归
     */
    public void levelorderTraversal() {
        if (root==null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.println(node.ele);
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
    }

    class Node<E> {
        E ele;
        Node<E> left;
        Node<E> right;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binTree = new BinaryTree<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

        binTree.levelorderTraversal();

    }

}


