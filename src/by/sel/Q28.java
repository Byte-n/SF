package by.sel;

import java.util.Arrays;

public class Q28 {
    public static void main(String[] args) {
        int[] next = getNext("aabaaf".toCharArray());
        System.out.println("next = " + Arrays.toString(next));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int[] next = getNext(needle.toCharArray());
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    // next -1µÄ·½Ê½
    private static int[] getNext(char[] chars) {
        int len = chars.length;
        int[] next = new int[len];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < len - 1) {
            if (j == -1 || chars[i] == chars[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
