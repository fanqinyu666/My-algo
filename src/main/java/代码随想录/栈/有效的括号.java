package 代码随想录.栈;

import java.util.Stack;

public class 有效的括号 {
    public boolean isValid(String s) {
        if (s.length()%2==1){
            return false;
        }

        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]=='('){
                stack.push(')');
            }else if(charArray[i]=='['){
                stack.push(']');
            }else if(charArray[i]=='{'){
                stack.push('}');
            }

            else if(charArray[i]==')'){
                if(stack.size()==0||stack.pop()!=charArray[i]){
                    return false;
                }
            }else if(charArray[i]==']'){
                if(stack.size()==0||stack.pop()!=charArray[i]){
                    return false;
                }
            }
            else if(charArray[i]=='}'){
                if(stack.size()==0||stack.pop()!=charArray[i]){
                    return false;
                }
            }
        }
        if(stack.size()!=0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        有效的括号 有效的括号 = new 有效的括号();
        有效的括号.isValid2("()");
    }


    public boolean isValid2(String s) {
        //对，如果奇数直接返回了
        if (s.length()%2==1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {

            if(charArray[i]=='('||charArray[i]=='['||charArray[i]=='{'){
                stack.push(charArray[i]);
                continue;
            }

            if(charArray[i]==')'){
                if(!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if (peek.equals('(')) {
                        stack.pop();
                        continue;
                    }
                }
                return false;

            }else if(charArray[i]==']'){
                if(!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if (peek.equals('[')) {
                        stack.pop();
                        continue;
                    }
                }
                return false;
            }else if(charArray[i]=='}'){
                if(!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if (peek.equals('{')) {
                        stack.pop();
                        continue;
                    }
                }
                return false;
            }

        }
        if(stack.size()==0){
            return true;
        }
        return false;
    }







}
