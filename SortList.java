/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/sort-list/

public class SortList {
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
    
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    //Applying Divide and Conquer
    public ListNode mergeSort(ListNode head){
        //If List is null or List has only one element
        if(head == null || head.next == null){
            return head;
        }
        
        //Find the mid element of the List
        ListNode mid = getMid(head);
        //Find the next element of the mid element
        ListNode midNext = mid.next;
        mid.next = null;
        
        //Recursive call for left and right Sub-List
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(midNext);
        
        //Applying Merge in left and right Sub-List
        ListNode sortedList = merge(left, right);
        return sortedList;
    }
    
    //Merging left and right Sub-List
    public ListNode merge(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        
        if(list2 == null){
            return list2;
        }
        
        ListNode sorted = new ListNode();
        ListNode ansHead = sorted;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                sorted.next = list1;
                list1 = list1.next;
            }
            else{
                sorted.next = list2;
                list2 = list2.next;
            }
            sorted = sorted.next;
        }
        
        if(list1 != null){
            sorted.next = list1;
        }
        
        if(list2 != null){
            sorted.next = list2;
        }
        
        return ansHead.next;
    }
    
    //Find the mid element of the List
    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
