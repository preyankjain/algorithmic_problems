/**
**
**Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
**
**If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
**
**The replacement must be in-place and use only constant extra memory.
**
**/

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        int temp;
        int ind = 0;
        for (int i = n-1; i > 0; i--){
            if (nums[i] > nums[i-1]){
                flag = true;
                break;
            }
        }
        
        if (!flag){
            Arrays.sort(nums);
            return;
        }
        
        for (int i = n-1; i > 0; i--){
            if (nums[i] > nums[i-1]){
                ind = i-1;
                int min = nums[i];
                int ind2 = i;
                for (int j = i; j < n; j++){
                    if (nums[j] < min && nums[j] > nums[ind]){
                        min = nums[j];
                        ind2 = j;
                    }
                }
                temp = nums[ind2];
                nums[ind2] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }
        System.out.println(ind);
        Arrays.sort(nums, ind+1,n);
    }
}