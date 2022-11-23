/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Math;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/perfect-squares/

public class PerfectSquares {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            dp[i] = i;
            for(int j = 1; j <= i; j++){
                int x = j*j;
                if(x > i){
                    break;
                }
                else{
                    dp[i] = Math.min(dp[i], 1+dp[i-x]);
                }
            }
        }
        return dp[n];
    }
}
