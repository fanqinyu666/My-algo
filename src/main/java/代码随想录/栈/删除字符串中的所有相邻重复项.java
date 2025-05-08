package 代码随想录.栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {
        删除字符串中的所有相邻重复项 s = new 删除字符串中的所有相邻重复项();
        s.removeDuplicates("abbaca");
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.size() != 0 && stack.peek() != c) {
                stack.push(c);
                continue;
            } else if (stack.size() != 0) {
                stack.pop();
            } else if (stack.size() == 0) {
                stack.push(c);
            }

        }
        char[] chars = new char[stack.size()];
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            Character pop = stack.pop();
            chars[i]=pop;
        }

        String string=new String(chars);
        StringBuilder stringBuilder=new StringBuilder(string);
        stringBuilder.reverse();
        String string1 = stringBuilder.toString();
        return string1;
    }


    public String removeDuplicates2(String s) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }
    public String removeDuplicates3(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(!stack.isEmpty()){
                if(stack.peek()==c){
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);

        }
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }



}
