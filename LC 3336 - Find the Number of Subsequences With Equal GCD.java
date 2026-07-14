class Solution {
    private int[][][] dp;
    private static final int MOD = 1000000007;
    public int subsequencePairCount(int[] nums) {

        dp = new int[nums.length+1][201][201];
        for(int[][] M : dp)
            for(int[] row : M)
                Arrays.fill(row, -1);

        return solve(nums, 0, 0, 0);
    }

    private int solve(int[] nums, int Idx, int seq1, int seq2) {
        
        if(Idx == nums.length) 
            return (seq1 != 0 && seq2 != 0 && seq1 == seq2) ? 1 : 0;

        if(dp[Idx][seq1][seq2] != -1)
            return dp[Idx][seq1][seq2];

        long result = 0;    
        result += solve(nums, Idx+1, seq1, seq2);    
        result += solve(nums, Idx+1, gcd(seq1, nums[Idx]), seq2);
        result += solve(nums, Idx+1, seq1, gcd(seq2, nums[Idx]));
        return dp[Idx][seq1][seq2] = (int)(result % MOD);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}