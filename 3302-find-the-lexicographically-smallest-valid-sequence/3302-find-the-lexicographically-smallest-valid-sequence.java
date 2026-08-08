class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // dp[i] = number of characters of word2
        // that can be matched using word1[i...n-1]
        int[] dp = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            dp[i] = dp[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                dp[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        // First part: greedily choose the earliest indices.
        while (i < n && j < m) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;
            }

            // Use the one allowed mismatch
            else {

                int remaining = m - j - 1;

                if (dp[i + 1] >= remaining) {

                    ans[j] = i;
                    j++;

                    i++;

                    break;
                }
            }

            i++;
        }

        // Couldn't finish
        if (j < m && i == n) {
            return new int[0];
        }

        // Complete the remaining positions using exact matches
        while (j < m && i < n) {

            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            }

            i++;
        }

        if (j < m) {
            return new int[0];
        }

        return ans;
    }
}