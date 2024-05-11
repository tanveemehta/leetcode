class Worker{
    double baseWage;
    int quality;
    public Worker(double baseWage , int quality){
        this.baseWage = baseWage;
        this.quality = quality;
    }
}


class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        ArrayList<Worker> list = new ArrayList<>();
        int n = quality.length;
        for(int i=0;i<n;i++){
            double baseWage = 1.0*wage[i]/quality[i];
            list.add(new Worker(baseWage,quality[i]));
        }
        Collections.sort(list,new Comparator<Worker>(){
            public int compare(Worker w1, Worker w2){
                if(w1.baseWage<=w2.baseWage){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        PriorityQueue<Worker> pq = new PriorityQueue<>(new Comparator<Worker>(){
            public int compare(Worker w1, Worker w2){
                if(w1.quality<=w2.quality){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        double ans = Double.MAX_VALUE;
        int totalQuality = 0;
        for(int i=0;i<n;i++){
            pq.offer(list.get(i));
            totalQuality += list.get(i).quality;
            if(pq.size()==k){
                double cost = totalQuality*list.get(i).baseWage;
                ans = Math.min(ans,cost);
                totalQuality-=pq.poll().quality;
            }
        }
        return ans;
    }
}