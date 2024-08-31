class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int n=operations.length;
        int result=0;
        for(int i=0;i<n;i++){
            if(operations[i].charAt(1)== '+'){
                result=result+1;
            }else {
                result=result-1;
            }
        }
        return result;
            
    }
}