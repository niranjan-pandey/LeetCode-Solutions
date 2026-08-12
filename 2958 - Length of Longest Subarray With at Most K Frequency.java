class Solution {
    public int maxSubarrayLength(int[] nums, int K) {

        //TC = O(n)
        //SC = O(n)
        
        int result = 0;
        Map<Integer,Integer> freq = new HashMap<>();

        int n = nums.length;
        for(int start = 0, end = 0; end < n; ++end) {
            freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);
            while(start < end && freq.getOrDefault(nums[end], 0) > K) {
                freq.put(nums[start], freq.get(nums[start]) - 1);
                if(freq.get(nums[start]) == 0)
                    freq.remove(nums[start]);
                start++;        
            }
            result = Math.max(result, end-start+1);
        }
        return result;
    }
}
