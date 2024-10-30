import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private List<Integer> LIS(List<Integer> nums) {
        int n = nums.size();
        List<Integer> lis = new ArrayList<>();
        List<Integer> lisLen = new ArrayList<>(Collections.nCopies(n, 1));
        
        for (int i = 0; i < n; ++i) {
            int num = nums.get(i);
            int lb = Collections.binarySearch(lis, num);
            if (lb < 0) lb = -lb - 1;
            if (lb >= lis.size()) lis.add(num);
            else lis.set(lb, num);
            lisLen.set(i, lis.size());
        }
        return lisLen;
    }
    
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) numsList.add(num);

        List<Integer> lisLR = LIS(numsList);

        Collections.reverse(numsList);
        List<Integer> lisRL = LIS(numsList);
        Collections.reverse(lisRL);
        
        int maxMountainSize = 0;
        for (int i = 0; i < n; ++i) {
            if (lisLR.get(i) > 1 && lisRL.get(i) > 1) {
                maxMountainSize = Math.max(maxMountainSize, lisLR.get(i) + lisRL.get(i) - 1);
            }
        }
        
        return n - maxMountainSize;
    }
}