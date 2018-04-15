/**
**You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
**
**Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
**
**Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
**/

class Solution {
    public int findLongestChain(int[][] pairs) {
        
        int n = pairs.length;
        
        int[] opt = new int[n];
        
        int min = 0;
        int min2 = Integer.MIN_VALUE;
        
        int ind = 0;
        
        Set<Integer> indSet = new HashSet<Integer>();
        
        boolean flag = true;
        int count = 0;
        while(flag == true)
        {
            flag = false;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++)
            {
                if (min > pairs[i][1] && !indSet.contains(i) && pairs[i][0] > min2)
                {
                    flag = true;
                    min = pairs[i][1];
                    ind = i;
                }
            }
            if (flag)
                count++;
            min2 = min;
            indSet.add(ind);
        }
        
        return count;
        
        
    }
}