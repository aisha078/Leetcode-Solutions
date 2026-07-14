import java.util.*;

class Solution {
    List<String> ans = new ArrayList<>();
    String[] map = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;
        backtrack(digits, 0, new StringBuilder());
        return ans;
    }

    private void backtrack(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}