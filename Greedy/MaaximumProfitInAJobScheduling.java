/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author User
 */

//Problem Link: https://leetcode.com/problems/maximum-profit-in-job-scheduling/

public class MaaximumProfitInAJobScheduling {
    class Job{
        public int start;
        public int end;
        public int profit;
        public Job(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    
    public int jobScheduling(int startTime[], int endTime[], int profit[]){
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        //Sort jobs according to their ending time in ascending order
        Collections.sort(jobs, (a,b)->a.end-b.end);
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        int ans = 0;
        for (Job currentJob : jobs) {
            int prevEnd = map.floorKey(currentJob.start);   //Get the ending time of nearest previous job
            int prevProfit = map.get(prevEnd);  //Get the profit of nearest previous job
            ans = Math.max(ans, prevProfit + currentJob.profit);
            map.put(currentJob.end, ans);
        }
        return ans;
    }
}
