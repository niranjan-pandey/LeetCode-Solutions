class Solution {
    public int minimumPushes(String word) {

        //TC = O(n)
        //SC = O(1)
        
        int result = 0;
        int n = word.length();
        for(int i = 0; i < n; ++i) 
            result += (i/8+1);

        return result;    
    }
}