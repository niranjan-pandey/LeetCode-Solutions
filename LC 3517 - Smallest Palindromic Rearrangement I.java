class Solution {
    public String smallestPalindrome(String s) {

        //TC = O(n)
        //SC = O(26)

        int[] freq = new int[26];
        for(char c : s.toCharArray())
            freq[c-'a']++;

        String middle = "";    
        StringBuilder left = new StringBuilder();

        for(int i = 0; i < 26; ++i) {

            for(int j = 0; j < freq[i] / 2; ++j) 
                left.append((char)('a' + i));

            if(freq[i] % 2 == 1)
                middle = String.valueOf((char)('a' + i));    
        }

        String right = new StringBuilder(left).reverse().toString();
        return left.toString() + middle + right;
    }
}