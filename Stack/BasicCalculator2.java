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

//Problem Link: https://leetcode.com/problems/basic-calculator-ii/

public class BasicCalculator2 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                int val = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    val = (val*10) + s.charAt(i)-'0';
                    i++;
                }
                i--;
                
                if(sign == '+'){
                    stack.push(val);
                }
                if(sign == '-'){
                    stack.push((-1)*val);
                }
                if(sign == '*'){
                    int prev = stack.pop();
                    stack.push(prev*val);
                }
                if(sign == '/'){
                    int prev = stack.pop();
                    stack.push(prev/val);
                }
            }
            else if(s.charAt(i) == '+'){
                sign = '+';
            }
            else if(s.charAt(i) == '-'){
                sign = '-';
            }
            else if(s.charAt(i) == '*'){
                sign = '*';
            }
            else if(s.charAt(i) == '/'){
                sign = '/';
            }
            else{
                continue;
            }
        }
        
        int ans = 0;
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }
}
