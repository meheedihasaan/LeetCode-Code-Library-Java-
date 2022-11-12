/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Heap;

import java.util.PriorityQueue;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/median-of-two-sorted-arrays/

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { 
        //Min Max Heap Technique
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int i : nums1){
            minHeap.offer(i);
            maxHeap.offer(minHeap.poll());
            if(maxHeap.size() > minHeap.size()){
                minHeap.offer(maxHeap.poll());
            }
        }
        
        for(int i : nums2){
            minHeap.offer(i);
            maxHeap.offer(minHeap.poll());
            if(maxHeap.size() > minHeap.size()){
                minHeap.offer(maxHeap.poll());
            }
        }
        
        if(minHeap.size() > maxHeap.size()){
            return (double) minHeap.peek();
        }
        else{
            return (double) (minHeap.peek()+maxHeap.peek())/2.0;
        }
        
        
        //Merge Sort Technique
//         int n = nums1.length;
//         int m = nums2.length;
//         int[] arr = new int[n+m];
//         int i = 0;
//         int j = 0; 
//         int k = 0;
//         while(i < nums1.length && j < nums2.length){
//             if(nums1[i] < nums2[j]){
//                 arr[k++] = nums1[i++];
//             }
//             else{
//                 arr[k++] = nums2[j++];
//             }
//         } 
        
//         while(i < nums1.length){
//             arr[k++] = nums1[i++];
//         }
        
//         while(j < nums2.length){
//             arr[k++] = nums2[j++];
//         }
        
//         int mid = arr.length/2;
//         if(arr.length % 2 == 1){
//             return (double) arr[mid];
//         }
//         else{
//             return (arr[mid-1]+arr[mid])/2.0;
//         }
    }
}
