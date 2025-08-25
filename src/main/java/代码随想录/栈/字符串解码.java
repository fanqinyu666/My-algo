package 代码随想录.栈;

import java.util.Stack;

public class 字符串解码 {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(s.charAt(i)!=']'){
                stack.add(s.charAt(i));
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (stack.peek()!='[') {
                //找到左括号前，一直弹出
                stringBuilder.append(stack.pop());
            }
            //一定要反转
            StringBuilder reverse = stringBuilder.reverse();
            //弹出左括号
            stack.pop();

            StringBuilder stringBuilder1 = new StringBuilder();
            while (!stack.isEmpty()&&'0'<=stack.peek()&&stack.peek()<='9') {
                Character pop = stack.pop();
                stringBuilder1.append(pop);
            }
            //得到数字后一定要反转
            StringBuilder reverse1 = stringBuilder1.reverse();
            int i1 = Integer.parseInt(reverse1.toString());

            for (int j = 0; j < i1; j++) {
                for (int k = 0; k < reverse.length(); k++) {
                    stack.push(reverse.charAt(k));
                }
            }
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
