class Solution {
    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        
        // Check if the lengths match and if goal is a substring of s + s
        if (m == n && (s + s).contains(goal)) {
            return true;
        }
        
        return false;
    }
}