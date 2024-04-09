class Solution {
    public int findMaxLength(int[] nums) {
       Map<Integer,Integer> map= new HashMap<>();
       map.put(0,-1);
       int sum = 0, maxLength = 0;
       for(int i = 0 ;i<nums.length;i++){
         if(nums[i]==0){
            nums[i] = -1;
          }
        }
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                maxLength = Math.max(maxLength, i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return maxLength;
    
       
    }
}