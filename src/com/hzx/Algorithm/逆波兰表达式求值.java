package com.hzx.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 实现逆波兰表达式对后缀表达式的求值
 */
public class 逆波兰表达式求值 {
    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> rpnList = new ArrayList<>();
        Collections.addAll(rpnList, suffixExpression.split("\\s+"));
        int result = calculate(rpnList);
        System.out.println(result);
    }

    private static int calculate(List<String> list) {
        Stack<Integer> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("\\d+")) {
                // 检查是否是数字
                stack.push(Integer.valueOf(item));
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                int res = switch (item) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default -> throw new RuntimeException("无效运算符");
                };
                stack.push(res);
            }
        }
        return stack.pop();


    }
}
