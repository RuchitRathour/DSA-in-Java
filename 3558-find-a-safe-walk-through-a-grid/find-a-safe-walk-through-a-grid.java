class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        // best[i][j] = maximum remaining health at this cell
        int[][] best = new int[m][n];

        for (int[] row : best) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        // Initial health after entering start cell
        int startHealth = health - grid.get(0).get(0);

        if (startHealth <= 0) {
            return false;
        }

        queue.offer(new int[]{0, 0, startHealth});
        best[0][0] = startHealth;

        int[][] dir = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];
            int currHealth = curr[2];

            // Destination reached
            if (row == m - 1 && col == n - 1) {
                return true;
            }

            for (int[] d : dir) {

                int newRow = row + d[0];
                int newCol = col + d[1];

                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                    continue;
                }

                int newHealth = currHealth - grid.get(newRow).get(newCol);

                if (newHealth <= 0) {
                    continue;
                }

                // Visit only if we reach with more health
                if (newHealth > best[newRow][newCol]) {

                    best[newRow][newCol] = newHealth;
                    queue.offer(new int[]{newRow, newCol, newHealth});
                }
            }
        }

        return false;
    }
}
    