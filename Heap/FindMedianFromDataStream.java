/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Heap;

import java.util.PriorityQueue;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/find-median-from-data-stream/

public class FindMedianFromDataStream {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    
    public FindMedianFromDataStream(){
        min = new PriorityQueue<>();  //Min contains the first half in ascending order
        max = new PriorityQueue<>((a,b)-> b-a); //Max contains the second half in descending order
    }
    
    public void add(int num){
        min.offer(num);
        max.offer(max.poll());
        if(min.size() > max.size()){
            min.offer(max.poll());
        }
    }
    
    public double median(){
        if(min.size() > max.size()){
            return (double) min.peek();
        }
        else{
            return (min.peek()+max.peek())/2.0;
        }
    }
}
