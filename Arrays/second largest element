class Solution {
    public int secondLargestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>max){
                secondmax = max;
                max = nums[i];
            }
            else if (nums[i]>secondmax && nums[i]!=max){
                secondmax = nums[i];
            }
        }
        if(secondmax==Integer.MIN_VALUE){
            secondmax = -1;
        }
        return secondmax;
    
    }
}


/////////////////////////////////////////
question - 
Second Largest Element
Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.

Example 1
Input: nums = [8, 8, 7, 6, 5]
Output: 7
Explanation:The largest value in nums is 8, the second largest is 7

Example 2
Input: nums = [10, 10, 10, 10, 10]
Output: -1
Explanation:The only value in nums is 10, so there is no second largest value, thus -1 is returned

Now your turn!
Input: nums = [7, 7, 2, 2, 10, 10, 10]
Output: Pick your answer

10
2
7
0

Constraints
1 <= nums.length <= 105
-104 <= nums[i] <= 104
nums may contain duplicate elements.
