class Solution {
    public boolean winnerSquareGame(int n) {

        /*
        Try every square if I can make one move that puts 
        my opponent in a losing position, I win. Otherwise, I lose.
        */

        //Recursion + Memoization
        //TC = O(n*sqrt(n)) //n states and for every state ForLoop will run sqrt(n) time
        //SC = O(n)         //Recursion depth + dp Array

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solve(n, dp); //Alice will start the game so this one is Alice turn
    }

    private boolean solve(int n, int[] dp) {

        if(n == 0) //In this case current player (Alice and bob both) will loose the game
            return false;

        if(dp[n] != -1)
            return dp[n] == 1 ? true : false;    

        //Try taking every possible perfect square => 1, 4, 9, 16, ... <= n    
        for(int i = 1; i*i <= n; ++i) {      

            /*
            After taking 'square' stones,
            it becomes the opponent's turn with (n - square) stones.
            If the opponent LOSES from that state,
            then the current player can WIN by choosing this square.
            */

            int square = i * i;
            if(solve(n-square, dp) == false)  { //BOB Turn [If bob loses the game then Alice will win]
                dp[n] = 1; //that's why return true
                return true;
            }
        }

        //We tried every possible square.
        //If none of them can force the opponent into a losing state, then the current player loses.
        dp[n] = 0;
        return false;
    }
}