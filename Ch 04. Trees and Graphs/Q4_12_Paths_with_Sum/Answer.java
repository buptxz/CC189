package Q4_12_Paths_with_Sum;

import CtCILibrary.TreeNode;

/**
 * Created by xiong on 11/7/2016.
 */

public class Answer {
    public static int countPathsWithSum(TreeNode root, int sum) {
        return helper(root, sum, false);
    }

    public static int helper(TreeNode node, int sum, boolean ifIncluded) {
        if(node == null) return 0;
        if (node.left == null && node.right == null) {
            return node.data == sum ? 1 : 0;
        }
        int leftCount = helper(node.left, sum - node.data, true);
        int rightCount = helper(node.right, sum - node.data, true);
        if (ifIncluded == false) {
            leftCount += helper(node.left, sum, false);
        }
        if (ifIncluded == false) {
            rightCount += helper(node.right, sum, false);
        }
        return leftCount + rightCount + (node.data == sum ? 1 : 0);
    }
}
