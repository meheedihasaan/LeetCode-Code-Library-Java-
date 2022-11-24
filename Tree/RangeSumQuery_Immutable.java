/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

/**
 *
 * @author User
 */
public final class RangeSumQuery_Immutable {
    int tree[];
    int n = 0;
    public RangeSumQuery_Immutable(int[] nums) {
        n = nums.length;
        int height = (int)Math.ceil(Math.log(n)/Math.log(2));
        int size = 2*((int)Math.pow(2, height))-1;
        tree = new int[size];
        buildTree(0, 0, n-1, nums);
    }
    
    public void buildTree(int node, int start, int end, int[] nums){
        if(start == end){
            tree[node] = nums[start];
            return;
        }
        
        int mid = (start+end)/2;
        buildTree(2*node+1, start, mid, nums);
        buildTree(2*node+2, mid+1, end, nums);
        
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }
    
    public int getSum(int node, int start, int end, int left, int right){
        if(start > right || end < left){
            return 0;
        }
        
        if(start >= left && end <= right){
            return tree[node];
        }
        
        int mid = (start+end)/2;
        int leftSum = getSum(2*node + 1, start, mid, left, right);
        int rightSum = getSum(2*node + 2, mid+1, end, left, right);
        
        return leftSum + rightSum;
    }
    
    public int sumRange(int left, int right) {
        return getSum(0, 0, n-1, left, right);
    }
}
