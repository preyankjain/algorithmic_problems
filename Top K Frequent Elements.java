/**
** Given a non-empty array of integers, return the k most frequent elements.
**/


class Solution {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        int len = map.keySet().size();
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<Integer, List<Integer>>();
        int[] ans = new int[len];
        for (int i : map.keySet()){
            List<Integer> list1;
            if (treeMap.containsKey(map.get(i))){
                list1 = treeMap.get(map.get(i));
            }
            else{
                list1 = new ArrayList<Integer>();
            }
            list1.add(i);
            treeMap.put(map.get(i), list1);
        }
        
        
        while(treeMap.size() > 0 && list.size() < k){
            int i = treeMap.lastKey();
            List<Integer> l = treeMap.get(i);
            treeMap.remove(i);
            for (int j : l){
                if (list.size() < k)
                    list.add(j);
            }
        }
        return list;
    }
}