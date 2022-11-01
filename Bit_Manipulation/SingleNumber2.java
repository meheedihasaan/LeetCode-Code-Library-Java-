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

//Problem Link: https://leetcode.com/problems/single-number-ii/

public class SingleNumber2 {
   
    public static int singleNumber(int nums[]){
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int set = 0;
            //left shifted 1 by i so that we can check if i'th bit is set or on
            int mask = 1 << i;
            for (int j = 0; j < nums.length; j++) {
                if((nums[j] & mask) != 0){
                    set++;
                }
            }
            
            //If number of set bits is not divisible by 3 then it is the desired number which is occured twice
            if(set%3 != 0){
                ans = ans | mask;
            }
        }
        return ans;
    }
    
//    public static void main(String[] args) {
//        int nums[] = {2,2,2,3};
//        System.out.println(singleNumber(nums));
//    }
    
}
