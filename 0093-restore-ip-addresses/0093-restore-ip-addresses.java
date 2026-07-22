class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, 0, "", ans);
        return ans;
    }

    private void backtrack(String s, int idx, int parts, String curr, List<String> ans) {
        if (parts == 4 && idx == s.length()) {
            ans.add(curr.substring(0, curr.length() - 1));
            return;
        }

        if (parts == 4 || idx == s.length()) return;

        for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
            String part = s.substring(idx, idx + len);

            if ((part.startsWith("0") && part.length() > 1) ||
                    Integer.parseInt(part) > 255)
                continue;

            backtrack(s, idx + len, parts + 1, curr + part + ".", ans);
        }
    }
}