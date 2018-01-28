public int lengthOfLongestSubstring(String s) 
{
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