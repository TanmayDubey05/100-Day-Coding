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
  List<String>lis=new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        helper(root,"");
        int sum=0;
        for(String s:lis){
          sum+=Integer.parseInt(s);
        }
        return sum;
    }
    void helper(TreeNode r,String s){
      if(r==null) return;
      s+=r.val;
      if(r.left==null && r.right==null){
        lis.add(s);
        s=s.replace(s.charAt(s.length()-1)+"","");
      }
      helper(r.left,s);
      helper(r.right,s);
      return;

    }
}