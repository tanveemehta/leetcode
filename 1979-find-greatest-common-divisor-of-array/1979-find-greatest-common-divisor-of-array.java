class Solution {
    public int gcd(int s,int l){
        if(s==0){
            return l;
        }else{
            return gcd(l%s,s);
         }
    } 
    public int findGCD(int[] nums) {
       int gcd=0;
       int s= Integer.MAX_VALUE;
       int l= Integer.MIN_VALUE;
        for(int num :nums){
             s= Math.min(s,num);
             l= Math.max(l,num);
        }
        int res = gcd(s,l);
        return res;
    }
    
       /* int s=nums[0];
       for(int i=1;i<nums.length;i++){
           if(nums[0]>nums[i]){
               s=nums[i];
           }
       }
        int l=nums[0];
        for(int i=1;i<nums.length;i++){
           if(nums[0]<nums[i]){
               l=nums[i];
           }
       }
        
        for(int i=1;i<=s;i++){
            if(s%i==0 && l%i==0){
                i=gcd;
            }
        }return gcd;*/
        
    
}