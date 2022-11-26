/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Greedy;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartEqualSum(int arr[]){
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }
        
        if(sum%3 != 0){
            return false;
        }
        
        int x = sum/3;
        int segment = 0;
        int segmentSum = 0;
        for (int i = 0; i < n; i++) {
            segmentSum+=arr[i];
            sum-=arr[i];
            if(segmentSum == x){
                segmentSum = 0;
                segment++;
                if(segment == 2 && sum == x && i != n-1){
                    return true;
                }
                
                if(segment == 3 && i == n-1){
                    return false;
                }
            }
        }
        return false;
    }
}
