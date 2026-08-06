class Solution {

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]);

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        dist[0][0] = 0;

        pq.offer(new int[] {0, 0, 0});

        while (!pq.isEmpty()) {

            int[] p = pq.poll();

            int effort = p[0];
            int row = p[1];
            int col = p[2];

            if (row == n - 1 && col == m - 1) {
                return effort;
            }

            if (effort > dist[row][col]) {
                continue;
            }

            for (int k = 0; k < 4; k++) {

                int nr = row + dr[k];
                int nc = col + dc[k];

                if (valid(nr, nc, n, m)) {

                    int diff = Math.abs(heights[row][col] - heights[nr][nc]);

                    int newEffort = Math.max(effort, diff);

                    if (newEffort < dist[nr][nc]) {

                        dist[nr][nc] = newEffort;

                        pq.offer(new int[] {newEffort, nr, nc});
                    }
                }
            }
        }

        return 0;
    }

    public boolean valid(int i, int j, int n, int m) {

        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }

        return true;
    }
}