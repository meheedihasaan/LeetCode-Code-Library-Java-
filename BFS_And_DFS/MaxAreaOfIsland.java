/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BFS_And_DFS;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/max-area-of-island/

public class MaxAreaOfIsland {
    //Time Complexity: O(n*m), Space Complexity: O(n*m)
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, dfs(i, j, grid));
            }
        }
        return ans;
    }
    
    int area = 0;
    public int dfs(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return 0;
        }
        
        if(grid[i][j] == 0){
            return 0;
        }
        
        grid[i][j] = 0;
        area = 1;
        
        area+=dfs(i, j+1, grid);
        area+=dfs(i, j-1, grid);
        area+=dfs(i+1, j, grid);
        area+=dfs(i-1, j, grid);
        
        return area;
    }
}
