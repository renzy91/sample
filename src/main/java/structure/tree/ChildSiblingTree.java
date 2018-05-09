package structure.tree;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-05-10 0:20
 */
public class ChildSiblingTree {
    public static void main(String[] args) {
        /**
             *      root
             *      /   \
             *   bNode  cNode
             *   /  \
         *   dNode  eNode
         */
        TreeNode root = new TreeNode();
        TreeNode bNode = new TreeNode();
        TreeNode cNode = new TreeNode();
        TreeNode dNode = new TreeNode();
        TreeNode eNode = new TreeNode();

        root.firstChild = bNode;
        bNode.firstChild = dNode;
        bNode.nextSibling = cNode;
        dNode.nextSibling = eNode;


    }

}
class TreeNode {
    Object ele;
    TreeNode firstChild;
    TreeNode nextSibling;
}
