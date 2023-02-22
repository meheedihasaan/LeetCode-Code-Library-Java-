/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BinarySearch;

/**
 *
 * @author User
 */
public class CapacityToShipPackageWithinDDays {
    
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;
        for(int weight : weights){
            sum+=weight;
            max = Math.max(max, weight);
        }

        return binarySearch(weights, days, max, sum);
    }

    public int binarySearch(int[] weights, int days, int low, int high){
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(weights, days, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] weights, int days, int capacity){
        int sum = 0;
        int cnt = 1;
        for(int weight : weights){
            sum+=weight;
            if(sum > capacity){
                cnt++;
                sum = weight;
            }

            if(cnt > days){
                return false;
            }
        }
        return true;
    }
    
}
