class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
       LinkedList<Integer> queue = new LinkedList();
       Arrays.sort(deck);
        int n = deck.length;
        int[] res = new int[n];
        for(int i = 0;i<n;i++){
            queue.offer(i);
        }
        for(int i=0;i<n;i++){
            res[queue.poll()] = deck[i];
            queue.offer(queue.poll());
        }
        return res;
    }
}