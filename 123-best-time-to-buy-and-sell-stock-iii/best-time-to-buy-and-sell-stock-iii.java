class Solution {

    int[][] dp;

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int k = 4;

        dp = new int[n][5];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(prices, n, 0, k);
    }

    int fun(int[] a, int n, int i, int k) {

        if (i == n || k == 0)
            return 0;

        if (dp[i][k] != -1)
            return dp[i][k];

        if (k % 2 == 0) {

            int c1 = fun(a, n, i + 1, k - 1) - a[i];
            int c2 = fun(a, n, i + 1, k);

            return dp[i][k] = Math.max(c1, c2);

        } else {

            int c1 = fun(a, n, i + 1, k - 1) + a[i];
            int c2 = fun(a, n, i + 1, k);

            return dp[i][k] = Math.max(c1, c2);
        }
    }
}