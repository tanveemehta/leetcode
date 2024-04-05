class Solution {
    public String makeGood(String s) {
      char[] stack = new char[s.length()];
      int top = -1;
        for(int i=0; i<s.length(); i++){
            if(top>=0 && Math.abs(s.charAt(i)-stack[top])==32){
                top--;
            }
            else{
                stack[++top] = s.charAt(i);
            }
        }
        char[] ans = new char[top+1];
        while(top!=-1){
            ans[top] = stack[top];
            top--;
        }
        return new String(ans);
    }
}