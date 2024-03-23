package by.sel;

import java.util.HashMap;

public class Q383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (char c : magazine.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            chars[c - 'a']--;
        }
        for (int c : chars) {
            if (c < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : magazine.toCharArray()) {
            if (map.isEmpty()) {
                return true;
            }
            if (!map.containsKey(c)) {
                continue;
            }
            Integer i = map.get(c);
            if (i == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return map.isEmpty();
    }
}
