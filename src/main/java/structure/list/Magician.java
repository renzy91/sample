package structure.list;

/**
 * @author renzhiyong
 * @description:魔术师发牌问题
 * @date 2018-05-01 16:24
 */
public class Magician {
    public static void main(String[] args) {
        Node head = init();

        int currentNum = 1;//当前点数
        int count = 0;//当前过牌数

        Node node = head;
        while(currentNum < 14) {

            int i = 0;
            while (i < count) {
                node = node.next;
                if (node.num == 0) {
                    i++;
                }
            }

            node.num = currentNum;
            node = node.next;
            currentNum++;
            count++;
        }

        printList(head);

    }

    private static void printList(Node head) {
        Node node = head;
        while (node.next != head) {
            System.out.print(node.num + " ");
            node = node.next;
        }

        System.out.println(node.num);
    }

    private static Node init() {
        Node head = new Node();
        Node tail = head;

        for (int i = 0; i < 13; i++) {
            tail = tail.next = new Node();
            tail.num = 0;
        }

        tail.next = head.next;

        return head.next;

    }


    public static class Node{
        int num;
        Node next;

    }
}
