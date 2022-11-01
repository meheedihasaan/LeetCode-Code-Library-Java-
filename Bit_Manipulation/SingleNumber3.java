/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BitManipulation;

/**
 *
 * @author Acer
 */

//Problem Link: https://leetcode.com/problems/single-number-iii/

public class SingleNumber3 {
    
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++){
            xor = xor^nums[i];
        }
        
        //Find the position of right most set bit of xor
        int j = 0;
        while(xor != 0){
            if((xor & 1) == 1){
                break;
            }
            else{
                xor = xor >> 1;
                j++;
            }
        }
        
        int num1 = 0, num2 = 0;
        int mask = 1 << j;
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & mask) == 0){
                num1 = num1^nums[i];
            }
            else{
                num2 = num2^nums[i];
            }
        }
        
        int ans[] = {num1, num2};
        return ans;
    }
    
//    public static void main(String[] args) {
//        int nums[] = {1,2,1,2,3,4,4,5,6,6};
//        int ans[] = singleNumber(nums);
//        System.out.println(ans[0]+" "+ans[1]);
//    }
    
}
