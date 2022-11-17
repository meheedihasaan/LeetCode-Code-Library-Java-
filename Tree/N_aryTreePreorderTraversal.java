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
public class N_aryTreePreorderTraversal {
    Node root;
    class Node{
        int val;
        List<Node> children;
        Node(){
            
        }
        Node(int val){
            this.val = val;
        }
        Node(int val, List<Node> children){
            this.val = val;
            this.children = children;
        }
    }
    
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
    
    public void dfs(Node root, List<Integer> ans){
        if(root == null){
            return;
        }
        
        ans.add(root.val);
        for(Node child : root.children){
            dfs(child, ans);
        }
    }
}
