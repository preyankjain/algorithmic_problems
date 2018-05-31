/**
*Given an array of non-negative integers, you are initially positioned at the first index of the array.
*Each element in the array represents your maximum jump length at that position.
*Determine if you are able to reach the last index.
**/

class Solution {
    public boolean canJump(int[] nums) {
        int x = 1;
        int y = 1;
        int n = nums.length;
        boolean flag = true;
        for (int i = n-2; i >= 0; i--){
            if (nums[i] - x < 0 && nums[i] - y < 0){
                flag = false;
                y++;
                x++;
            }
            else{
                flag = true;
                x++;
                y = 1;
            }
        }
        
        if (flag)
            return true;
        else
            return false;
    }
}