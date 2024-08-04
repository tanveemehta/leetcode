class Solution {
    private static final int M = (int)1e9 + 7;

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> temp = new ArrayList<>();
        
        // Generate all subarray sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                temp.add(sum);
            }
        }

        // Sort the list of subarray sums
        Collections.sort(temp);

        // Calculate the sum of values from 'left' to 'right'
        int result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + temp.get(i)) % M;
        }

        return result;
    }
}

