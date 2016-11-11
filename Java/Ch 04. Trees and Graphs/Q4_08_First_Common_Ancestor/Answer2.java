package Q4_08_First_Common_Ancestor;
import CtCILibrary.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * Created by xiong on 11/1/2016.
 */
public class Answer2 {
    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!cover(root, p) || !cover(root, q)) {
            return null;
        }
        return ancestorHelper(root, p, q);
    }

    public static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        boolean pIsOnLeft = cover(root.left, p);
        boolean qIsOnLeft = cover(root.left, q);
        if (pIsOnLeft != qIsOnLeft) { // Nodes are on different side
            return root;
        }
        TreeNode childSide = pIsOnLeft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }

    public static boolean cover(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) return false;
        if (n1 == n2) return true;
        return cover(n1.left, n2) || cover(n1.right, n2);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(1);
        TreeNode n7 = root.find(7);
        TreeNode ancestor = commonAncestor(root, n3, n7);
        System.out.println(ancestor.data);
    }
}
