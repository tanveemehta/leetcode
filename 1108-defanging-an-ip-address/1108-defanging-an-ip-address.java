class Solution {
    public String defangIPaddr(String address) {
        String s="";
       for(int i=0;i<address.length();i++){
           char ch = address.charAt(i);
           if(ch!='.'){
               s=s+ch;
           }else{
               s=s+"[.]";
           }
       }
        return s;
            
    }
}