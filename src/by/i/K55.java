package by.i;

import java.util.Scanner;

public class K55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();

        int len = s.length();  // 获取字符串长度
        char[] chars = s.toCharArray();
        reverseString(chars, 0, len - 1);  // 反转整个字符串
        reverseString(chars, 0, n - 1);  // 反转前一段字符串，此时的字符串首尾尾是0,n - 1
        reverseString(chars, n, len - 1);  // 反转后一段字符串，此时的字符串首尾尾是n,len - 1

        System.out.println(chars);

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
