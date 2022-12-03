/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/sort-characters-by-frequency/

public class SortCharacterByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        List<Character> list = new ArrayList(map.keySet());
        Collections.sort(list, (a,b)->map.get(b)-map.get(a));
//        Collections.sort(list, new Comparator<Character>(){
//
//            @Override
//            public int compare(Character c1, Character c2) {
//                int comparison = map.get(c2).compareTo(map.get(c1));
//                return comparison;
//            }
//            
//        });
        
        String ans = "";
        for(char c : list){
            for(int i = 0; i < map.get(c); i++){
                ans+=c;
            }
        }
        return ans;
    }
}
