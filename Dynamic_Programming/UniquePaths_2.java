/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dynamic_Programming;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/unique-paths-ii/

public class UniquePaths_2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //Time Complexity: O(n*m), Space Complexity: O(n*m)
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int grid[][] = new int[n][m];
        
        //Calculate ways for the last row
        boolean flag = false;
        for(int i = m-1; i >= 0; i--){
            if(obstacleGrid[n-1][i] == 1){
                flag = true;
            }
            else{
                if(!flag){
                    grid[n-1][i] = 1;
                }
            }
        }
        
        //Calculate ways for the last column
        flag = false;
        for(int i = n-1; i >= 0; i--){
            if(obstacleGrid[i][m-1] == 1){
                flag = true;
            }
            else{
                if(!flag){
                    grid[i][m-1] = 1;
                }
            }
        }
        
        //Calculate ways for rest of the rows and columns
        for(int i = n-2; i >= 0; i--){
            for(int j = m-2; j >= 0; j--){
                if(obstacleGrid[i][j] != 1){
                    grid[i][j] = grid[i+1][j] + grid[i][j+1];
                }
            }
        }
        return grid[0][0];
    }
}
