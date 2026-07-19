class Solution {
    public String smallestSubsequence(String s) {
        
        //TC = O(n)
        //SC = O(n)
        
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); ++i) 
            freq[s.charAt(i)-'a']++;

        boolean[] visited = new boolean[26];    
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            freq[c-'a']--;

            //If current character is present in stack then continue
            if(visited[c-'a'])
                continue;

            while(!stack.isEmpty() && c < stack.peek() && freq[stack.peek()-'a'] > 0)
                visited[stack.pop()-'a'] = false;
 
            stack.push(c);
            visited[c-'a'] = true;        
        }
        
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty())
            result.append(stack.pop());

        return result.reverse().toString();    
    }
}