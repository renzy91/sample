package structure;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-26 0:20
 */
public class StaticLinkList {
    private static final int MAX_SIZE = 10;


    public static class Node<E> {
        public E element;
        public int cur;
    }

    //初始化
    public <E> void init(Node<E>[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = new Node();
        }
        int i ;
        for (i = 0; i < list.length - 1; i++) {
            list[i].cur = i + 1;
        }
        list[i].cur=0;
    }

    //元素e 插入pos位置后
    public <E> boolean insert(Node<E>[] list, E e, int pos) {
        int i = malloc(list);
        int k = MAX_SIZE - 1;
        if (i != 0) {
            list[i].element = e;
            for (int j = 1; j < pos; j++) {
                k = list[k].cur;
            }
            list[i].cur = list[k].cur;
            list[k].cur = i;
            return true;
        }
        return false;
    }

    //分配空间
    public <E> int malloc(Node<E>[] list) {
        int i = list[0].cur;
        if (list[i].cur != 0) {
            list[0].cur = list[i].cur;
        }

        return i;
    }

    public static void main(String[] args) {
        StaticLinkList s = new StaticLinkList();

        Node<String>[] list = new Node[MAX_SIZE];

        s.init(list);
        boolean a = s.insert(list, "a", 1);

        System.out.println(a);


    }

}
