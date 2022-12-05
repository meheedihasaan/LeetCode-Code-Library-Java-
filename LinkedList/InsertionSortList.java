/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author User
 */

//Problem Link: 

public class InsertionSortList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){
            
        }
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    
    public ListNode insertionSortList(ListNode head) {
        ListNode ans = new ListNode(-5001);
        while(head != null){
            ListNode next = head.next;
            ListNode temp = ans;
            while(temp.next != null && temp.next.val < head.val){
                temp = temp.next;
            }
            
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        return ans.next;
    }
}
