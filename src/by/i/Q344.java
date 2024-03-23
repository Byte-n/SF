package by.i;

/**
 * 344. 反转字符串
 */
public class Q344 {
    public void reverseString(char[] s) {
        // 左右指针
        int left = 0, right = s.length - 1;

        while (left < right) {
            // 交换
            char leftC = s[left];
            s[left] = s[right];
            s[right] = leftC;

            left++;
            right--;
        }
    }
}
