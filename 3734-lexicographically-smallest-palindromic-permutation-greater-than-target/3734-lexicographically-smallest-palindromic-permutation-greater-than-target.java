import java.util.*;

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Validate palindrome condition
        int oddCount = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
        }
        if (oddCount > 1) {
            return "";
        }

        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        int halfLen = n / 2;

        // Try matching prefix of length L (from halfLen down to 0)
        for (int L = halfLen; L >= 0; L--) {
            int[] currentHalf = halfCount.clone();
            boolean validPrefix = true;
            char[] prefix = new char[halfLen];

            // Match prefix target[0...L-1]
            for (int i = 0; i < L; i++) {
                char tChar = target.charAt(i);
                if (currentHalf[tChar - 'a'] > 0) {
                    prefix[i] = tChar;
                    currentHalf[tChar - 'a']--;
                } else {
                    validPrefix = false;
                    break;
                }
            }

            if (!validPrefix) continue;

            if (L == halfLen) {
                // First half is identical to target's first half
                StringBuilder sb = new StringBuilder();
                sb.append(prefix);
                if (n % 2 != 0) {
                    sb.append(midChar);
                }
                for (int i = halfLen - 1; i >= 0; i--) {
                    sb.append(prefix[i]);
                }

                String res = sb.toString();
                if (res.compareTo(target) > 0) {
                    return res;
                }
            } else {
                // Must branch at index L with a strictly larger character
                int startChar = target.charAt(L) - 'a' + 1;
                for (int c = startChar; c < 26; c++) {
                    if (currentHalf[c] == 0) continue;

                    int[] tempCount = currentHalf.clone();
                    char[] p = prefix.clone();

                    p[L] = (char) ('a' + c);
                    tempCount[c]--;

                    // Fill remaining half greedily with smallest available characters
                    int idx = L + 1;
                    for (int ch = 0; ch < 26; ch++) {
                        while (tempCount[ch] > 0) {
                            p[idx++] = (char) ('a' + ch);
                            tempCount[ch]--;
                        }
                    }

                    // Construct full palindrome
                    StringBuilder sb = new StringBuilder();
                    sb.append(p);
                    if (n % 2 != 0) {
                        sb.append(midChar);
                    }
                    for (int i = halfLen - 1; i >= 0; i--) {
                        sb.append(p[i]);
                    }

                    String res = sb.toString();
                    if (res.compareTo(target) > 0) {
                        return res;
                    }
                }
            }
        }

        return "";
    }
}