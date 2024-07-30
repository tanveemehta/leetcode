class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        
        int[] right_a = new int[n];

        int counta = 0;
        for (int i = n - 1; i >= 0; i--) {
            right_a[i] = counta;
            if (s.charAt(i) == 'a')
                counta++;
        }

        int count = Integer.MAX_VALUE;
        int countb = 0;

        for (int i = 0; i < n; i++) {
            count = Math.min(count, countb + right_a[i]);
            if (s.charAt(i) == 'b')
                countb++;
        }

        return count;
    }
}