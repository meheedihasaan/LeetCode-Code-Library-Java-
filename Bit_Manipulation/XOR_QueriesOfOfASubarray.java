/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BitManipulation;

/**
 *
 * @author User
 */

Problem Link: https://leetcode.com/problems/xor-queries-of-a-subarray/

public class XOR_QueriesOfOfASubarray {
    
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;
        int ans[] = new int[m];
        for(int i = 1; i < n; i++){
            arr[i] = arr[i]^arr[i-1];
        }
        
        for(int i = 0; i < m; i++){
            int j = queries[i][0];
            int k = queries[i][1];
            if(j == 0){
                ans[i] = arr[k];
            }
            else{
                ans[i] = arr[j-1]^arr[k];
            }
        }
        return ans;
    }
    
}
