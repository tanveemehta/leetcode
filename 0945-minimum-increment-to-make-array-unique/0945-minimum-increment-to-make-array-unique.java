import java.util.*;

public class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int maxElement = 0;
        int moves = 0;

        for (int val : nums) {
            maxElement = Math.max(maxElement, val);
        }

        int[] count = new int[n + maxElement];

        for (int val : nums) {
            count[val]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] <= 1) continue;

            int extra = count[i] - 1;
            count[i + 1] += extra;
            count[i] = 1;
            moves += extra;
        }

        return moves;
    }
}