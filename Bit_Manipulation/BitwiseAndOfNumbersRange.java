/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BitManipulation;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/bitwise-and-of-numbers-range/

public class BitwiseAndOfNumbersRange {
    
    public int rangeBitwiseAnd(int left, int right){
        int ans = 0;
        while(left > 0 && right > 0){
            int msbLeft = msbPosition(left);
            int msbRight = msbPosition(right);
            
            //If the msb's position of left and right range don't match then break
            if(msbLeft != msbRight){
                break;
            }
            
            //Add 2^msbPostion to ans
            int msbVal = (1 << msbLeft);
            ans+=msbVal;
            
            //Substraact current msbVal from left and right
            left-=msbVal;
            right-=msbVal;            
        }
        return ans;
    }
    
    //Method to get the posion of MSB of a number
    public int msbPosition(int n){
        int pos = -1;
        while(n > 0){
            n = n >> 1;
            pos++;
        }
        return pos;
    }
    
    public static void main(String[] args) {
        BitwiseAndOfNumbersRange b = new BitwiseAndOfNumbersRange();
        System.out.println(b.rangeBitwiseAnd(4, 7));
    }
    
}
