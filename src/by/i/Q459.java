package by.i;

/** 459. �ظ������ַ��� */
public class Q459 {
    public static void main(String[] args) {
        // boolean abab = repeatedSubstringPattern("abacabad");
        boolean abab = repeatedSubstringPattern("abab");

        System.out.println(abab);
    }

    // KMP
    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        int[] next = getNext(chars);
        // int[] next2 = getNext2(s);
        int nextLen = next.length;
        int last = next[nextLen - 1];
        if (last == -1) {
            return false;
        }
        /*
        �� abacabac Ϊ��
        �� next ����Ϊ [-1, 0, 0, 1, 0, 1, 2, 3]
        last = next[nextLen - 1] = 3;
        last = 3 ��ʾ�� abacabac �ַ���ǰ ����0��6���ַ���ɵ� �Ӵ� abacaba �У���ͬ��ǰ��׺�Ӵ� ��󳤶�Ϊ 3
        abacaba ������ǰ��׺�Ӵ� ���£�
        ǰ׺         ��׺
        a	        a       ��һ����ͬ
        ab	        ba
        aba	        aba     ��һ����ͬ
        abac	    caba
        abaca	    acaba
        abacab	    bacaba
         */

        /*
        ��Ϊ������ next -1 �ķ�ʽ�����ԣ�����ִ��һ�� KMP �� last ����ʼ���ж� (����next-1����Ҫ�˲���)
        �� �� chars[nextLen - 1] λ��ƥ��ʧ��ʱ��ģʽ�� ���˵� next[nextLen-1] λ�ü��� �� ������ ����ƥ�䡣
        ���������������˵����last = next[nextLen-1] = 3;
        ������Ҫ���ж� chars[nextLen - 1] == chars[last]
         */
        boolean b = chars[nextLen - 1] == chars[last];
        if (!b) {
            return false;
        }
        /*
         * Ϊʲô��Ҫ +1����Ϊ������ next-1 �ķ�ʽ
         * ����� getNext2 ������Ҳ��Ҫ +1 ����Ϊ next����ǰ����һ������Ŀ��ַ���nextLenΪcharsLen + 1
         * */
        last = last + 1;
        return nextLen % (nextLen - last) == 0;
    }

    // next -1�ķ�ʽ
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

    // next 0 �ķ�ʽ
    public static int[] getNext2(String s) {
        int len = s.length();
        // ԭ���Ӹ��ո�(�ڱ�)��ʹ�±��1��ʼ������j��0��ʼ��Ҳ���ó�ʼ����
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        // ���� next ������̣�j��0��ʼ(�ո�)��i��2��ʼ
        for (int i = 2, j = 0; i <= len; i++) {
            // ƥ�䲻�ɹ���j�ص�ǰһλ�� next ��������Ӧ��ֵ
            while (j > 0 && chars[i] != chars[j + 1]) j = next[j];
            // ƥ��ɹ���j������
            if (chars[i] == chars[j + 1]) j++;
            // ���� next �����ֵ
            next[i] = j;
        }
        return next;
    }

    // indexOf API��ʽ
    public boolean repeatedSubstringPattern2(String s) {
        /*
        ���� s ���ַ���Ϊ abc abc (�ո���Ϊ�˺�һ�ۿ������ʵ��û�пո�)
        s + s = abc abc abc abc
        �� s + s ���� 1 ��λ�ÿ�ʼ���ң�һ����ƥ�䵽 s
        abc abc abc abc ȥ��ǰ��� abc���м�Ĳ��ֺ� s ������ͬ��
        ��� s Ϊ abc abc d
        s + s = abc abc d abc abc d �������1��ʼ���Ҳ��� s
         */
        return (s + s).indexOf(s, 1) != s.length();
    }
}
