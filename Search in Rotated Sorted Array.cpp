/**
**Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
**
**(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
**
**You are given a target value to search. If found in the array return its index, otherwise return -1.
**
**You may assume no duplicate exists in the array.
**
**Your algorithm's runtime complexity must be in the order of O(log n).
**/

class Solution {
public:
    int search(vector<int>& nums, int target) {
        
        int n = nums.size();
        
        int l = 0;
        int r = n-1;
        
        int mid;
        
        while (l <= r)
        {
            mid = floor((l+r)/2);
            if (target > nums.at(l) && target > nums.at(mid) && target < nums.at(r)) 
            {
                l = mid+1;
            }
            else if (target < nums.at(l) && target > nums.at(mid) && target < nums.at(r)) 
            {
                l = mid+1;
            }
            else if (target < nums.at(mid) && target > nums.at(r))
            {
                r = mid-1;
            }
            else if (target > nums.at(l) && target > nums.at(mid) && target > nums.at(r) && nums.at(mid) < nums.at(l))
            {
                r = mid-1;
            }
            else if (target > nums.at(l) && target > nums.at(mid) && target > nums.at(r) && nums.at(mid) > nums.at(l))
            {
                l = mid+1;
            }
            else if (target > nums.at(l) && target < nums.at(mid) && target > nums.at(r))
            {
                r = mid-1;
            }
            else if (target < nums.at(l) && target < nums.at(mid) && target < nums.at(r) && nums.at(mid) < nums.at(l))
            {
                r = mid-1;
            }
            else if (target < nums.at(l) && target < nums.at(mid) && target < nums.at(r) && nums.at(mid) > nums.at(l))
            {
                l = mid+1;
            }
            else if (target > nums.at(l) && target < nums.at(mid) && target < nums.at(r))
            {
                r = mid-1;
            }
            else if (nums.at(mid) == target)
            {
                return mid;
            }
            else if (nums.at(r) == target)
            {
                return r;
            }
            else if (nums.at(l) == target)
            {
                return l;
            }
            else
            {
                break;
            }
        }
        
        
        return -1;
    }
};