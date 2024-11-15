class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        // Skip from right
        while (r > 0 && arr[r] >= arr[r - 1]) {
            r--;
        }

        int shortest = r; // Case-1: Remove all elements to the left of r

        while (l < r) {
            while (r < n && arr[l] > arr[r]) {
                r++;
            }

            shortest = Math.min(shortest, r - l - 1); // r-l-1: means removing both r & l elements

            l++;
            if (arr[l] < arr[l - 1]) {
                break;
            }
        }
        return shortest;
    }
}