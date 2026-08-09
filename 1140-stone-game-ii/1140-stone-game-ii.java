class Solution {

    int[][] memo;
    int[] suffix;

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        memo = new int[n][n];
        suffix = new int[n + 1];

        // suffix[i] = total stones from i to end
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return dfs(0, 1, piles);
    }

    private int dfs(int i, int M, int[] piles) {

        if (i >= piles.length)
            return 0;

        if (2 * M >= piles.length - i)
            return suffix[i];

        if (memo[i][M] != 0)
            return memo[i][M];

        int best = 0;

        for (int X = 1; X <= 2 * M; X++) {

            int opponent = dfs(i + X,
                               Math.max(M, X),
                               piles);

            int current = suffix[i] - opponent;

            best = Math.max(best, current);
        }

        memo[i][M] = best;

        return best;
    }
}