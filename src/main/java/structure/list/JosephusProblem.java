package structure.list;

/**
 * @author renzhiyong
 * @description: 约瑟夫问题
 * @date 2018-04-30 23:33
 */
public class JosephusProblem {
    public static void main(String[] args) {
        int total = 41;
        int k = 3;//第三个人自杀

        Node head = init(total);

        killSeq(head, k);

    }

    private static void killSeq(Node head, int k) {
        Node node = head;
        while (node.next != node) {
            for (int i = 1; i < k-1; i++) {
                node = node.next;
            }
            System.out.println(returnAndDeleteNext(node));
            node = node.next;
        }

        System.out.println(node.ele);
    }

    private static int returnAndDeleteNext(Node node) {
        Node delNode = node.next;
        node.next = node.next.next;
        return delNode.ele;
    }

    private static Node init(int total) {
        Node head = new Node();
        Node tail = head;
        for (int i = 1; i < total; i++) {
            tail.ele = i;
            tail = tail.next = new Node();
        }

        tail.ele = total;
        tail.next = head;

        return head;
    }


    public static class Node {
        int ele;
        Node next;
    }

}
