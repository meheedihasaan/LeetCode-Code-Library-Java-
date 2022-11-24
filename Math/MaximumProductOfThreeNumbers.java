/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Math;

import java.util.Arrays;

/**
 *
 * @author User
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int x = Math.abs(nums[0]*nums[1]);
        int y = Math.abs(nums[nums.length-3]*nums[nums.length-2]);
        
        return Math.max(x*nums[nums.length-1], y*nums[nums.length-1]);
    }
}
