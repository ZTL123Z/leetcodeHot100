import java.util.HashMap;
import java.util.Map;

public class code12_最小覆盖子串 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, length = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right++);

            // 更新窗口
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) { //后面数量超过了也算进去了
                    valid++;
                }
            }

            // 收缩窗口
            while (valid == need.size()) {
                // 更新最小窗口
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }

                char d = s.charAt(left++);

                if (need.containsKey(d)) {
                    // 只有当前计数刚好等于需要的数量时，减1后才会导致valid减少
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                    // 或者用 computeIfPresent：window.computeIfPresent(d, (k, v) -> v - 1);
                }
            }
        }

        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}