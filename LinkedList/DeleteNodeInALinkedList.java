/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/delete-node-in-a-linked-list/

public class DeleteNodeInALinkedList {    
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    
    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
