package by.i;

import java.util.Scanner;

public class K55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();

        int len = s.length();  // ��ȡ�ַ�������
        char[] chars = s.toCharArray();
        reverseString(chars, 0, len - 1);  // ��ת�����ַ���
        reverseString(chars, 0, n - 1);  // ��תǰһ���ַ�������ʱ���ַ�����ββ��0,n - 1
        reverseString(chars, n, len - 1);  // ��ת��һ���ַ�������ʱ���ַ�����ββ��n,len - 1

        System.out.println(chars);

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
