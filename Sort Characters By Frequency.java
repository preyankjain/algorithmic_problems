/**
**Given a string, sort it in decreasing order based on the frequency of characters.
**/


class Solution {
    public String frequencySort(String s) {
        
        int[] ar = new int['z' + 1];
        Map<Character, Integer> map = new HashMap<>();
                
        for (int i = 0; i < s.length(); i++){
            ar[s.charAt(i)] += 1;
        }
        
        TreeMap<Integer, List<Character>> map2 = new TreeMap<>();
        List<Character> l;
        for (int i = ' '; i < ar.length; i++){
            if (ar[i] == 0)
                continue;
            else if (map2.containsKey(ar[i])){
                l = map2.get(ar[i]);
            }
            else{
                l = new ArrayList<Character>();
            }
            l.add((char)i);
            map2.put(ar[i], l);
        }
        
        StringBuilder sb = new StringBuilder();
        while (map2.size() > 0){
            int i = map2.lastKey();
            l = map2.get(i);
            for (Character c : l){
                for (int j = 0; j < i; j++)
                    sb.append(c);
            }
            map2.remove(i);
        }
        return sb.toString();
    }
}