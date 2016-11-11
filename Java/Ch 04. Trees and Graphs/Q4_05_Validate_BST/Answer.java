/**
 * Created by xiong on 10/28/2016.
 */

package Q4_05_Validate_BST;

import CtCILibrary.TreeNode;

public class Answer {
    // First method
//    public static boolean isBST(TreeNode root) {
//        // maxValue and minValue cannot be set as Integer.MAXVALUE as it may be the node of the tree
//        return isBST(root, null, null);
//    }
//
//    public static boolean isBST(TreeNode node, Integer minValue, Integer maxValue) {
//        if (node == null) return true;
//        if ((maxValue != null && node.data > maxValue) ||
//                (minValue != null && node.data <= minValue)) return false;
//        // minValue or maxValue must be updated. We don't have to compare the current min/max with node.data
//        return isBST(node.left, minValue, node.data) && isBST(node.right, node.data, maxValue);
//    }

    // Second method
    public static Integer lastPrinted = null;

    public static boolean isBST(TreeNode root) {
        return isBST(root, true);
    }
    public static boolean isBST(TreeNode node, boolean isLeft) {
        if (node == null) return true;
        if (!isBST(node.left, true)) return false;
        if (lastPrinted != null) {
            if (isLeft) {
                if (node.data < lastPrinted) {
                    return false;
                }
            } else {
                if (node.data <= lastPrinted) {
                    return false;
                }
            }
        }
        lastPrinted = node.data;
        if (!isBST(node.right, false)) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        TreeNode node = TreeNode.createMinimalBST(array);
        //node.left.data = 5;
        //node.left.right.data = 3;
        System.out.println(isBST(node));

        test();
    }

    public static void test() {
        TreeNode node;
        boolean condition;
        System.out.println("test cases for equals condition.");

		/* Expect true: for left child: node.data <= last_printed.
   2
  / \
 /   \
 2   3
      \
      4
		*/
        int[] array2 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array2);
        node.left.data = 2;
        node.print();
        lastPrinted = null;
        condition = isBST(node);
        System.out.println("should be true: " + condition);

		/* Expect false: for right child: node.data <= last_printed.
   2
  / \
 /   \
 1   2
      \
      4
		 */
        int[] array3 = {1, 2, 3, 4};
        node = TreeNode.createMinimalBST(array3);
        node.right.data = 2;
        node.print();
        lastPrinted = null;
        condition = isBST(node);
        System.out.println("should be false: " + condition);
    }
}
