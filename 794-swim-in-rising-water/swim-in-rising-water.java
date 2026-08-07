class Solution {

    public int swimInWater(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]);

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        dist[0][0] = grid[0][0];

        pq.offer(new int[] {grid[0][0], 0, 0});

        while (!pq.isEmpty()) {

            int[] p = pq.poll();

            int time = p[0];
            int row = p[1];
            int col = p[2];

            if (row == n - 1 && col == m - 1) {
                return time;
            }

            if (time > dist[row][col]) {
                continue;
            }

            for (int k = 0; k < 4; k++) {

                int nr = row + dr[k];
                int nc = col + dc[k];

                if (valid(nr, nc, n, m)) {

                    int newTime = Math.max(time, grid[nr][nc]);

                    if (newTime < dist[nr][nc]) {

                        dist[nr][nc] = newTime;

                        pq.offer(new int[] {newTime, nr, nc});
                    }
                }
            }
        }

        return -1;
    }

    public boolean valid(int i, int j, int n, int m) {

        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }

        return true;
    }
}