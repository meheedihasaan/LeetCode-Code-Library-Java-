/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/range-sum-of-bst/description/

public class RangeSumOfBST {
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        preorder(root, low, high);
        return ans;
    }

    public void preorder(TreeNode root, int low, int high){
        if(root == null){
            return;
        }

        if(root.val >= low && root.val <= high){
            ans+=root.val;
        }
        preorder(root.left, low, high);
        preorder(root.right, low, high);
    }
}
