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

//Problem Link: https://leetcode.com/problems/01-matrix/

public class Matrix01 {
    //Pair Class
    class Pair{
        int row;
        int col;
        
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        //Time Complexity: O(n*m)
        int n = mat.length;
        int m = mat[0].length;
        int arr[][] = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    queue.offer(new Pair(i, j));
                }
                else{
                    arr[i][j] = 1;
                }
            }
        }
        
        //Applying BFS
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int i = temp.row;
            int j = temp.col;
            
            int directions[][] = {{i, j+1}, {i, j-1}, {i+1, j}, {i-1, j}};
            for(int[] direction : directions){
                int r = direction[0];
                int c = direction[1];
                
                if(isValid(r, c, n, m) && arr[r][c] == 1){
                    mat[r][c] = mat[i][j] + 1;
                    arr[r][c] = 0;
                    queue.offer(new Pair(r, c));
                }
            }
            
//             if(isValid(i, j+1, n, m) && arr[i][j+1] == 1){
//                 mat[i][j+1] = mat[i][j] + 1;
//                 arr[i][j+1] = 0;
//                 queue.offer(new Pair(i, j+1));
//             }
            
//             if(isValid(i, j-1, n, m) && arr[i][j-1] == 1){
//                 mat[i][j-1] = mat[i][j] + 1;
//                 arr[i][j-1] = 0;
//                 queue.offer(new Pair(i, j-1));
//             }
            
//             if(isValid(i+1, j, n, m) && arr[i+1][j] == 1){
//                 mat[i+1][j] = mat[i][j] + 1;
//                 arr[i+1][j] = 0;
//                 queue.offer(new Pair(i+1, j));
//             }
            
//             if(isValid(i-1, j, n, m) && arr[i-1][j] == 1){
//                 mat[i-1][j] = mat[i][j] + 1;
//                 arr[i-1][j] = 0;
//                 queue.offer(new Pair(i-1, j));
//             }
        }
        return mat;
    }
    
    //Checking for index out of bound
    public boolean isValid(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return true;
    }
}
