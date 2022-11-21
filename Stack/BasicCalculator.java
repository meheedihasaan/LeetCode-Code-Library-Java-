/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stack;

import java.util.Stack;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/basic-calculator/

public class BasicCalculator {
    public int calculate(String s){
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int sign = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(0))){
                int val = 0;
                while(i < s.length() && Character.isDigit(0)){
                    val = (val*10) + s.charAt(i) - '0';
                    i++;
                }
                i--;
                
                val*=sign;
                sum+=val;
                sign = 1;
            }
            else if(s.charAt(i) == '('){
                stack.push(sum);
                stack.push(sign);
                
                //Reset Sum and sign
                sum = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')'){
                int prevSign = stack.pop();
                int prev = stack.pop();
                
                sum*=prevSign;
                sum+=prev;
            }
            else if(s.charAt(i) == '-'){
                sign = -1;
            }
            else{
                continue;
            }
        }
        return sum;
    }
}
