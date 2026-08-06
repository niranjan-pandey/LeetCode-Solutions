class Solution {
    public int smallestNumber(int n, int t) {

        //TC = O(K * log(n))
        //SC = O(1)

        while(true) {
            if(isPossible(n, t))
                return n;
            else
                n++;
        }
    }
    
    private boolean isPossible(int n, int t) {
        int product = 1;
        while(n > 0) {
            int digit = n % 10;
            product *= digit;
            n /= 10;
        }
        return product % t == 0;
    }
}