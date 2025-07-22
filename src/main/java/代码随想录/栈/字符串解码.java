package 代码随想录.栈;

import java.util.Stack;

public class 字符串解码 {

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c==']') {





            }
            stack.push(c);
        }
        return sb.toString();
    }
}
