class Solution {
    public boolean checkValidString(String s) {
       int leftMin = 0;
        int leftMax = 0;
        for(int i = 0; i<s.length(); i++){
            char val = s.charAt(i);
            if (val == '('){
                leftMin++;
                leftMax++;
            }
            else if (val ==')'){
                leftMax=leftMax-1;
                leftMin=leftMin-1;
            }
            else{
                leftMin=leftMin-1;
                leftMax=leftMax+1;
            }
            if(leftMin<0){
                leftMin=0;
            }
            if(leftMax<0){
                return false;
            }
        }
        return leftMin == 0;
    }
}