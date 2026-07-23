class Solution {
    public int uniqueXorTriplets(int[] nums) {

        /*
        This will work only if N > 2
        Numbers are from 1 to n so the maximum number we can make is 2^n
        nums = [1, 2, 3, 4]
        n = 4
        4 will be store in 3 bit places 
        [1 0 0] = 4
        max number we can get for n = 4 is 
        [1, 1, 1] = 7 
        We can't get more than 7 
        so ans is 8
        0 1 2 3 4 5 6 7
        We can get 0 by Triple XOR of same number
        */

        //TC = O(log(n)) base2
        //SC = O(1)

        int n = nums.length;
        if(n <= 2)
            return n;

        int result = 1;
        while(result <= n) 
            result *= 2; //2^0, 2^1, 2^2 ....

        return result;              
    }
}
