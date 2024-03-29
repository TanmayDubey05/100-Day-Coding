/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, 0, targetSum);
    }

    private boolean helper(TreeNode root, int currSum, int targetSum){
        if(root == null) return false;

        if(root.left == null && root.right == null) return currSum + root.val == targetSum;

        return helper(root.left, currSum + root.val, targetSum) ||
                    helper(root.right, currSum + root.val, targetSum);
    }
}