class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i))
                map.merge(i, 1, Integer::sum);
            else 
                map.put(i, 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int[] topK = map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();
        return topK;
    }
}
