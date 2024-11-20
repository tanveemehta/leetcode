class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] freq = new int[3]; // Frequency array for 'a', 'b', 'c'

        // Expand the left pointer until all characters meet the condition
        int left = 0;
        while (left < n && (freq[0] < k || freq[1] < k || freq[2] < k)) {
            freq[s.charAt(left) - 'a']++;
            left++;
        }

        // If it's impossible to satisfy the condition
        if (freq[0] < k || freq[1] < k || freq[2] < k) {
            return -1;
        }

        // Initialize shortest valid segment
        int shortest = left;
        left--; // Adjust left to last valid position
        int right = n - 1;

        // Shrink the left window and adjust the right pointer
        while (left >= 0) {
            freq[s.charAt(left) - 'a']--;
            left--;

            // Expand the right pointer if the condition is violated
            while (left <= right && (freq[0] < k || freq[1] < k || freq[2] < k)) {
                freq[s.charAt(right) - 'a']++;
                right--;
            }

            // Update shortest valid segment
            shortest = Math.min(shortest, n - (right - left));
        }

        return shortest;
    }
}