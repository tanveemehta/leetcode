class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int m = searchWord.length();
        int n = sentence.length();
        int i=0;
        int j=0;
        int index=1;
        while(i<n){ //O(N)
            //remove any leading space / trailing space
            // while(i<n && sentence.charAt(i)==' ') i++;
            // compare the words
            while(i<n && j<m && sentence.charAt(i)==searchWord.charAt(j)) {
                i++;
                j++;
            }
            if(j==m){
                return index;
            }
            j=0;
            //search next space
            while(i<n && sentence.charAt(i)!=' ') i++;
            //move to the next word
            i+=1;
            index++;
        }
        return -1;
    }
}