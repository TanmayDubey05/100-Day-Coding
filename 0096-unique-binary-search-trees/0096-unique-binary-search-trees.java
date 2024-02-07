
class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int x=0;
            int y = i-1;
            int sum=0;
            while(x<i&&y>=0) {
                sum+=dp[x]*dp[y];
                x++;
                y--;
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}