/**
**Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
**/


class NumArray {

    int[] opt;
    public NumArray(int[] nums) {
        opt = new int[nums.length];
        if (nums.length > 0)
        opt[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            opt[i] = nums[i] + opt[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0)
            return (opt[j] - opt[i] + opt[i]);
        else
            return (opt[j] - opt[i-1]);
    }
}