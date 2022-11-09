/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BFS_And_DFS;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/number-of-closed-islands/

public class NumberOfClosedIslands {
    //Time Complexity: O(n*m), Space Complexity: O(n*m)
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    if(dfs(i, j, grid)){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    
    public boolean dfs(int i, int j, int grid[][]){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return false;
        }
        
        if(grid[i][j] == 1){
            return true;
        }
        
        grid[i][j] = 1;
        
        boolean f1 = dfs(i, j+1, grid);
        boolean f2 = dfs(i, j-1, grid);
        boolean f3 = dfs(i+1, j, grid);
        boolean f4 = dfs(i-1, j, grid);
        
        return f1 && f2 && f3 && f4;
    }
}
