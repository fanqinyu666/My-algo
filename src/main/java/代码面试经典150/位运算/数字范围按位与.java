package 代码面试经典150.位运算;

public class 数字范围按位与 {
    public int rangeBitwiseAnd(int left, int right) {
        int dex = 0;
        for (int i = 31; i >= 0; i--) {
            if ((left >> i) != (right >> i)) {
                dex = i + 1;
                break;
            }
        }
        return (left >> dex) << dex;
    }
}
