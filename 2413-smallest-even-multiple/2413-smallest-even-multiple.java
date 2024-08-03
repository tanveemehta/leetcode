class Solution {
    public int smallestEvenMultiple(int n) {
        if(n%n==0 && n%2==0){
            return n;
        }else{
            return n*2;
        }
    }
}