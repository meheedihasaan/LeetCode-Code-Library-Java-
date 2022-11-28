/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Greedy;

/**
 *
 * @author User
 */
public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[] = new int[m];
        for(int i = 0; i < m; i++){
            int j = 0;
            int k = i;
            while(j < n){
                if(k == 0 && grid[j][k] == -1){
                    ans[i] = -1;
                    break;
                }
                if(k == m-1 && grid[j][k] == 1){
                    ans[i] = -1;
                    break;
                }
                
                if(grid[j][k] == 1){
                    if(grid[j][k+1] == 1){
                        j++;
                        k++;
                    }
                    else{
                        ans[i] = -1;
                        break;
                    }
                }
                else if(grid[j][k] == -1){
                    if(grid[j][k-1] == -1){
                        j++;
                        k--;
                    }
                    else{
                        ans[i] = -1;
                        break;
                    }
                }
            }
            if(j == n){
                ans[i] = k;
            }
        }
        return ans;
    }
}
