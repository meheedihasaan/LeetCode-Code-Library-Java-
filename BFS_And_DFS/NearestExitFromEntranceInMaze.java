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

//Problem Link: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/

public class NearestExitFromEntranceInMaze {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int nearestExit(char[][] maze, int[] entrance) {
        if(maze[entrance[0]][entrance[1]] == '+'){
            return -1;
        }
        
        int n = maze.length;
        int m = maze[0].length;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(entrance[0], entrance[1]));
        maze[entrance[0]][entrance[1]] = '+';
        
        //Apply BFS
        int ans = 0;
        while(!queue.isEmpty()){
            ans++;
            int size = queue.size();
            for(int k = 0; k < size; k++){
                Pair temp = queue.poll();
                int i = temp.row;
                int j = temp.col;
                
                int[][] directions = {{i, j+1}, {i, j-1}, {i+1, j}, {i-1, j}};
                for(int[] direction : directions){
                    int r = direction[0];
                    int c = direction[1];
                    
                    if(isValid(r, c, n, m) && maze[r][c] == '.'){
                        maze[r][c] = '+';
                        queue.offer(new Pair(r, c));
                        if(r == 0 || r == n-1 || c == 0 || c == m-1){
                            return ans;
                        }
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
