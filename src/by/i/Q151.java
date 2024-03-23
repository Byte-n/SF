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

        // �Ƴ���β�ո񡢻���Ҫ�Ƴ��м�Ŀո�
        while (end < len) {
            if (chars[end] == ' ') {
                // ��ͷ�Ŀո�
                if (start == 0) {
                    end++;
                    continue;
                }
                // �м�������ո�
                else if (end < len - 1 && chars[end + 1] == ' ') {
                    end++;
                    continue;
                }
                // ��β�ո�
                else if (end == len - 1) {
                    end++;
                    continue;
                }
            }
            chars[start] = chars[end];
            start++;
            end++;
        }
        // ��β��������
        end = start
                // ʹ end Ϊ���һλ��������
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
            // ����
            char leftC = chars[left];
            chars[left] = chars[right];
            chars[right] = leftC;

            left++;
            right--;
        }
    }
}
