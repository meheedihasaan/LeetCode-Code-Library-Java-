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

//Problem Link: https://leetcode.com/problems/as-far-from-land-as-possible/

public class AsFarFromLandAsPossible {
     //Time Complexity: O(n*m)
    class Distance{
        public int row;
        public int col;
        public int dis;
        
        public Distance(int row, int col, int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Distance> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    queue.offer(new Distance(i, j, 0));
                }
            }
        }
        
        //Applying BFS
        int ans = -1;
        while(!queue.isEmpty()){
            Distance temp = queue.poll();
            int row = temp.row;
            int col = temp.col;
            int dis = temp.dis;
            
            int direction[][] = {{row, col+1}, {row, col-1}, {row+1, col}, {row-1, col}};
            for(int i = 0; i < 4; i++){
                int r = direction[i][0];
                int c = direction[i][1];
                if(isValid(r, c, n, m) && grid[r][c] == 0){
                    grid[r][c] = 1;
                    queue.offer(new Distance(r, c, dis+1));
                    ans = Math.max(ans, dis+1);
                }
            }
        }
        return ans;
    }
    
    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }
}
