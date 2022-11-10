/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author User
 */

class ListNode{
    public ListNode next;
    public int val;
    
    public ListNode(){
        
    }
    
    public ListNode(int val){
        this.val = val;
    }
    
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

//Problem Link: https://leetcode.com/problems/reverse-linked-list/

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
