/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/palindrome-linked-list/

public class PalindromeLinkedList {
    
    class ListNode{
        ListNode next;
        int val;

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
    
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            n++;
        }
        
        int mid = n/2;
        
        //Reverse first n/2 node
        ListNode prev = null;
        ListNode current = head;
        while(mid > 0){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            mid--;
        }
        
        //Current not points the (mid+1)th node
        
        if(n%2 != 0){
            current = current.next;  //If n is odd then current points the (mid+2)th node
        }
        
        while(prev != null){
            if(prev.val != current.val){
                return false;
            }
            prev = prev.next;
            current = current.next;
        }
        return true;
    }
}
