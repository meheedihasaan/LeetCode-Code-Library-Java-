/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Math;

/**
 *
 * @author User
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int c = 1;
        for(int i = n-1; i >= 0; i--){
            int x = c + digits[i];
            if(x >= 10){
                digits[i] = x-10;
            }
            else{
                digits[i] = x;
                c = 0;
                break;
            }
        }
        
        //If carry is 0
        if(c == 0){
            return digits;
        }
        
        //If carry is 1
        int ans[] = new int[n+1];
        ans[0] = 1;
        for(int i = 0; i < n; i++){
            ans[i+1] = digits[i];
        }
        
        return ans;
    }
}
