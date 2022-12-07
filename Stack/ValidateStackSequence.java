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

//Problem Link: https://leetcode.com/problems/validate-stack-sequences/

public class ValidateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && popped[j] == stack.peek()){
                stack.pop();
                j++;
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
