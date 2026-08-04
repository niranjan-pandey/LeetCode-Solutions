class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        //TC = O(n)
        //SC = O(1)

        int n = nums.length;
        int[] A = new int[101];

        int min = nums[0];
        int max = nums[0];        
        for(int i = 0; i < n; ++i) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            A[nums[i]]++;
        }

        List<Integer> result = new ArrayList<>();
        for(int i = min; i <= max; ++i)
            if(A[i] == 0) 
                result.add(i);

        return result;    
    }
}