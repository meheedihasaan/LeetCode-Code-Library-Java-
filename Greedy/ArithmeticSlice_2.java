/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Greedy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/arithmetic-slices-ii-subsequence/

public class ArithmeticSlice_2 {
    public int numberOfArithmeticSlices(int nums[]){
        Map<Integer, Integer>[] map = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map[i] = new HashMap<>();
        }
        
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            Map<Integer, Integer> map1 = map[i];
            for (int j = 0; j < i; j++) {
                Map<Integer, Integer> map2 = map[j];
                long x = (long)nums[i]-(long)nums[j];
                if(x < Integer.MIN_VALUE || x > Integer.MAX_VALUE){
                    continue;
                }
                
                int diff = (int)x;
                int count = map2.getOrDefault(diff, 0);
                ans+=count;
                int current = map1.getOrDefault(diff, 0); //where multiple j are same for i
                map1.put(diff, current+count+1);                
            }
        }
        return ans;
    }
}
