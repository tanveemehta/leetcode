import java.util.*;

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int left = 0;
        int rangeMin = Integer.MAX_VALUE;
        int rangeMax = Integer.MIN_VALUE;

        long count = 0;
        long winSize;
        int right;

        for (right = 0; right < n; ++right) {
            rangeMin = Math.min(rangeMin, nums[right]);
            rangeMax = Math.max(rangeMax, nums[right]);

            if (rangeMax - rangeMin > 2) {
                winSize = right - left;
                count += (winSize * (winSize + 1)) / 2;

                left = right;
                // Expand current window to as left as possible
                rangeMin = nums[right];
                rangeMax = nums[right];
                while (left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2) {
                    left--;
                    rangeMin = Math.min(rangeMin, nums[left]);
                    rangeMax = Math.max(rangeMax, nums[left]);
                }
                // Subtract overcounted subarrays
                if (left < right) {
                    winSize = right - left;
                    count -= (winSize * (winSize + 1)) / 2;
                }
            }
        }
        // Add subarrays from the last window
        winSize = right - left;
        count += (winSize * (winSize + 1)) / 2;

        return count;
    }
}
