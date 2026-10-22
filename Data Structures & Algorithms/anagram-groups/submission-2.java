class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] arrChar = s.toCharArray();
            Arrays.sort(arrChar);
            String key = new String(arrChar);
            if(map.containsKey(key)){
                List<String> listValue = new ArrayList();
                listValue.addAll(map.get(key));
                listValue.add(s);
                map.remove(key);
                map.put(key, listValue);
                continue;
            }
            map.put(key, List.of(s));
        }
        return new ArrayList<>(map.values());
    }
}
