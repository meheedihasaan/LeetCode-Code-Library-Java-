/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/minimum-increment-to-make-array-unique/

public class MinimumIcrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int n : nums){
            list.add(n);
        }
        
        Collections.sort(list);
        int cnt = 0;
        for(int i = 1; i < list.size(); i++){
            if(list.get(i-1) >= list.get(i)){
                cnt+=list.get(i-1)+1-list.get(i);
                list.set(i, list.get(i-1)+1);
            }
        }
        return cnt;
    }
}
