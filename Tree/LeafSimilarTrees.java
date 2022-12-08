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

//Problem Link: https://leetcode.com/problems/leaf-similar-trees/

public class LeafSimilarTrees {
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        preorder(root1, list1);
        preorder(root2, list2);

        return list1.equals(list2);
    }

    public void preorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            list.add(root.val);
        }

        preorder(root.left, list);
        preorder(root.right, list);
    }
}
