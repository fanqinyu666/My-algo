package 代码面试经典150.位运算;

public class 颠倒二进制位 {

    public int reverseBits(int n) {
        int res=0;
        for (int i = 0; i < 32; i++) {
            int bit=n>>i&1;
            int mid = bit << (31 - i);
            res=res|mid;
        }
        return res;
    }

}
