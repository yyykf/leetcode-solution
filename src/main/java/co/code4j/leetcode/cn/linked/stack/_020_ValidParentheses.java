package co.code4j.leetcode.cn.linked.stack;

import java.util.*;

/**
 * @Description
 * @Author yukf02
 * @Date 2023/11/12 17:58
 */
public class _020_ValidParentheses {

    public static void main(String[] args) {
        _020_ValidParentheses validator = new _020_ValidParentheses();
        String s1 = "()";
        System.out.println(validator.isValid0(s1)); // Output: true
        System.out.println(validator.isValid1(s1)); // Output: true
        System.out.println(validator.isValid2(s1)); // Output: true

        String s2 = "()[]{}";
        System.out.println(validator.isValid0(s2)); // Output: true
        System.out.println(validator.isValid1(s2)); // Output: true
        System.out.println(validator.isValid2(s2)); // Output: true

        String s3 = "(())[{)]";
        System.out.println(validator.isValid0(s3)); // Output: false
        System.out.println(validator.isValid1(s3)); // Output: false
        System.out.println(validator.isValid2(s3)); // Output: false
    }

    private boolean isValid0(String s) {
        Stack<Character> parenthesesStack = new Stack<>();
        Map<Character, Character> parenthesesMap = Map.of(')', '(', ']', '[', '}', '{');
        Set<Character> leftParentheses = Set.copyOf(parenthesesMap.values());

        for (char c : s.toCharArray()) {
            if (leftParentheses.contains(c)) {
                parenthesesStack.push(c);
                continue;
            }

            if (parenthesesStack.isEmpty() || !parenthesesStack.pop().equals(parenthesesMap.get(c))) {
                return false;
            }
        }

        return parenthesesStack.isEmpty();
    }

    private boolean isValid1(String s) {
        Stack<Character> parenthesesStack = new Stack<>();

        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if ('(' == c || '[' == c || '{' == c) {
                parenthesesStack.push(c);
                continue;
            }

            if (parenthesesStack.isEmpty()) {
                return false;
            }

            switch (c) {
                case ')' -> {
                    if (!parenthesesStack.pop().equals('(')) {
                        return false;
                    }
                }
                case ']' -> {
                    if (!parenthesesStack.pop().equals('[')) {
                        return false;
                    }
                }
                case '}' -> {
                    if (!parenthesesStack.pop().equals('{')) {
                        return false;
                    }
                }
                default -> {
                    return false;
                }

            }
        }

        return parenthesesStack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> parenthesesStack = new Stack<>();

        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if ('(' == c || '[' == c || '{' == c) {
                parenthesesStack.push(c);
                continue;
            }

            if (parenthesesStack.isEmpty()) {
                return false;
            }

            char top = parenthesesStack.pop();
            if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                return false;
            }
        }

        return parenthesesStack.isEmpty();
    }
}
