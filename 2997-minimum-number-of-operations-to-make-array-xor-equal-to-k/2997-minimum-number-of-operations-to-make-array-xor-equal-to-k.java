class Solution {
    public int minOperations(int[] nums, int k) {
      int finalXor = 0;
        for(int i=0;i<nums.length;i++){
            finalXor = finalXor^nums[i];
        }
        int count=0;
        while(k>0 || finalXor>0){
            if(k%2 != finalXor%2){
                count++;
            }
            k=k/2;
            finalXor=finalXor/2;
        }
        return count;
    }
}