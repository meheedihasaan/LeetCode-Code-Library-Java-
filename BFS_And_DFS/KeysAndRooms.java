/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BFS_And_DFS;

import java.util.List;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/keys-and-rooms/

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms){
        boolean visited[] = new boolean[rooms.size()];
        dfs(0, rooms, visited);
        
        for(boolean flag : visited){
            if(!flag){
                return false;
            }
        }
        return true;
    }
    
    //Applying DFS
    public void dfs(int i, List<List<Integer>> rooms, boolean[] visited){
        visited[i] = true;
        
        for (int j : rooms.get(i)) {
            if(!visited[j]){
                dfs(j, rooms, visited);
            }
        }
    }
}
