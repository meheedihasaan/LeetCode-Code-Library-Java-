/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Greedy;

import java.util.Arrays;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/valid-triangle-number/

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);               
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                int sum = nums[i]+nums[j];
                int l = j+1;
                int r = n-1;
                while(l < r-1){
                    int mid = l+(r-l)/2;
                    if(nums[mid] >= sum){
                        r = mid-1;
                    }
                    else{
                        l = mid;
                    }
                }
                
                if(nums[r] < sum){
                    cnt+=(r-j);
                }
                else if(nums[l] < sum){
                    cnt+=(l-j);
                }
            }
        }
        return cnt;
    }
}
