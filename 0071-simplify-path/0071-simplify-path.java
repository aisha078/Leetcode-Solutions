import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        for (String part : path.split("/")) {
            if (part.equals("") || part.equals("."))
                continue;

            if (part.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(part);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (String dir : stack) {
            ans.append("/").append(dir);
        }

        return ans.length() == 0 ? "/" : ans.toString();
    }
}