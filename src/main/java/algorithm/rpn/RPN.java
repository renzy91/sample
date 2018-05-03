package algorithm.rpn;

import java.util.Stack;

/**
 * @author renzhiyong
 * @description:逆波兰计算器
 * @date 2018-05-03 22:35
 */
public class RPN {
    public static void main(String[] args) {
        String str = infix2Suffix("5+4*6/2+3+(4*5)/5");

        char[] chars = str.toCharArray();

        Stack<Double> stack = new Stack<>();

        for (char c : chars) {
            switch (c) {
                case '+':
                    stack.push(stack.pop() + stack.pop());break;
                case '-':
                    stack.push(- stack.pop() + stack.pop());break;
                case '*':
                    stack.push(stack.pop() * stack.pop());break;
                case '/':
                    stack.push(1 / stack.pop() * stack.pop());break;
                default:stack.push(Double.valueOf(c-'0'));
            }
        }

        System.out.println(stack.pop());

    }

    //中缀表达式转后缀表达式 eq://(1-2)*(4+5) ==> 12-45+*
    public static String infix2Suffix(String infix) {
        char[] chars = infix.toCharArray();

        StringBuilder suffix = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        int size;
        for (char c : chars) {
            switch (c) {
                case '+':
                case '-':
                    if (!stack.empty()) {
                        size = stack.size();
                        for (int i = 0; i < size; i++) {
                            if (stack.peek().equals('(')) {
                                break;
                            }
                            suffix.append(stack.pop());
                        }
                    }
                    stack.push(c);
                    break;
                case '*':
                case '/':
                    if (!stack.empty()) {
                        size = stack.size();
                        for (int i = 0; i < size; i++) {
                            if (!stack.peek().equals('/') && !stack.peek().equals('*')) {
                                break;
                            }
                            suffix.append(stack.pop());
                        }
                    }
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);break;
                case ')':
                    size = stack.size();
                    for (int i = 0; i < size; i++) {
                        if (stack.peek().equals('(')) {
                            stack.pop();
                            break;
                        }
                        suffix.append(stack.pop());
                    }
                    break;
                default: suffix.append(c);break;
            }
        }

        size = stack.size();
        for (int i = 0; i < size; i++) {
            suffix.append(stack.pop());
        }

        return suffix.toString();
    }

    
}
