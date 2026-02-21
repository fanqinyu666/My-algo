package 代码面试经典150.数组字符串;

import java.io.FileReader;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {

    public int romanToInt(String s) {
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int sum=0;
        for (int i=0;i<s.length();i++){
            //这里i+1的判断必须写道if里，否则就会丢失最后一个元素
            if(i+1<s.length()&&symbolValues.get(s.charAt(i))<symbolValues.get(s.charAt(i+1))){
                sum-=symbolValues.get(s.charAt(i));
            }else {
                sum+=symbolValues.get(s.charAt(i));
            }
        }
        return sum;
    }



}
