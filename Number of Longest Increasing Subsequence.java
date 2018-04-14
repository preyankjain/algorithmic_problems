/**
**Given an unsorted array of integers, find the number of longest increasing subsequence.
**/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        if (nums.length == 0)
            return 0;
        
        int n = nums.length;
        int[] opt = new int[n];
        int[] count = new int[n];
        opt[0] = 1;
        count[0] = 1;
        int max;
        for (int i = 1; i < n; i++){
            max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if (opt[j] + 1 == max)
                        count[i] += count[j];
                    else if (opt[j] + 1 > max){
                        max = opt[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            opt[i] = Math.max(max,1);
            count[i] = Math.max(count[i],1);
        }
        
        max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            max = Math.max(max, opt[i]);
        }
        int c = 0;
        for (int i = 0; i < n; i++)
        {
            if (opt[i] == max){
                c += count[i];
            }
        }
    
        return c;
    }
}