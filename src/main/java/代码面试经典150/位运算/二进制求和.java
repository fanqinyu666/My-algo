package 代码面试经典150.位运算;

import java.util.Stack;

public class 二进制求和 {

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int sc=0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            if(i>=0)sc+=a.charAt(i)=='0'?0:1;
            if(j>=0)sc+=b.charAt(j)=='0'?0:1;
            stringBuilder.append(sc%2);
            sc=sc/2;
        }
        if(sc!=0)stringBuilder.append(sc);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }


    public String addBinary2(String a, String b) {
        boolean isTrue = false;
        Stack<Integer> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        StringBuilder aa = new StringBuilder(a);
        StringBuilder bb = new StringBuilder(b);

        while (!aa.isEmpty() || !bb.isEmpty()) {
            int inta = 0;
            if (!aa.isEmpty()) {
                inta = aa.charAt(aa.length() - 1) - '0';
                aa.deleteCharAt(aa.length() - 1);
            }
            int intb = 0;
            if (!bb.isEmpty()) {
                intb = bb.charAt(bb.length() - 1) - '0';
                bb.deleteCharAt(bb.length() - 1);
            }

            int sum = inta + intb + (isTrue ? 1 : 0);

            if (sum == 0) {
                stack.push(0);
                isTrue = false;
            } else if (sum == 1) {
                stack.push(1);
                isTrue = false;
            } else if (sum == 2) {
                stack.push(0);
                isTrue = true;
            } else if (sum == 3) {
                stack.push(1);
                isTrue = true;
            }

        }
        if (isTrue) stack.push(1);
        while (!stack.isEmpty()) stringBuilder.append(stack.pop());
        return stringBuilder.toString();
    }


}
