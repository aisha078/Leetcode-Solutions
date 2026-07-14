import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        if (words.length == 0) return ans;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset;
            int count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (freq.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    while (window.get(word) > freq.get(word)) {
                        String remove = s.substring(left, left + wordLen);
                        window.put(remove, window.get(remove) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == words.length) {
                        ans.add(left);
                        String remove = s.substring(left, left + wordLen);
                        window.put(remove, window.get(remove) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return ans;
    }
}