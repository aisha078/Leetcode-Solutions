class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = 1000000;

        int[] dp = new int[n];
        java.util.Arrays.fill(dp, INF);

        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int ans = INF;
        int best = INF;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (map.containsKey(sum - target)) {
                int start = map.get(sum - target);
                int len = i - start;

                if (start >= 0 && dp[start] != INF) {
                    ans = Math.min(ans, len + dp[start]);
                }

                best = Math.min(best, len);
            }

            dp[i] = best;
            map.put(sum, i);
        }

        return ans == INF ? -1 : ans;
    }
}