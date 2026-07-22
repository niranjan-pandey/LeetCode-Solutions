class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        /*
        I am using List for storing all continous blocks of 0s
        I am skiping all one because I am storing all 1s in a variable
        So result is maxSum of two continous sequence of 0s

        Example - 00000 + 1111 + 00000
                   Seq1           Seq2

        One is alredy counted  
        */

        //TC = O(n)
        //SC = O(n)

        List<Integer> A = new ArrayList<>();

        int result = 0;
        int totalOnes = 0;
        int n = s.length();
        for(int i = 0; i < n; ++i) {

            if(s.charAt(i) == '1') {
                totalOnes++;
                continue;
            }

            int cnt = 1;
            while(i + 1 < n && s.charAt(i+1) == '0') {
                i++; cnt++;
            }

            A.add(cnt);        
        }

        for(int i = 1; i < A.size(); ++i)
            result = Math.max(result, A.get(i) + A.get(i-1));

        return result + totalOnes;    
    }
}
