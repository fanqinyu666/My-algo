package 面试经典150.数组字符串;

public class 最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean is=false;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j <strs.length ; j++) {
                if (i > strs[j].length()-1) {
                    is=true;
                    break;
                }
                if(strs[0].charAt(i)!=strs[j].charAt(i)){
                    is=true;
                    break;
                }
            }
            if (is){
                break;
            }
            stringBuilder.append(strs[0].charAt(i));
        }
        return stringBuilder.toString();
    }

}
