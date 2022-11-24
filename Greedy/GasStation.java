/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Greedy;

/**
 *
 * @author User
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        int tank = 0;
        int start = 0;
        for(int i = 0; i < n; i++){
            sum+=gas[i]-cost[i];
            tank+=gas[i]-cost[i];
            if(tank < 0){
                tank = 0;
                start = i+1;
            }
        }
        
        if(sum < 0){
            return -1;
        }
        return start;
    }
}
