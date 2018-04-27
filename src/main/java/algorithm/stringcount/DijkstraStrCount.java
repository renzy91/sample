package algorithm.stringcount;

import java.util.Stack;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-26 16:53
 *
 *  1.将操作数压入操作数栈
 *  2.将运算符压入运算符栈
 *  3.忽略左括号
 *  4.遇到右括号时，弹出一个运算符，弹出所需数量的操作数，并将运算符和操作数的结果压入操作数栈中
 *  注：表达式中，括号不能省略。
 */
public class DijkstraStrCount {
    public static void main(String[] args) {
        String str = "(1+((2+3)*(4+5)))";
        char[] chars = str.toCharArray();

        Stack<Character> ops = new Stack<>();
        Stack<Integer> val = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                    ops.push(chars[i]);break;
                case '(' : break;
                case ')' : {
                    Integer v = val.pop();
                    Character op = ops.pop();
                    switch (op) {
                        case '+' : v = v + val.pop(); break;
                        case '-' : v = v - val.pop(); break;
                        case '*' : v = v * val.pop(); break;
                        case '/' : v = v / val.pop(); break;
                    }
                    val.push(v);
                } break;
                default: val.push(Integer.valueOf("" + chars[i]));
            }
        }

        System.out.println(val.pop());

    }
}
