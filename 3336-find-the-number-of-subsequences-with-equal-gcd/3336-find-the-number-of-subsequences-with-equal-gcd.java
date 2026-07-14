class Solution {

    int MOD = 1_000_000_007;
    int[] nums;
    int n;
    Integer[][][] dp;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        n = nums.length;
        dp = new Integer[n][201][201];
        return solve(0, 0, 0);
    }

    int solve(int i, int g1, int g2) {

        if (i == n)
            return (g1 == g2 && g1 != 0) ? 1 : 0;

        if (dp[i][g1][g2] != null)
            return dp[i][g1][g2];

        long ans = solve(i + 1, g1, g2);

        ans += solve(i + 1, gcd(g1, nums[i]), g2);

        ans += solve(i + 1, g1, gcd(g2, nums[i]));

        return dp[i][g1][g2] = (int)(ans % MOD);
    }

    int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}