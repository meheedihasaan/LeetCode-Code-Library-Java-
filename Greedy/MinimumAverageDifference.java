/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Greedy;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/minimum-average-difference/

public class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long prefixSum[] = new long[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }
        
        int ans = n;
        long minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            long avg1 = prefixSum[i]/(i+1);
            long avg2 = 0;
            if(n-1-i != 0){
                avg2 = (prefixSum[n-1]-prefixSum[i])/(n-1-i);
            }
            
            long diff = Math.abs(avg1-avg2);
            if(diff < minDiff){
                ans = i;
                minDiff = diff;
            }
        }
        return ans;
    }
}
