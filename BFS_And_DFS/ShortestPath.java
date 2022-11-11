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
public class ShortestPath {
    class Pair{
        int row;
        int col;
        
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        //Time Complexity: O(n*m)
        if(grid[0][0] == 1){
            return -1;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        
        //Applying BFS
        int ans = 0;
        while(!queue.isEmpty()){
            //Increment ans by one when we move to another level
            ans++;
            
            int size = queue.size();
            for(int l = 0; l < size; l++){
                Pair temp = queue.poll();
                int i = temp.row;
                int j = temp.col;

                if(i == n-1 && j == m-1){
                    return ans;
                }
            
                //Check for 8 directional neighbouring cell
                int directions[][] = {{i, j+1}, {i, j-1}, {i+1, j}, {i-1, j}, {i+1, j+1}, {i-1, j+1}, {i+1, j-1}, {i-1, j-1}};
                for(int[] direction : directions){
                    int r = direction[0];
                    int c = direction[1];

                    if(isValid(r, c, n, m) && grid[r][c] == 0){
                        grid[r][c] = 1;
                        queue.offer(new Pair(r, c));
                    }
                }
            }
        }
        return -1;
    }
    
    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }
}
