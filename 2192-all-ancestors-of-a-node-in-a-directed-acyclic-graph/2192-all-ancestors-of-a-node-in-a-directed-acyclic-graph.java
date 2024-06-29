class Solution {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>(n);
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            indegree[v]++;
        }

        // TOPOLOGICAL SORTING
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            topoOrder.add(curr);

            for (int v : adj.getOrDefault(curr, new ArrayList<>())) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        List<Set<Integer>> vec = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            vec.add(new HashSet<>());
        }

        for (int node : topoOrder) {
            for (int v : adj.getOrDefault(node, new ArrayList<>())) {
                vec.get(v).add(node); // adding node ancestor
                vec.get(v).addAll(vec.get(node)); // adding ancestors of node
            }
        }

        for (int i = 0; i < n; i++) {
            result.set(i, new ArrayList<>(vec.get(i)));
            Collections.sort(result.get(i));
        }

        return result;
    }
}