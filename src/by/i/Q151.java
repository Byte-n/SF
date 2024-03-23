package by.i;

public class Q151 {
    public static void main(String[] args) {
        System.out.println("  hello world   = " + reverseWords("  hello world  ") + "|");
        System.out.println("the sky is blue = " + reverseWords("the sky is blue") + "|");
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int start = 0, end = 0;

        // 移除首尾空格、还需要移除中间的空格
        while (end < len) {
            if (chars[end] == ' ') {
                // 开头的空格
                if (start == 0) {
                    end++;
                    continue;
                }
                // 中间的连续空格
                else if (end < len - 1 && chars[end + 1] == ' ') {
                    end++;
                    continue;
                }
                // 结尾空格
                else if (end == len - 1) {
                    end++;
                    continue;
                }
            }
            chars[start] = chars[end];
            start++;
            end++;
        }
        // 首尾，闭区间
        end = start
                // 使 end 为最后一位，闭区间
                - 1;
        start = 0;
        reverseString(chars, start, end);
        int left = start;
        for (int i = start; i <= end; i++) {
            char c = chars[i];
            if (c == ' ') {
                reverseString(chars, left, i - 1);
                left = i + 1;
                continue;
            }
            if (i == end) {
                reverseString(chars, left, end);
            }
        }

        return String.copyValueOf(chars, start, end - start + 1);
    }

    public static void reverseString(char[] chars, int left, int right) {
        while (left < right) {
            // 交换
            char leftC = chars[left];
            chars[left] = chars[right];
            chars[right] = leftC;

            left++;
            right--;
        }
    }
}
