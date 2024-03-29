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
     boolean same(TreeNode a1, TreeNode a2){
        if( a1==null && a2 ==null){
            return true;
        }
        if( a1==null || a2 ==null){
            return false;
        }
        if(a1.val!= a2.val){
            return false;
        } 
   return same(a1.left,a2.right) && same(a1.right,a2.left); }
    public boolean isSymmetric(TreeNode root) {
      TreeNode c1 = root.left;
      TreeNode c2 = root.right;
  
 return same(c1,c2) ;  }
}