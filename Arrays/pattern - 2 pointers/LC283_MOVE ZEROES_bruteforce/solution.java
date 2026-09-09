class Solution {
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        ArrayList<Integer>temp = new ArrayList<>();
        
        for(int i =0;i<n;i++){
            if(arr[i]!= 0){
                temp.add(arr[i]);
            }
        }
        
        for(int i =0;i<temp.size();i++){
            arr[i] = temp.get(i);
        }

        for(int i =temp.size();i<n;i++){
            arr[i] = 0;
        }
            
    }
}

//question link - https://leetcode.com/problems/move-zeroes/
//video link - https://www.youtube.com/watch?v=wvcQg43_V8U&t=1633s
