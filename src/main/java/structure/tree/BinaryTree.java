package structure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    class Node<E> {
        E ele;
        Node<E> left;
        Node<E> right;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binTree = new BinaryTree<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

        System.out.println();

    }

}


