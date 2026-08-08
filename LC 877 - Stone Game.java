class Solution {
    public boolean stoneGame(int[] piles) {

        /*
        Because there are an even number of piles and the total number of stones is odd, 
        the first player can always force themselves to take 
        either all odd-positioned or all even-positioned piles, 
        and one of those groups must contain more stones. [Because totalSum will always odd]
        Therefore Alice always wins.
        */

        //Solution 3
        //TC = O(1)
        //SC = O(1)

        return true;
    }
}

//RECURSION SOLUTION -----------------------------------------------

class Solution {
    public boolean stoneGame(int[] nums) {

        /*
        I'll take nums[i]. Then my opponent will make the best decision for themselves, 
        which means the worst decision for me. 
        So I take the minimum of my two possible future scores.

        When its your turn do your best [Choose Max]
        But when its your opponent turn expect the worst from result [Min] 
        Opponent is also playing optimally so after opponent turn [After Opponent number selection]
        you have minimum remaining number(Assume) to choose because maximum is already choose by the opponent
        */

        //Recursion Solution 1
        //TC = O(2^n)
        //SC = O(n)
        
        int totalSum = Arrays.stream(nums).sum();
        int scoreA = solve(nums, 0, nums.length-1); //Alice Score
        int scoreB = totalSum - scoreA; //Bob Score

        return scoreA >= scoreB;
    }

    private int solve(int[] nums, int i, int j) {

        if(i > j)
            return 0;

        //MIN CASE = Opponent have to two choices and he will always choose maximum path
        //           then after you have to choose the path where minimum number is remaining  

        //CASE1 => Taking from start nums[i]    
        //If my opponent takes i+1 then the remaining range for Me is (i+2, j)
        //If my opponent takes j then the remaining range for Me is (i+1, j-1);  
        int takeS = nums[i] + Math.min(solve(nums, i+2, j), solve(nums, i+1, j-1));

        //CASE2 => Taking from end nums[j]    
        //If my opponent takes j-1 then the remaining range for Me is (i, j-2)
        //If my opponent takes i then the remaining range for Me is (i+1, j-1);  
        int takeE = nums[j] + Math.min(solve(nums, i, j-2), solve(nums, i+1, j-1));

        return Math.max(takeS, takeE); //Choose maximum from both ways because its my turn
    }
}
