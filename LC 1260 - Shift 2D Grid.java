class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int K) {

        List<List<Integer>> result = new ArrayList<>();
        
        int n = grid.length;
        int m = grid[0].length;

        int total = n*m;
        K %= total;

        for(int i = 0; i < n; ++i) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < m; ++j) 
                row.add(0);
            result.add(row);
        }

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {

                int oldIdx = i * m + j;
                int newIdx = (oldIdx + K) % total;

                int newRow = newIdx / m;
                int newCol = newIdx % m;

                result.get(newRow).set(newCol, grid[i][j]);
            }
        }
        return result;        
    }
}
