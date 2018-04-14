/**
**All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
**When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
**
**Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
**/


class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        List<String> list1 = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        if (n <= 10)
            return list1;
        sb.append(s, 0, 10);
        Set<String> stringSet = new HashSet<String>();
         
        stringSet.add(sb.toString());
        for (int i = 10; i < n; i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            if(stringSet.contains(sb.toString()))
                set.add(sb.toString());
            else
                stringSet.add(sb.toString());
        }
        
        List<String> list = new ArrayList<String>(set);
        
        return list;
    }
}