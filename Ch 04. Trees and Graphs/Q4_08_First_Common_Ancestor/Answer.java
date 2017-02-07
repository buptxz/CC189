package Q4_08_First_Common_Ancestor;
import CtCILibrary.TreeNode;

/**
 * Created by xiong on 11/1/2016.
 */
public class Answer {
    public static TreeNode commonAncestor(TreeNode n1, TreeNode n2) {
        int d1 = depth(n1);
        int d2 = depth(n2);
        int depthDiff = Math.abs(d1 - d2);
        TreeNode first = d1 - d2 > 0 ? n1 : n2;
        TreeNode second = d1 - d2 > 0 ? n2 : n1;
        while (depthDiff > 0) {
            first = first.parent;
            depthDiff--;
        }
        do {
            if (first == second) return first;
            first = first.parent;
            second = second.parent;
        } while (first != null);
        return null;
    }

    public static int depth(TreeNode n) {
        int d = 0;
        while (n.parent != null) {
            n = n.parent;
            d++;
        }
        return d;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(1);
        TreeNode n7 = root.find(7);
        TreeNode ancestor = commonAncestor(n3, n7);
        System.out.println(ancestor.data);
    }
}
