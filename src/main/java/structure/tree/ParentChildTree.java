package structure.tree;

/**
 * @author renzhiyong
 * @description:双亲孩子结构树
 * @date 2018-05-09 23:59
 */
public class ParentChildTree {
    private static final int MAX_SIZE = 10;

    public static void main(String[] args) {
        Box[] tree = new Box[MAX_SIZE];

        //添加genji根节点
        tree[0] = new ParentChildTree.Box("A", -1, null);
        //添加两个分支节点
        tree[1] = new Box("B", 0, null);
        tree[2] = new Box("C", 0, null);
        tree[0].child = new ParentChildTree.Child(1, new ParentChildTree.Child(2, null));

    }

    public static class Child {
        int index;
        Child child;

        public Child(int index, Child child) {
            this.index = index;
            this.child = child;
        }
    }

    public static class Box {
        String content;
        int parentIndex;
        Child child;

        public Box() {
        }

        public Box(String content, int parentIndex, Child child) {
            this.content = content;
            this.parentIndex = parentIndex;
            this.child = child;
        }
    }
}
