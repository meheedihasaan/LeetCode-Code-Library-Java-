/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BFS_And_DFS;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/word-search/

public class WordSearch_1 {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, word, 0, board)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, String word, int index, char[][] board){
        if(index == word.length()){
            return true;
        }
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        
        if(word.charAt(index) != board[i][j]){
            return false;
        }
        
        char prev = board[i][j];
        board[i][j] = '#';
        
        boolean left = dfs(i, j-1, word, index+1, board);
        boolean right = dfs(i, j+1, word, index+1, board);
        boolean top = dfs(i-1, j, word, index+1, board);
        boolean bottom = dfs(i+1, j, word, index+1, board);
        
        //Backtracking
        board[i][j] = prev;
        
        return left || right || top || bottom;
    }
}
