/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BFS_And_DFS;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/number-of-islands/

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        //Time Complexity: O(n*m), Space Complexity: O(n*m)
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    public void dfs(int i, int j, char[][] grid){
        //If index is out of bound then stop
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        
        //If current cell is water then return
        if(grid[i][j] == '0'){
            return;
        }
        
        //Set land as water
        grid[i][j] = '0';
        
        //Recursive call for 4 directional neighbouring cells
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
    }
}
