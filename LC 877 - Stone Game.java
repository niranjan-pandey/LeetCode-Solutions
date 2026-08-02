class Solution {
    int[][] dp = new int[501][501];
    public boolean stoneGame(int[] piles) {
        
        for(int[] row : dp)
            Arrays.fill(row, -1);

        int totalSum = Arrays.stream(piles).sum();

        int n = piles.length;
        int scoreA = solve(piles, 0, n-1);
        int scoreB = totalSum - scoreA;

        return scoreA > scoreB;
    }

    private int solve(int[] nums, int i, int j) {

        if(i >= j || j < 0 || i >= nums.length)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];    

        int takeF = nums[i] + solve(nums, i+2, j);
        int takeL = nums[j] + solve(nums, i, j-2);

        return dp[i][j] = Math.max(takeF, takeL);    
    }
}