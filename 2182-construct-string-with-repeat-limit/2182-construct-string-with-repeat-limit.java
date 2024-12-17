class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            char currChar = (char) ('a' + curr[0]);
            int count = Math.min(curr[1], repeatLimit);
            for (int i = 0; i < count; i++) {
                res.append(currChar);
            }
            curr[1] -= count;

            if (curr[1] > 0) {
                if (maxHeap.isEmpty()) break;

                int[] next = maxHeap.poll();
                char nextChar = (char) ('a' + next[0]);
                res.append(nextChar);
                next[1]--;

                if (next[1] > 0) {
                    maxHeap.offer(next);
                }
                maxHeap.offer(curr);
            }
        }
        return res.toString();
    }
}