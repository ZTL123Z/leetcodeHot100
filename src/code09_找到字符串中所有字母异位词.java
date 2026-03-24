import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 438. 找到字符串中所有字母异位词
 * 主要是维护
 * 1.一个滑动窗口，窗口长度等于 p 的长度，判断窗口内的字符是否是 p 的异位词
 * 2.一个 match 变量，记录当前窗口内的字符是否是 p 的异位词
 * 3.while (right - left == p.length())，一个很妙的位置，right 和 left都是从0开始的，所以窗口有一个成长的过程
 */

public class code09_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        Map<Character, Integer> need_match = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : p.toCharArray()) {
            need_match.put(c, need_match.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int match = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need_match.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 用 equals 比较数值，避免 Integer 装箱问题
                if (window.get(c).equals(need_match.get(c))) {
                    match++;
                }
            }

            // 窗口长度等于 p 的长度时，判断是否是异位词
            while (right - left == p.length()) {
                if (match == need_match.size()) {
                    res.add(left);
                }
                char l = s.charAt(left);
                left++;
                if (need_match.containsKey(l)) {
                    // 先获取当前计数
                    int curr = window.get(l);
                    // 先判断是否刚好匹配，再减计数
                    if (curr == need_match.get(l)) {
                        match--;
                    }
                    window.put(l, curr - 1);
                }
            }
        }
        return res;
    }
}
