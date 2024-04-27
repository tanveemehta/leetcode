class Solution {
    HashMap<Character,Set<Integer>>map;
    int[][] dp;
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        dp = new int[n][m];
        map = new HashMap();
        for(int i = 0 ; i<n ; i++){
            char c = ring.charAt(i);
            map.putIfAbsent(c,new HashSet());
            map.get(c).add(i);    
        }
        for (int[] d : dp){
            Arrays.fill(d,-1);
        }
        return findRotateSteps(ring,0,key,0)+m;
    }
    public int findRotateSteps (String ring, int x, String key, int y){
            if(y == key.length()){
                return 0;
            }
            if(dp[x][y] != -1){
               return dp[x][y]; 
             }
            int min = Integer.MAX_VALUE;
            for(int next : map.get(key.charAt(y))){
                int oneWay = Math.abs(next - x);
                int steps = Math.min(oneWay,ring.length() - oneWay);
                min = Math.min(min,steps + findRotateSteps(ring,next,key,y+1));
            }
            dp[x][y] = min;
            return min;
        }
    }
//TC = O(NM)
//SC = O(NM)