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


//Problem Link: https://leetcode.com/problems/linked-list-cycle/

public class LinkedListCycle {
    public boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
