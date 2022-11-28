/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/find-players-with-zero-or-one-losses/

public class FindPlayerWithZeroOrOneLosses {
    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] result = new int[12];
        for(int[] match : matches){
            int w = match[0];
            int l = match[1];
            
            if(result[w] == 0){
                result[w] = 1;
            }
                       
            if(result[l] > 0){ //If already won
                result[l] = -1;
            }
            else{   //If already lost
                result[l]--;
            }
        }
        
        List<Integer> winner = new ArrayList<>();
        List<Integer> loser = new ArrayList<>();
        for(int i = 1; i < result.length; i++){
            if(result[i] == 1){
                winner.add(i);
            }
            else if(result[i] == -1){
                loser.add(i);
            }
        }
        ans.add(new ArrayList(winner));
        ans.add(new ArrayList(loser));
        
        return ans;
    }
}
