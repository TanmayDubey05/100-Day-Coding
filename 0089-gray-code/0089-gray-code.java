class Solution {
    public List<Integer> grayCode(int n) {
       List< String> greystr=solve(n);
        List<Integer> ans=new ArrayList();
        for(String s:greystr)
        {
            ans.add(Integer.parseInt(s,2));
        }
        return ans;
    }
    public List<String> solve (int n)
    {
        if(n==1)
        {
            List<String> base=new ArrayList();
            base.add("0");
            base.add("1");
            return base;
        }   
        List<String> ans=new ArrayList();
        List<String> temp=solve(n-1);
        for(int i=0;i<temp.size();i++)
            ans.add("0"+temp.get(i));
        for(int i=temp.size()-1;i>=0;i--)
            ans.add("1"+temp.get(i));
        return ans;
    }
}