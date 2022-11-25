/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Greedy;

import java.util.PriorityQueue;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterNegations(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            minHeap.offer(nums[i]);
        }
        
        while(k > 0){
            int x = minHeap.poll();
            x*=(-1);
            minHeap.offer(x);
            k--;
        }
        
        int ans = 0;
        while(!minHeap.isEmpty()){
            ans+=minHeap.poll();
        }
        return ans;
    }
}
