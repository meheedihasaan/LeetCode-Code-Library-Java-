/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Two_Pointers;

import java.util.List;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/reverse-vowels-of-a-string/

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        List<Character> vowel = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int left = 0;
        int right = s.length()-1;
        char ch[] = s.toCharArray();            
        while(left <= right){
            char c1 = ch[left];
            char c2 = ch[right];
            if(vowel.contains(c1) && vowel.contains(c2)){
                ch[left] = c2;
                ch[right] = c1;
                left++;
                right--;
                continue;
            }
            
            if(vowel.contains(c1)){
                right--;
            }
            else if(vowel.contains(c2)){
                left++;
            }
            else{
                left++;
                right--;
            }
        }
        return String.valueOf(ch);
    }
}
