/**
**Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the 
**number of 1's in their binary representation and return them as an array.
**/


class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        if (num == 0)
            ans[0] = 0;
        else{
            ans[0] = 0;
            ans[1] = 1;
        }
        
        for (int i = 2; i <= num; i++){
            if (i%2 == 1){
                ans[i] = ans[i/2] + 1;
            }
            else{
                ans[i] = ans[i/2];
            }
        }
        
        return ans;
    }
}