class Solution {
    public void rotateArrayByOne(int[] nums) {
        int temp = nums[0] ; //storing nums[0] in temp variable to rotate the other numbers.
        for(int i = 1;i<nums.length;i++){
            nums[i-1] = nums[i];
        }
        nums[nums.length-1] = temp; // to place the oth index element at last posiiton.
        
    }
}

//video link - https://youtu.be/wvcQg43_V8U?t=61
// question link - https://takeuforward.org/plus/dsa/problems/left-rotate-array-by-one
