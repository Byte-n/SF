package by.i;

import java.util.HashMap;

public class Q202 {
    public static void main(String[] args) {
        isHappy(999999999);

    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        int cur = n;
        while (cur != 1 && !map.containsKey(cur)) {
            map.put(cur, true);
            cur = sum(cur);
        }

        return cur == 1;
    }

    private static int sum(int n) {
        int res = 0;

        while (n != 0) {
            // 获取最后一位数字
            int temp = n % 10;
            res += (temp * temp);
            // 抛弃掉最后一位数字
            n = n / 10;
        }

        return res;
    }

    /*快慢指针*/
    public boolean isHappy2(int n) {
        int slow = n;
        int fast = n;
        while (true) {
            slow = sum(slow);

            fast = sum(fast);
            fast = sum(fast);
            if (slow == 1 || fast == 1) {
                return true;
            }
            if (slow == fast) {
                return false;
            }

        }
    }
}
