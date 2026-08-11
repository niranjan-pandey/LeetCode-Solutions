class Solution {
    public int missingInteger(int[] nums) {

        //TC = O(n)
        //SC = O(1)

        int prefixSum = nums[0];
        int i = 1, n = nums.length;
        while(i < n && nums[i-1] + 1 == nums[i])
            prefixSum += nums[i++];

        while(true) {
            boolean ok = false;
            for(int num : nums) 
                if(num == prefixSum) 
                    ok = true;
            if(!ok) return prefixSum;
            prefixSum++;
        }
    }
}