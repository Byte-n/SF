package by.i;

import java.util.Stack;

public class Q1047 {
    public static void main(String[] args) {
        String abbaca = removeDuplicates("abbaca");
        System.out.println("abbaca = " + abbaca);
    }

    // ˫ָ��
    public static String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        int left = -1, right = 0;
        while (right < chars.length) {
            // ��ʼ״̬����������ֵ����ȣ��� right ��ֵ�����Ƶ� left+1 λ��
            if (left == -1 || chars[left] != chars[right]) {
                left++;
                chars[left] = chars[right];
            } else {
                left--;
            }
            right++;
        }
        return String.valueOf(chars, 0, left + 1);
    }

    // ջ
    public static String removeDuplicates2(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < chars.length) {
            char c = chars[index++];
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            Character peek = stack.peek();
            if (peek == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        chars = new char[stack.size()];
        index = 1;
        while (!stack.isEmpty()) {
            chars[stack.size() - (index)] = stack.pop();
        }
        return new String(chars);
    }
}
