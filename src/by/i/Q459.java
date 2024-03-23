package by.i;

/** 459. 重复的子字符串 */
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
        以 abacabac 为例
        其 next 数组为 [-1, 0, 0, 1, 0, 1, 2, 3]
        last = next[nextLen - 1] = 3;
        last = 3 表示在 abacabac 字符串前 索引0到6的字符组成的 子串 abacaba 中，相同的前后缀子串 最大长度为 3
        abacaba 的所有前后缀子串 如下：
        前缀         后缀
        a	        a       这一对相同
        ab	        ba
        aba	        aba     这一对相同
        abac	    caba
        abaca	    acaba
        abacab	    bacaba
         */

        /*
        因为上面是 next -1 的方式，所以，还需执行一次 KMP 从 last 处开始的判断 (不是next-1则不需要此步骤)
        即 在 chars[nextLen - 1] 位置匹配失败时，模式串 回退到 next[nextLen-1] 位置继续 和 搜索串 进行匹配。
        继续以上面的例子说明，last = next[nextLen-1] = 3;
        所以需要再判断 chars[nextLen - 1] == chars[last]
         */
        boolean b = chars[nextLen - 1] == chars[last];
        if (!b) {
            return false;
        }
        /*
         * 为什么需要 +1，因为这里是 next-1 的方式
         * 如果是 getNext2 函数，也需要 +1 ，因为 next数组前加了一个虚拟的空字符，nextLen为charsLen + 1
         * */
        last = last + 1;
        return nextLen % (nextLen - last) == 0;
    }

    // next -1的方式
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

    // next 0 的方式
    public static int[] getNext2(String s) {
        int len = s.length();
        // 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        // 构造 next 数组过程，j从0开始(空格)，i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            // 匹配不成功，j回到前一位置 next 数组所对应的值
            while (j > 0 && chars[i] != chars[j + 1]) j = next[j];
            // 匹配成功，j往后移
            if (chars[i] == chars[j + 1]) j++;
            // 更新 next 数组的值
            next[i] = j;
        }
        return next;
    }

    // indexOf API方式
    public boolean repeatedSubstringPattern2(String s) {
        /*
        假设 s 的字符串为 abc abc (空格是为了好一眼看清楚，实际没有空格)
        s + s = abc abc abc abc
        从 s + s 索引 1 的位置开始查找，一定能匹配到 s
        abc abc abc abc 去掉前后的 abc，中间的部分和 s 本身相同。
        如果 s 为 abc abc d
        s + s = abc abc d abc abc d 则从索引1开始就找不到 s
         */
        return (s + s).indexOf(s, 1) != s.length();
    }
}
