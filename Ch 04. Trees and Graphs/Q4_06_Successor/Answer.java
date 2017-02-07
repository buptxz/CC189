/**
 * Created by xiong on 10/28/2016.
 */

package Q4_06_Successor;

import CtCILibrary.TreeNode;

public class Answer {
    public static TreeNode successor(TreeNode node) {
        if (node == null) return null;
        if (node.right != null) {
            return findMin(node.right);
        } else {
            int temp = node.data;
            while (node.parent != null) {
                node = node.parent;
                if (node.data >= temp) return node;
            }
            return null;
        }
    }

    public static TreeNode findMin(TreeNode node) {
        if (node.left == null) return node;
        return findMin(node.left);
    }
}
