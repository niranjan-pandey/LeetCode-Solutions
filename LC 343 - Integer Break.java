class Solution {
    public int integerBreak(int n) {
        
        //TC = O(N)
        //SC = O(1)
        
        if(n == 2 || n == 3)
            return n - 1;
        
        int product = 1;
        while(n > 4) {
            product *= 3;
            n -= 3;
        }   
        return product * n;   
    }
}