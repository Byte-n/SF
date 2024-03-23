package by.i;

import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;

/** 20. 有效的括号 */
public class Q20 {
    public static void main(String[] args) {
        boolean valid = isValid("(]");
        System.out.println(valid);
    }

    static final HashMap<Character, Character> map = new HashMap<Character, Character>() {{
        put('}', '{');
        put(']', '[');
        put(')', '(');
    }};

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        // 如果在力扣里面，这里报错，就在最上面加入这句导入： import java.util.Collection;
        Collection<Character> values = map.values();
        int i = 0;
        while (i < chars.length) {
            char c = chars[i++];
            // 左括号
            if (values.contains(c)) {
                stack.push(c);
                continue;
            }
            // 右括号
            if (stack.isEmpty()) {
                return false;
            }
            Character pop = stack.pop();
            if (map.get(c) != pop) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
