/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class BinaryTreePreorderTraversal {
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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }
    
    public void preorder(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.val);
        
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}
