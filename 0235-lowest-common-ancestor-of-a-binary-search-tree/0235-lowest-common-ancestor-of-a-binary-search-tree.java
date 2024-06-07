/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      // If both p and q are smaller than the current node, search in the left subtree
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        // If both p and q are greater than the current node, search in the right subtree
        else if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        // If one node is smaller and the other is greater, or if one of them matches the current node,
        // then the current node is the lowest common ancestor
        else{
            return root;
        }
    }
}