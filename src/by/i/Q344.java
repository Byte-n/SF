package by.i;

/**
 * 344. ��ת�ַ���
 */
public class Q344 {
    public void reverseString(char[] s) {
        // ����ָ��
        int left = 0, right = s.length - 1;

        while (left < right) {
            // ����
            char leftC = s[left];
            s[left] = s[right];
            s[right] = leftC;

            left++;
            right--;
        }
    }
}
