class Solution {
    public int findGCD(int[] nums) {

        //TC = O(n)
        //SC = O(1)

        int largest = nums[0];
        int smallest = nums[0];

        for(int num : nums) {
            largest = Math.max(largest, num);
            smallest = Math.min(smallest, num);
        }
        return gcd(smallest, largest);
    }

    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}