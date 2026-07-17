class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length())
            return "";

        // Frequency of characters needed
        int[] need = new int[128];

        for (char c : t.toCharArray())
            need[c]++;

        int required = t.length();

        int left = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // If this character is still needed
            if (need[ch] > 0)
                required--;

            // Include character in window
            need[ch]--;

            // Window contains all characters
            while (required == 0) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                need[leftChar]++;

                // Window becomes invalid
                if (need[leftChar] > 0)
                    required++;

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? ""
                : s.substring(start, start + minLen);
    }
}