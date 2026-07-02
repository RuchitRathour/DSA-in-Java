class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstfind(nums,target);
        int last = lastfind(nums,target);
        return new int[]{first , last};
    
    }

    // First Occurrence
    public int firstfind(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                ans = mid;
                high = mid-1; // left search
            }
            else if(target > nums[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }

    // Last Occurrence
    public int lastfind(int[] nums , int target){
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(target == nums[mid]){
                ans = mid;
                low = mid+1;
            }
            else if(target>nums[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}