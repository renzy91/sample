package structure.list;

import java.util.List;

/**
 * @author renzhiyong
 * @description: 循环链表
 * @date 2018-04-30 13:07
 */
public class CirList<E> {
    public Node<E> head;
    public int size;

    public CirList() {
        init();
    }

    //初始化
    public void init(){
        head = new Node<>();
        head.next = head;
        size = 0;
    }

    //插入元素
    public boolean add(E e, int pos) {
        if (pos > size+1) {
            return false;
        }
        Node<E> node = this.head;
        for (int i = 1; i < pos; i++) {
            node = node.next;
        }

        Node<E> nNode = new Node<>();
        nNode.e = e;
        nNode.next = node.next;
        node.next = nNode;

        size++;
        return true;
    }

    //删除元素
    public boolean delete(int pos) {
        if (pos > size) {
            return false;
        }

        Node<E> node = this.head;
        for (int i = 1; i < pos; i++) {
            node = node.next;
        }

        node.next.e = null;
        node.next = node.next.next;

        size--;

        return true;
    }

    //查找元素e位置
    public int find(E e) {
        Node<E> node = this.head.next;

        int pos = 1;
        while (node != head && !node.e.equals(e)) {
            node = node.next;
            pos++;
        }

        if (node == head) {
            return -1;
        }

        return pos;
    }

    public void print() {
        Node<E> node = head.next;
        while (node != head) {
            System.out.println(node.e);
            node = node.next;
        }
    }

    public static class Node<E>{
        public E e;
        public Node<E> next;
    }

    public static void main(String[] args) {
        CirList<Integer> list = new CirList<>();
        list.add(1,1);
        list.add(2,2);
        list.add(3,3);

        System.out.println(list.find(2));

        list.delete(2);
        System.out.println(list.find(2));

        list.print();
    }
}
