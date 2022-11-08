/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BFS_And_DFS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/word-search-ii/
 
class Node{
    public Node links[] = new Node[26];
    public String word;

    public boolean containsKey(char c){
        return (links[c-'a'] != null);
    }

    public Node get(char c){
        return links[c-'a'];
    }

    public void put(int c, Node node){
        links[c-'a'] = node;
    }
}

public class WordSearch_2 {
    public List<String> findWords(char[][] board, String[] words) {
        Node node = buildTrie(words);
        List<String> ans = new ArrayList<>();        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(i, j, board, node, ans);
            }
        }
        return ans;
    }
    
    public void dfs(int i, int j, char[][] board, Node node, List<String> ans){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return;
        }
        
        char c = board[i][j];
        if(c == '#'){
            return;
        }
        
        //If character c not in Trie then stop
        if(!node.containsKey(c)){
            return;
        }
        
        node = node.get(c);
        
        //If word found in Trie
        if(node.word != null){
            ans.add(node.word);
            node.word = null; //To avoid stroring duplicate string
        }
        
        //To Avoid duplicate call
        board[i][j] = '#';
        
        //Recursive call for 4 directional cell
        dfs(i, j+1, board, node, ans);
        dfs(i, j-1, board, node, ans);
        dfs(i+1, j, board, node, ans);
        dfs(i-1, j, board, node, ans);
        
        //Backtracking
        board[i][j] = c;
    } 
    
    public Node buildTrie(String[] words){
        Node root = new Node();
        for(String s : words){
            Node node = root;
            for(char c : s.toCharArray()){
                if(!node.containsKey(c)){
                    node.put(c, new Node());
                }
                node = node.get(c);
            }
            node.word = s;
        }
        return root;
    }
}
