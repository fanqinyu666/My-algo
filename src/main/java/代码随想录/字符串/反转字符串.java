package 代码随想录.字符串;

public class 反转字符串 {
    public static void main(String[] args) {
        反转字符串 反转字符串 = new 反转字符串();
    }
    public String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder reverse = stringBuilder.reverse();
        return reverse.toString();
    }

    public String reverseStr3(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i+=2*k) {
            if(s.length()-i>=2*k){
                String substring = s.substring(i, i +k);
                StringBuilder reverse = new StringBuilder(substring).reverse();
                stringBuilder.append(reverse);
            }else if(k<=s.length()-i&&s.length()-i<2*k){
                String substring = s.substring(i, i + k);
                StringBuilder reverse = new StringBuilder(substring).reverse();
                stringBuilder.append(reverse);
                stringBuilder.append(s.substring(i+k,s.length()));

            }else if(s.length()-i<k){
                String substring = s.substring(i);
                StringBuilder reverse = new StringBuilder(substring).reverse();
                stringBuilder.append(reverse);
            }
        }
        return stringBuilder.toString();
    }

    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int start = 0;

        for (int i = 0; i < length; i += 2 * k) {
            StringBuilder temp = new StringBuilder();
            if (i + k > length) {
                temp.append(s.substring(i));
                StringBuilder reverse = temp.reverse();
                sb.append(reverse);
            } else if (i + 2 * k > length && i + k < length) {
                temp.append(s.substring(i, i + k));
                StringBuilder reverse = temp.reverse();
                sb.append(reverse);
                sb.append(s.substring(i + k, length));
            } else {
                temp.append(s.substring(i, i + k));
                StringBuilder reverse = temp.reverse();
                sb.append(reverse);
                sb.append(s.substring(i + k, i + 2 * k));

            }
        }
        return sb.toString();
    }
}
