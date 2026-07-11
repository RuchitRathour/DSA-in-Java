class Solution {
    public boolean isAnagram(String s, String t) {
        // 1. length compare 
        if(s.length() != t.length()){
            return false;
        }
        // 2. count/find frequency of s 
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        // 3. Decrease Frequency 
        for(char ch : t.toCharArray()){
            if(!map.containsKey(ch)){
                return false;
            }
            map.put(ch,map.get(ch)-1);
            if(map.get(ch) == 0){
                map.remove(ch);
            }
        }

        // 4.
        return map.isEmpty();
    }
}