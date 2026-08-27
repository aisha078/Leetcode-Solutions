class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Try changing target from right to left
        for (int i = n - 1; i >= 0; i--) {

            // We need target[0 ... i-1] to be possible.
            int[] remaining = count.clone();

            boolean possible = true;

            for (int j = 0; j < i; j++) {

                int c = target.charAt(j) - 'a';

                if (remaining[c] == 0) {
                    possible = false;
                    break;
                }

                remaining[c]--;
            }

            if (!possible) {
                continue;
            }

            // At position i, we need a character
            // strictly greater than target[i].
            int current = target.charAt(i) - 'a';

            for (int c = current + 1; c < 26; c++) {

                if (remaining[c] > 0) {

                    remaining[c]--;

                    StringBuilder ans = new StringBuilder();

                    // Same prefix as target
                    for (int j = 0; j < i; j++) {
                        ans.append(target.charAt(j));
                    }

                    // Make this position greater
                    ans.append((char) ('a' + c));

                    // Fill remaining characters in sorted order
                    for (int j = 0; j < 26; j++) {
                        while (remaining[j] > 0) {
                            ans.append((char) ('a' + j));
                            remaining[j]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}