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
    List<TreeNode> ans;
    HashSet<String> hs;
    public List<TreeNode> generateTrees(int n) {
        List<List<Integer>> A=new ArrayList<>();
        ans=new ArrayList<>();
        hs=new HashSet<>();
        int a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=i+1;
        permute(0,a,A);
        for(List<Integer> tmp:A)
        {
            bst(tmp);
        }
        return ans;
    }
    public void bst(List<Integer> A)
    {
        StringBuilder sb=new StringBuilder();
        TreeNode root=new TreeNode(A.get(0));
        for(int i=1;i<A.size();i++){
            TreeNode tmp=root;
            while(true){
                if(tmp.val>A.get(i)){
                    if(tmp.left==null){
                        tmp.left=new TreeNode(A.get(i));
                        break;
                    }else{
                        tmp=tmp.left;
                    }
                }else{
                    if(tmp.right==null){
                        tmp.right=new TreeNode(A.get(i));
                        break;
                    }else{
                        tmp=tmp.right;
                    }
                }
            }
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        sb.append(root.val+"#");
        while(!q.isEmpty()){
            TreeNode tmp=q.poll();
            if(tmp.left!=null){
                q.add(tmp.left);
                sb.append(tmp.left.val+"#");
            }else{
                sb.append("null#");
            }
            if(tmp.right!=null){
                q.add(tmp.right);
                sb.append(tmp.right.val+"#");
            }else{
                sb.append("null#");
            }
        }
        String st=sb.toString();
        if(!hs.contains(st)){
            ans.add(root);
            hs.add(st);
        }
    }
    public void permute(int i,int a[],List<List<Integer>> A)
    {
        if(i==a.length){
            List<Integer> temp=new ArrayList<>();
            for(int ii:a)temp.add(ii);
            A.add(temp);
            return;
        }
        for(int j=i;j<a.length;j++){
            int temp=a[j];
            a[j]=a[i];
            a[i]=temp;
            permute(i+1,a,A);
            temp=a[j];
            a[j]=a[i];
            a[i]=temp;
        }
    }
}