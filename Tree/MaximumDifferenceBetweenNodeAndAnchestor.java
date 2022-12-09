/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

public class MaximumDifferenceBetweenNodeAndAnchestor {
    TreeNode root;
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;       
        TreeNode(){
            
        }
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    int ans = 0;
    public int maxAncestorDiff(TreeNode root){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        dfs(root, min, max);
        return ans;
    }
    
    public void dfs(TreeNode root, int min, int max){
        if(root == null){
            return;
        }
        
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        int diff1 = Math.abs(min-root.val);
        int diff2 = Math.abs(max-root.val);
        int maxDiff = Math.max(diff1, diff2);
        ans = Math.max(ans, maxDiff);
        
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}
