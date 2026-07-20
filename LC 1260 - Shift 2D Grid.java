class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int K) {

        List<List<Integer>> result = new ArrayList<>();
        
        int n = grid.length;
        int m = grid[0].length;

        int[] A = new int[n*m];
        int[] B = new int[n*m];
        int Idx = 0;
        for(int i = 0; i < n; ++i) 
            for(int j = 0; j < m; ++j) 
                A[Idx++] = grid[i][j];

        int N = n*m;
        for(int i = 0; i < N; ++i)
            B[(i+K) % N] = A[i];

        Idx = 0;    
        for(int i = 0; i < n; ++i) {
            List<Integer> subList = new ArrayList<>();
            for(int j = 0; j < m; ++j) {
                subList.add(B[Idx++]); 
            }
            result.add(subList);
        }          
        return result;        
    }
}