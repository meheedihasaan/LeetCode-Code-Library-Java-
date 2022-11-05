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

//Problem Link: https://leetcode.com/problems/rotting-oranges/

public class RottingOranges {
    class Pair{
        public int row;
        public int col;
        
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Pair(i, j));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        //Applying BFS
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean flag = false;
            for(int i = 0; i < size; i++){
                Pair temp = queue.poll();
                int row = temp.row;
                int col = temp.col;
                
                //Check for 4 directional adjacent cell
                if(isValid(row, col+1, n, m) && grid[row][col+1] == 1){
                    grid[row][col+1] = 2;
                    queue.offer(new Pair(row, col+1));
                    fresh--;
                    flag = true;
                }
                
                if(isValid(row, col-1, n, m) && grid[row][col-1] == 1){
                    grid[row][col-1] = 2;
                    queue.offer(new Pair(row, col-1));
                    fresh--;
                    flag = true;
                }
                
                if(isValid(row+1, col, n, m) && grid[row+1][col] == 1){
                    grid[row+1][col] = 2;
                    queue.offer(new Pair(row+1, col));
                    fresh--;
                    flag = true;
                }
                
                if(isValid(row-1, col, n, m) && grid[row-1][col] == 1){
                    grid[row-1][col] = 2;
                    queue.offer(new Pair(row-1, col));
                    fresh--;
                    flag = true;
                }
            }
            if(flag){
                count++;
            }
        }
        if(fresh > 0){
            return -1;
        }
        return count;
    }
    
    //Method for checking bound of index
    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }
}
