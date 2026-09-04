class Solution {
    public boolean check(int[] nums) {
        int breakcount = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>nums[(i+1) % nums.length]){
                breakcount++;
            }
        }
        
        return breakcount <= 1;
        
    }
}

//leetcode link - https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
