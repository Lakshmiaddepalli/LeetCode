class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] arr = new int[m][n];
        List<Integer> noOfCounts = new ArrayList<Integer>();
        
        for(int i=0; i<positions.length; i++){
                arr[positions[i][0]][positions[i][1]] = 1;
                // print(arr);
                 int p = numIslands(arr);
                 noOfCounts.add(p);
        }
        
        
        return noOfCounts;
    }
    
    void print(int [][] grid){
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println("******");
    }
    
    public int numIslands(int [][] grid) {
        
        if(grid.length == 0){
            return 0;
        }
        
        if(grid[0].length == 0){
            return 0;
        }
        
       int[][]  visited = new int[grid.length][grid[0].length];
        
        for(int i = 0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
               visited[i][j] = 0;
            }
        }
    
        int count =0;
        
        for(int i = 0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
               if(grid[i][j]== 1 && visited[i][j] ==0)
               {
                   //visited[i][j] =1;
                   //System.out.println("&&&&&&&&&&&&&&&");
                   count++;
                   dfs(grid, visited, i,j,grid.length,grid[0].length);
               } 
            }
        } 
        
        /* for(int i = 0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
               System.out.print(visited[i][j]);
            }
             System.out.println();
        }*/
        
        return count; 
    }
    
    public void dfs(int[][] grid, int[][] visited, int i, int j, int m, int n)
    {
        visited[i][j] =1;
        //System.out.println("***************");
        //System.out.println("i,j->"+ i+" "+ j);
        //System.out.println("***************");
        if (i+1>=0 && i+1<m && j>=0 && j<n && grid[i+1][j]==1 && visited[i+1][j]==0)
        {
            dfs(grid, visited, i+1,j,m,n);
        }
        
        if (i>=0 && i<m && j+1>=0 && j+1<n && visited[i][j+1]==0 && grid[i][j+1]==1)
        {
            dfs(grid, visited, i,j+1,m,n);
        }
        
        if (i-1>=0 && i-1<m && j>=0 && j<n && visited[i-1][j]==0 && grid[i-1][j]==1)
        {
            dfs(grid, visited, i-1,j,m,n);
        }
        
        if (i>=0 && i<m && j-1>=0 && j-1<n && visited[i][j-1]==0 && grid[i][j-1]==1)
        {
            dfs(grid, visited, i,j-1,m,n);
        }

        
    }
}
