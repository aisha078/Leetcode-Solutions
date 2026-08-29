import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // Pair up values with their original indices
        int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }
        
        // Sort pairs primarily by value
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        int i = 0;
        
        while (i < n) {
            int j = i;
            // Find all contiguous elements where adjacent diff <= limit
            while (j + 1 < n && sorted[j + 1][0] - sorted[j][0] <= limit) {
                j++;
            }
            
            // Extract original indices for this connected group
            List<Integer> indices = new ArrayList<>();
            for (int k = i; k <= j; k++) {
                indices.add(sorted[k][1]);
            }
            
            // Sort indices to place values in leftmost available spots
            Collections.sort(indices);
            
            // Assign sorted values into sorted indices
            for (int k = 0; k < indices.size(); k++) {
                result[indices.get(k)] = sorted[i + k][0];
            }
            
            i = j + 1;
        }
        
        return result;
    }
}