package 代码面试经典150.栈;

import java.util.Stack;

public class 有效的括号 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.isEmpty())return true;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
                continue;
            }
            if(c==')'){
                if (stack.isEmpty())return false;
                if (stack.pop()!='(')return false;
            }
            if(c==']'){
                if (stack.isEmpty())return false;
                if (stack.pop()!='[')return false;
            }
            if(c=='}'){
                if (stack.isEmpty())return false;
                if (stack.pop()!='{')return false;
            }
        }
        if(stack.isEmpty())return true;
        return false;
    }
}
