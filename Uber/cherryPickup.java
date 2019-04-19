/*
Approach #2: Dynamic Programming (Top Down) [Accepted]
Intuition
Instead of walking from end to beginning, let's reverse the second leg of the path, so we are only considering two paths from the beginning to the end.
Notice after t steps, each position (r, c) we could be, is on the line r + c = t. So if we have two people at positions (r1, c1) and (r2, c2), then r2 = r1 + c1 - c2. That means the variables r1, c1, c2 uniquely determine 2 people who have walked the same r1 + c1 number of steps. This sets us up for dynamic programming quite nicely.
Algorithm
Let dp[r1][c1][c2] be the most number of cherries obtained by two people starting at (r1, c1) and (r2, c2) and walking towards (N-1, N-1) picking up cherries, where r2 = r1+c1-c2.
If grid[r1][c1] and grid[r2][c2] are not thorns, then the value of dp[r1][c1][c2] is (grid[r1][c1] + grid[r2][c2]), plus the maximum of dp[r1+1][c1][c2], dp[r1][c1+1][c2], dp[r1+1][c1][c2+1], dp[r1][c1+1][c2+1] as appropriate. We should also be careful to not double count in case (r1, c1) == (r2, c2).
Why did we say it was the maximum of dp[r+1][c1][c2] etc.? It corresponds to the 4 possibilities for person 1 and 2 moving down and right:
Person 1 down and person 2 down: dp[r1+1][c1][c2];
Person 1 right and person 2 down: dp[r1][c1+1][c2];
Person 1 down and person 2 right: dp[r1+1][c1][c2+1];
Person 1 right and person 2 right: dp[r1][c1+1][c2+1];
*/
class Solution {
    
        int[][][] memo;
        int [][] grid;
        int N;
    
    public int cherryPickup(int[][] grid) {
           this.grid= grid;
           N = grid.length;
           memo = new int[N][N][N];
           for(int[][] layer: memo){
               for(int[] row: layer){
                   Arrays.fill(row,Integer.MIN_VALUE);
               }
           }
        return Math.max(0, dp(0,0,0));
    }
    
    public int dp(int r1, int c1, int c2) {
        int r2 = r1+ c1 -c2;
        if(N== r1 || N == r2 || N==c1 || N==c2 || grid[r1][c1] == -1 || 
          grid[r2][c2] == -1){
            return -9999999;
        }else if(r1 == N-1 && c1 == N-1){
            return grid[r1][c1];
        }else if(memo[r1][c1][c2] != Integer.MIN_VALUE){
            return memo[r1][c1][c2];
        } else{
            int ans = grid[r1][c1];
            if(c1 != c2)ans += grid[r2][c2];
            ans += Math.max(Math.max(dp(r1, c1+1, c2+1), dp(r1+1, c1,c2+1)), 
                           Math.max(dp(r1, c1+1, c2), dp(r1+1, c1,c2)));
            memo[r1][c1][c2] = ans;
            return ans;
        }
    }
    
}
