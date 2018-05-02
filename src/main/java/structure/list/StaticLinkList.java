package structure.list;

/**
 * @author renzhiyong
 * @description: 静态链表
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

    //删除list中di第i个元素
    public <E> boolean delete(Node<E>[] list, int i) {
        int k = MAX_SIZE - 1;

        for (int j = 0; j < i; j++) {
            k = list[k].cur;
        }

        list[k-1].cur = list[k].cur;
        list[k].element = null;

        freeEle(list, i);

        return true;
    }

    private <E> void freeEle(Node<E>[] list, int i) {
        list[i].cur = list[0].cur;
        list[0].cur = i;
    }

    //数据个数
    public <E> int eleSize(Node<E>[] list) {
        int k = list[MAX_SIZE - 1].cur;
        int size = 0;

        while (k != 0) {
            k = list[k].cur;
            size++;
        }

        return size;
    }


    public static void main(String[] args) {
        StaticLinkList s = new StaticLinkList();

        Node<String>[] list = new Node[MAX_SIZE];

        s.init(list);
        boolean a = s.insert(list, "a", 1);
        boolean b = s.insert(list, "b", 2);
        boolean c = s.insert(list, "c", 3);
        System.out.println(s.eleSize(list));

        boolean d = s.delete(list, 2);
        System.out.println(s.eleSize(list));

        System.out.println(a);


    }

}
