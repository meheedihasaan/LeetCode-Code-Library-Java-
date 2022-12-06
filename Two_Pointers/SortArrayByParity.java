/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Two_Pointers;

/**
 *
 * @author User
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int l = 0, r = nums.length-1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                ans[l] = nums[i];
                l++;
            }
            else{
                ans[r] = nums[i];
                r--;
            }
        }
        return ans;
    }
}
