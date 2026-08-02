class Solution {
    public int minimumPushes(String word) {

        //TC = O(n)
        //SC = O(26)

        int[] freq = new int[26];
        for(char c : word.toCharArray())
            freq[c-'a']++;    

        Arrays.sort(freq);
        int result = 0;
        for(int i = 25, curPos = 0; i >= 0 && freq[i] > 0; --i, ++curPos) 
            result += (freq[i] * (curPos / 8 + 1));

        return result;
    }
}

//2nd Solutuion
class Solution {
    public int minimumPushes(String word) {

        //TC = O(n)
        //SC = O(26)
        
        int[] freq = new int[26];
        for(char c : word.toCharArray())
            freq[c-'a']++;

        Arrays.sort(freq);
        reverse(freq);

        int result = 0;
        for(int i = 0; i < 26; ++i) {
            if(freq[i] == 0) 
                break;

            result += freq[i] * (i / 8 + 1);  
        }
        return result;
    }

    private void reverse(int[] freq) {
        int i = 0;
        int j = 25;

        while(i < j) {
            int temp = freq[i];
            freq[i] = freq[j];
            freq[j] = temp;
            ++i;
            --j;
        }
    }
}
