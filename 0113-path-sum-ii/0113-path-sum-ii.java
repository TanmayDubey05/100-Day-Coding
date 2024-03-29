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
     List<List<Integer>> al = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       
        helper( new ArrayList<>(), root, targetSum);
        return al;
    }
    void helper(List<Integer> li, TreeNode root, int targetSum)
    {
        if(root == null)
        return;
        li.add(root.val);
        if(root.left == null && root.right == null)
        {
            int sum = 0;
            for(int i: li)
            sum+= i;
            if(sum == targetSum)
            al.add(li);
        }
        helper(new ArrayList<>(li), root.left, targetSum);
        helper(new ArrayList<>(li), root.right, targetSum);
    }
}