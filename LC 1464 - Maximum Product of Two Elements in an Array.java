class Solution {
    public int maxProduct(int[] nums) {

        //TC = O(n)
        //SC = O(1)
        
        int maxA = 0;
        int maxB = 0;
        int n = nums.length;
        for(int i = 0; i < n; ++i) {
            if(nums[i] > maxA) {
                maxB = maxA;
                maxA = nums[i];
            } else if(nums[i] > maxB) {
                maxB = nums[i];
            }
        }
        return (maxA-1) * (maxB-1);
    }
}