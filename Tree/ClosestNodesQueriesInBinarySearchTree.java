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
public class ClosestNodesQueriesInBinarySearchTree {
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
    
    
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int x : queries){
            int lower = searchLower(root, x);
            int upper = searchUpper(root, x);
            
            ans.add(new ArrayList(List.of(lower, upper)));
        }
        return ans;
    }
    
    public int searchLower(TreeNode root, int target){
        int min = -1;
        while(root != null){
            if(root.val == target){
                return root.val;
            }
            else if(root.val < target){
                min = root.val;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return min;
    }
    
    public int searchUpper(TreeNode root, int target){
        int max = -1;
        while(root != null){
            if(root.val == target){
                return root.val;
            }
            else if(root.val < target){
                root = root.right;
            }
            else{
                max = root.val;
                root = root.left;
            }
        }
        return max;
    }
}
