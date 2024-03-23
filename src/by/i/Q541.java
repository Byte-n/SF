package by.i;

/**
 * 541. ��ת�ַ��� II
 */
public class Q541 {
    public static void main(String[] args) {
        String abcdefg = reverseStr("abcdefg", 2);
        System.out.println("abcdefg = " + abcdefg);
    }

    public static String reverseStr(String s, int k) {
        int k2 = 2 * k;
        char[] chars = s.toCharArray();
        int len = chars.length;
        // ��Ҫѭ���Ĵ���
        int total = (len / k2)
                // �κβ�������������� +1
                + (len % k2 == 0 ? 0 : 1);
        // ����
        for (int i = 1; i <= total; i++) {
            int start = (i - 1) * k2;
            int end = Math.min(len, start + k);
            reverseString(chars, start, end - 1);
        }
        return String.valueOf(chars);
    }

    // ��ת chars left �� right ֮����ַ�
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
