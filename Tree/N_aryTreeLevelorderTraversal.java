/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author User
 */
public class N_aryTreeLevelorderTraversal {
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
    
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        bfs(root, ans);
        return ans;
    }
    
    public void bfs(Node root, List<List<Integer>> ans){
        if(root == null){
            return;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node temp = queue.poll();
                list.add(temp.val);
                for(Node child : temp.children){
                    queue.offer(child);
                }
            }
            ans.add(new ArrayList(list));
        }
    }
    
}
