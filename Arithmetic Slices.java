/**
**A sequence of number is called arithmetic if it consists of at least three elements
**and if the difference between any two consecutive elements is the same.
**/


class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if (n < 3)
            return 0;
        
        int [] opt = new int [n];
        int j;
        
        opt[0] = 0;
        opt[1] = 0;
        int sum = 0;
        for (int i = 0; i < n-2; i++){
            j = i+2;
            if (A[j] - A[j-1] == A[j-1] - A[i])
            {
                opt[j] = opt[j-1]+1;
                sum += opt[j];
            }
            else
                opt[j] = 0;
        }
        
        //if(opt[n-1] > 0 && n > 3)
          //  return opt[n-1]+1;
        //else
            return sum;
    }
}