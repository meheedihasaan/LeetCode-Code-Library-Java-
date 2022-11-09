/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BFS_And_DFS;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/count-sub-islands/

public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        //Time Complexity: O(n*m), Space Complexity: O(n*m)
        int ans = 0; 
        for(int i = 0; i < grid2.length; i++){
            for(int j = 0; j < grid2[0].length; j++){
                if(grid2[i][j] == 1){
                    if(dfs(i, j, grid1, grid2)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    
    public boolean dfs(int i, int j, int[][] grid1, int[][] grid2){
        if(i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length){
            return true;
        }
        
        if(grid2[i][j] == 0){
            return true;
        }
        
        if(grid1[i][j] == 0 && grid2[i][j] == 1){
            return false;
        }
        
        //When current cell of both grid is 1
        grid2[i][j] = 0;
        
        boolean a = dfs(i, j+1, grid1, grid2);
        boolean b = dfs(i, j-1, grid1, grid2);
        boolean c = dfs(i+1, j, grid1, grid2);
        boolean d = dfs(i-1, j, grid1, grid2);
        
        return a && b && c && d;
    }
}
