class Solution {
    public int stoneGameVIII(int[] stones) {

        int n = stones.length;

        // Prefix sum
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }

        // Start with taking all stones
        int best = stones[n - 1];

        // Work backwards
        for (int i = n - 2; i > 0; i--) {
            best = Math.max(best, stones[i] - best);
        }

        return best;
    }
}