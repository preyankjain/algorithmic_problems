/**
**Given two strings s and t, determine if they are isomorphic.
**
**Two strings are isomorphic if the characters in s can be replaced to get t.
**
**All occurrences of a character must be replaced with another character while preserving the order of 
**characters. No two characters may map to the same character but a character may map to itself.
**/


class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        boolean flag;
        if (s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<Character, Character>();
        Map<Character, Character> reverseMap = new HashMap<Character, Character>();
        for (int i = 0; i < n; i++){
            if (map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            else
                map.put(s.charAt(i), t.charAt(i));
            if (reverseMap.containsKey(t.charAt(i))){
                if (reverseMap.get(t.charAt(i)) != s.charAt(i))
                    return false;
            }
            else
                reverseMap.put(t.charAt(i), s.charAt(i));
        }
        
        return true;
    }
}