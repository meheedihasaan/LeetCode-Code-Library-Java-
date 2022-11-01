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
public class SingleNumber1 {
    
    public static int singleNumber(int nums[]){
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor^nums[i];
        }
        return xor;
    }
    
    public static void main(String[] args) {
        int nums[] = {1,2,1,2,3,4,5,5,4};
        System.out.println(singleNumber(nums));
    }
    
}
