package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 电话号码的字母组合 {
    LinkedList<String> path = new LinkedList<>();
    StringBuilder temp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return path;
        }
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        return path;
    }
    //1.假如传入23
    private void backTracking(String digits,String[] numString, int sum) {
        //sum告诉你，现在遍历到字符串的哪一个位置了
        if(sum==digits.length()){
            path.add(temp.toString());
            return;
        }
        //2.digits.charAt(sum)，sum=0，字符串下标为0处是字符串2，
        //3.给我们的数字是字符串类型的，我们减去字符串’0‘，得到的是int类型的ascll码相减，字符串2变成数字2
        //4.数字2作为下标去搜寻字符串数字，得到"abc"字符串
        String str = numString[digits.charAt(sum) - '0'];

        //这是第一层，abc，循环三次
        for (int i = 0; i < str.length(); i++) {

            temp.append(str.charAt(i));//把a先想入结果集，这样用stringbuilder当结果集，很好，可以存入取出
            //递归，处理下一层，sum+1=1，下一层得到下标为1的3
            backTracking(digits, numString, sum + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }

}
