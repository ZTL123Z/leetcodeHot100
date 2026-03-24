import java.util.*;

public class code02_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }
            else{
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
