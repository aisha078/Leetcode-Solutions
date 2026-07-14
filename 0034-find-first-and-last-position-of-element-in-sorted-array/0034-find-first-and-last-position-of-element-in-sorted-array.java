class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            find(nums, target, true),
            find(nums, target, false)
        };
    }

    private int find(int[] nums, int target, boolean first) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;
                if (first)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}