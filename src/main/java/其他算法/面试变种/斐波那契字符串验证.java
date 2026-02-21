package 其他算法.面试变种;
import java.math.BigInteger;

public class 斐波那契字符串验证 {

    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("112358"));      // true
        System.out.println(isAdditiveNumber("199100199"));   // true
        System.out.println(isAdditiveNumber("1023"));       // false
    }

    public static boolean isAdditiveNumber(String num) {
        int n = num.length();
        // 尝试前两个数字的所有可能长度组合
        // i 是第一个数字的结束索引，j 是第二个数字的结束索引
        for (int i = 1; i <= n / 2 + 1; i++) {
            for (int j = i + 1; n - j >= Math.max(i, j - i); j++) {
                if (isValid(i, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int i, int j, String num) {
        // 排除“0”开头的非零多位数（如 "01" 是非法的，但 "0" 合法）
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j - i > 1) return false;

        String sum;
        BigInteger num1 = new BigInteger(num.substring(0, i));
        BigInteger num2 = new BigInteger(num.substring(i, j));

        for (int start = j; start < num.length(); start += sum.length()) {
            // 计算下一次期待的和
            num2 = num2.add(num1);      // 现在的 num2 变成了之前的和
            num1 = num2.subtract(num1); // 现在的 num1 变成了之前的 num2
            sum = num2.toString();

            // 检查剩余字符串是否以该和开头
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}