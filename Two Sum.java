/**
**Given an array of integers, return indices of the two numbers such that they add up to a specific target.
**
**You may assume that each input would have exactly one solution, and you may not use the same element twice.
**/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++){
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < n; i++){
            if (map.containsKey(nums[i])){
                if (map.get(nums[i]) != i){
                    ans[0] = i;
                    ans[1] = map.get(nums[i]);
                }
            }
        }
        return ans; 
    }
}