/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BitManipulation;

/**
 *
 * @author User
 */
public class PowerOfFour {
    
    public boolean isPowerOfFour(int n){
        //If a number is power of two and has even number of unset bit then it is power of 4
        if(n > 0 && (n & (n-1)) == 0){
            int zero = 0;
            while(n != 1){
                n = n >> 1;
                zero++;
            }
            
            if(zero % 2 == 0){
                return true;
            }
        }
        return false;
    }
    
}
