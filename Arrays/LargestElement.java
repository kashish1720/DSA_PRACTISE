class Solution {
    public int largestElement(int[] nums) {
        int max = nums[0];
        for(int i =1;i<nums.length;i++){
            if(nums[i]>max){
                max =nums[i];
            }
        }
        return max;
    
    }
}


//////////////////////////////
QUESTION  - 
 Largest Element
Subscribe to TUF+
Given an array of integers nums, return the value of the largest element in the array

Example 1
Input: nums = [3, 3, 6, 1]
Output: 6
Explanation: The largest element in array is 6

Example 2
Input: nums = [3, 3, 0, 99, -40]
Output: 99
Explanation: The largest element in array is 99

Now your turn!
Input: nums = [-4, -3, 0, 1, -8]
Output:
Pick your answer
  
Constraints
1 <= nums.length <= 105
-104 <= nums[i] <= 104
nums may contain duplicate elements.
