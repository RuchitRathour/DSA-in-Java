class Solution {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Target mil gaya
            if (nums[mid] == target) {
                return mid;
            }

            // Left half sorted hai
            if (nums[low] <= nums[mid]) {

                // Target left half me hai
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }
            // Right half sorted hai
            else {

                // Target right half me hai
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}