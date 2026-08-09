class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for (int i = 0; i <= k; i++) {

            int[] temp = Arrays.copyOf(dist, n);

            for (int j = 0; j < flights.length; j++) {

                int s = flights[j][0];
                int d = flights[j][1];
                int wt = flights[j][2];

                if (dist[s] != Integer.MAX_VALUE &&
                        dist[s] + wt < temp[d]) {

                    temp[d] = dist[s] + wt;
                }
            }

            dist = temp;
        }

        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dst];
    }
}