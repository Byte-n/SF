package by.i;

/** 242. 有效的字母异位词 */
public class Q242 {
    public boolean isAnagram(String s, String t) {
        char aChar = 'a';
        char[] sCharArray = s.toCharArray();
        int[] chars = new int[26];
        for (char c : sCharArray) {
            chars[c - aChar]++;
        }
        char[] tCharArray = t.toCharArray();
        for (char c : tCharArray) {
            chars[c - aChar]--;
        }
        for (int c : chars) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
