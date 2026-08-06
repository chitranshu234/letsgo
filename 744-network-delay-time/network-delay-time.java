class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {

            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new int[] { v, w });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]);

        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        pq.offer(new int[] { 0, k });

        while (!pq.isEmpty()) {

            int[] p = pq.poll();

            int d = p[0];
            int node = p[1];

            if (d > dist[node]) {
                continue;
            }

            for (int j = 0; j < adj.get(node).size(); j++) {

                int neigh = adj.get(node).get(j)[0];
                int wt = adj.get(node).get(j)[1];

                if (d + wt < dist[neigh]) {

                    dist[neigh] = d + wt;

                    pq.offer(new int[] { d + wt, neigh });
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, dist[i]);
        }

        return max;
    }
}