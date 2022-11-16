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
public class BinaryTreePostorderTraversal {
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
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }
    
    public void postorder(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}
