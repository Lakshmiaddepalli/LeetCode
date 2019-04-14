class Solution {
    public int largestIsland(int[][] grid) {
        int max = -1;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]== 0){
                    grid[i][j] = 1;
                    max = Math.max(max, dfs(i,j, grid, new boolean[grid.length][grid[0].length]));
                    grid[i][j] = 0;
                }
            }
        }
        //System.out.println(grid.length);
        //System.out.println(grid[0].length);
        return (max == -1 ? grid.length * grid[0].length: max );
    }
    
    
    public int dfs(int i, int j, int[][] grid, boolean[][]seen ){
        if(i<0 || i>= grid.length|| j<0 || j>=grid[0].length || seen[i][j] || grid[i][j] != 1){
            return 0;
        }
        seen[i][j] = true;
        int count = dfs(i-1, j, grid, seen) + dfs(i+1, j,grid,seen);
        count += dfs(i,j+1, grid, seen) + dfs(i, j-1, grid,seen);
        return count+1;
    }
}
