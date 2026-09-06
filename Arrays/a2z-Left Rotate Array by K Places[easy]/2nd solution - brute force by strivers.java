class Solution {
    public void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  //if k > n 

        int []temp = new int [k];
        for(int i = 0;i<k;i++){
            temp[i] = nums[i];
        }
        
        for(int i = k;i<n;i++){
            nums[i-k] = nums[i];
        }
        for(int i = n-k;i<n;i++){
            nums[i] = temp[i-(n-k)];
            
        }
    }
}

// question link - https://takeuforward.org/plus/dsa/problems/left-rotate-array?source=strivers-a2z-dsa-track&sort=upvoted&approach=optimal
// video link - https://www.youtube.com/watch?v=wvcQg43_V8U&t=485s

