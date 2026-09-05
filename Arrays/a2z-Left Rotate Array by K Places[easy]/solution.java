class Solution {
    public void rotateArray(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int newposition = ((i - k) + nums.length) % nums.length;   // <-- nums[...] hataya
            result[newposition] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
}

//question link - https://takeuforward.org/plus/dsa/problems/left-rotate-array?source=strivers-a2z-dsa-track
// solution link - https://www.youtube.com/watch?v=wvcQg43_V8U&t=485s
