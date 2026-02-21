package 代码面试经典150.栈;

import java.util.Deque;
import java.util.LinkedList;

public class 基本计算器 {

    public int calculate(String s) {
        Deque<Integer> deque = new LinkedList<>();
        //这里是为了给他一个处理正负，不会影响数字
        deque.push(1);
        //这个值是正负，默认为1
        int pre=1;
        int res = 0;
        for(int i=0;i<s.length();){
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                pre = deque.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                pre = -deque.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                deque.push(pre);
                i++;
            } else if (s.charAt(i) == ')') {
                deque.pop();
                i++;
            } else {
                long num = 0;
                //是数字，当第一个不是数字的时候结束
                //这里数字全都用s.char获取，而不是栈内获取，不用担心正负号影响
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }

                res += pre * num;
            }
        }
        return res;
    }

}
