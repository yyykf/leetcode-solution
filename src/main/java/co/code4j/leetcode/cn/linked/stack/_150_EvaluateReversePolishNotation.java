package co.code4j.leetcode.cn.linked.stack;

import java.util.*;

/**
 * @Description
 * @Author yukf02
 * @Date 2023/11/11 16:02
 */
public class _150_EvaluateReversePolishNotation {

    public static void main(String[] args) {
        _150_EvaluateReversePolishNotation evaluator = new _150_EvaluateReversePolishNotation();

        // Output: 9
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Output 1: " + evaluator.evalRPN0(tokens1));
        System.out.println("Output 1: " + evaluator.evalRPN1(tokens1));

        // Output: 6
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Output 2: " + evaluator.evalRPN1(tokens2));

        // Output: 22
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Output 3: " + evaluator.evalRPN1(tokens3));

    }

    private int evalRPN0(String[] tokens) {

        Stack<Integer> numStack = new Stack<>();

        int num1;
        int num2;
        for (String token : tokens) {
            // 取出两个操作数进行计算
            if ("+".equals(token)) {
                num1 = numStack.pop();
                num2 = numStack.pop();
                numStack.push(num1 + num2);
            } else if ("-".equals(token)) {
                num1 = numStack.pop();
                num2 = numStack.pop();
                numStack.push(num2 - num1);
            } else if ("*".equals(token)) {
                num1 = numStack.pop();
                num2 = numStack.pop();
                numStack.push(num1 * num2);
            } else if ("/".equals(token)) {
                num1 = numStack.pop();
                num2 = numStack.pop();
                numStack.push(num2 / num1);
            } else {
                // 操作数，入栈
                numStack.push(Integer.valueOf(token));
            }
        }
        return numStack.peek();
    }

    private int evalRPN1(String[] tokens) {
        int[] numsArray = new int[tokens.length / 2 + 1];

        int index = 0;

        for (String token : tokens) {
            switch (token) {
                case "+" -> numsArray[index - 2] += numsArray[--index];
                case "-" -> numsArray[index - 2] -= numsArray[--index];
                case "*" -> numsArray[index - 2] *= numsArray[--index];
                case "/" -> numsArray[index - 2] /= numsArray[--index];
                default -> numsArray[index++] = Integer.parseInt(token);
            }
        }

        return numsArray[0];
    }
}
