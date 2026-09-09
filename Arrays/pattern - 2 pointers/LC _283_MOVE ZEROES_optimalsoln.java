class Solution {
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        int j = -1;
        for(int i = 0;i<n;i++){
            if(arr[i]==0){
                j =i;
                break;
            }
        }

        if( j == -1){
            return;
        }

        for(int i = j+1;i<n;i++){
            if(arr[i]!= 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        
    }
}

//question link - https://leetcode.com/problems/move-zeroes/
//video link - https://www.youtube.com/watch?v=wvcQg43_V8U&t=1633s

