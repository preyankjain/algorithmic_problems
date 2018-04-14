/**
**Given a string, find the length of the longest substring without repeating characters.
**
**Examples:
**
**Given "abcabcbb", the answer is "abc", which the length is 3.
**
**Given "bbbbb", the answer is "b", with the length of 1.
**
**Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
**/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> s1 = new HashSet<Character>();
        int j = 0;
        int ans = 0;
        for (int i = 0; i<n && j < n;)
        {
            if (!s1.contains(s.charAt(i)))
            {
                s1.add(s.charAt(i));
                ans = Math.max(ans, i-j+1);
                i++;
            }
            else
            {
                s1.remove(s.charAt(j));
                j++;
            }
        }
        return ans;
    }
}