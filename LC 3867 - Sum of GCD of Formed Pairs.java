class Solution {
    public long gcdSum(int[] nums) {

        int maxNum = 0;
        int n = nums.length;
        int[] prefixGCD = new int[n];
        for(int i = 0; i < n; ++i) {
            maxNum = Math.max(maxNum, nums[i]);
            prefixGCD[i] = gcd(nums[i], maxNum);
        }

        Arrays.sort(prefixGCD);
        long result = 0;
        for(int i = 0; i < n/2; i++) 
            result = result + gcd(prefixGCD[i], prefixGCD[n-i-1]);

        return result;
    }

    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}