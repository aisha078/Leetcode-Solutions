class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backtrack(0, nums, new ArrayList<>());

        return ans;
    }

    private void backtrack(int start, int[] nums, List<Integer> curr) {

        // Every subset is valid
        ans.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {

            // Choose
            curr.add(nums[i]);

            // Explore
            backtrack(i + 1, nums, curr);

            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }
}