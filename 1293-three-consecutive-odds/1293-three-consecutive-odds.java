class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3){
            return false;
        }
        int count = 0;
        for(int i=0;i<3;i++){
            if(arr[i]%2!=0){
                count++;
            }
            if(count==3){
                return true;
            }
        }
        
        for(int i=1;i<=arr.length-3;i++){
            if(arr[i-1]%2!=0){
                count--;
            }
            if(arr[i+2]%2!=0){
                count++;
            }
            if(count==3){
                return true;
            }
        }return false;
    }
}