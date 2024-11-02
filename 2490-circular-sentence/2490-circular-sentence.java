class Solution {
    public boolean isCircularSentence(String sentence) {
        if (sentence.charAt(sentence.length() - 1) != sentence.charAt(0)) {
            return false;
        }

        int n = sentence.length();
        int i = 0;
        while (i < n) {
            while (i < n && sentence.charAt(i) != ' ') {
                i++;
            }
            if (i < n && sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
