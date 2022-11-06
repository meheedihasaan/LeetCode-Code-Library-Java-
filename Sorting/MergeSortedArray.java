/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sorting;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/merge-sorted-array/

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //Time Complexity: O(n+m), Space Complexity: O(n+m)
//         int i = 0;
//         int j = 0;
//         int k = 0;
//         int temp[] = new int[m+n];
//         while(i < m && j < n){
//             if(nums1[i] <= nums2[j]){
//                 temp[k++] = nums1[i++];
//             }
//             else{
//                 temp[k++] = nums2[j++];
//             }
//         }
        
//         while(i < m){
//             temp[k++] = nums1[i++];
//         }
        
//         while(j < n){
//             temp[k++] = nums2[j++];
//         }
        
//         for(int l = 0; l < temp.length; l++){
//             nums1[l] = temp[l];
//         }
        
        //Time Complexity: O(n+m), Space Complexity: O(1)
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i >= 0 && j >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        
        while(j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
