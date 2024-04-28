class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        if (k >= n / 2) {
            return maxProfitUnlimitedTransactions(prices);
        }

        int[][] profit = new int[k + 1][n];
        
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                profit[i][j] = Math.max(profit[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, profit[i - 1][j] - prices[j]);
            }
        }

        return profit[k][n - 1];
    }

    private int maxProfitUnlimitedTransactions(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}