import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long maxKelements(int[] nums, int k) {
        long sum = 0;
        
        // Use a max-heap (priority queue with reverse order)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //Java DOESN't provide heapify in O(n)
        for (int num : nums) {
            pq.add(num);
        }

        while (k-- > 0) {
            int maxEl = pq.poll();
            sum += maxEl;

            // Add back the updated element
            maxEl = (int) Math.ceil(maxEl / 3.0);
            pq.add(maxEl);
        }

        return sum;
    }
}