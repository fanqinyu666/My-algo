package 代码面试经典150.位运算;

public class 位1的个数 {


    public int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            if ((n&1)==1)count++;
            n=n>>1;
        }
        return count;
    }

}
