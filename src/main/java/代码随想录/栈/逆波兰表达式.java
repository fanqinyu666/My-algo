package 代码随想录.栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 逆波兰表达式 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String s : tokens) {
            if ("+".equals(s)) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        逆波兰表达式 逆波兰表达式 = new 逆波兰表达式();
        逆波兰表达式.decodeString("100[leetcode]");
    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c==']'){
                StringBuilder stringBuilder = new StringBuilder();
                while (stack.peek()!='[') {
                    stringBuilder.append(stack.pop());
                }
                stack.pop();
                StringBuilder stringBuilder1 = new StringBuilder();
                while (!stack.isEmpty()&&48<=stack.peek()&&stack.peek()<=59) {
                    Character pop = stack.pop();
                    stringBuilder1.append(pop);
                }


                System.out.println("走到这一步了");
                StringBuilder reverse1 = stringBuilder1.reverse();
                int i1 = Integer.parseInt(reverse1.toString());

                StringBuilder reverse = stringBuilder.reverse();
                for (int j = 0; j < i1; j++) {
                    for (int k = 0; k < reverse.length(); k++) {
                        stack.push(reverse.charAt(k));
                    }
                }
                continue;
            }
            stack.push(c);
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }

        return res.reverse().toString();

    }
}
