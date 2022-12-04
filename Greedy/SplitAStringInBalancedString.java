/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Greedy;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/split-a-string-in-balanced-strings/

public class SplitAStringInBalancedString {
    public int balancedStringSplit(String s) {
        int n = s.length();
        int sumL[] = new int[n+1];
        int sumR[] = new int[n+1];
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'L'){
                sumL[i+1] = sumL[i]+1;
                sumR[i+1] = sumR[i];
            }
            else{
                sumR[i+1] = sumR[i]+1;
                sumL[i+1] = sumL[i];
            }
            
            if(sumL[i+1] == sumR[i+1]){
                cnt++;
            }
        }
        return cnt;
    }
}
