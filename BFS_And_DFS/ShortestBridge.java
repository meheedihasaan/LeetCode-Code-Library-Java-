/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BFS_And_DFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/shortest-bridge/

public class ShortestBridge {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            boolean flag = false;
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, grid, queue);
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        
        //Applying BFS
        int cnt = 0;
        while(!queue.isEmpty()){
            cnt++;
            int size = queue.size();
            for(int k = 0; k < size; k++){
                Pair temp = queue.poll();
                int i = temp.row;
                int j = temp.col;
                
                if(grid[i][j] == 1){
                    return 100;
                }
                
                int directions[][] = {{i, j+1}, {i, j-1}, {i+1, j}, {i-1, j}};
                for(int[] direction : directions){
                    int r = direction[0];
                    int c = direction[1];
                    
                    //If the second island is found
                    if(isValid(r, c, n, m) && grid[r][c] == 1){
                        return cnt-1;
                    }
                    
                    if(isValid(r, c, n, m) && grid[r][c] == 0){
                        grid[r][c] = 2;
                        queue.offer(new Pair(r, c));
                    }
                }
            }
        }
        return cnt;
    }
    
    //Applying DFS
    public void dfs(int i, int j, int[][] grid, Queue<Pair> queue){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        
        if(grid[i][j] == 2 || grid[i][j] == 0){
            return;
        }
        
        grid[i][j] = 2;
        queue.offer(new Pair(i, j));
        
        dfs(i, j+1, grid, queue);
        dfs(i, j-1, grid, queue);
        dfs(i+1, j, grid, queue);
        dfs(i-1, j, grid, queue);
    }
    
    //For checking index out of bound
    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }
}
