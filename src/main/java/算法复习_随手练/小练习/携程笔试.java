package 算法复习_随手练.小练习;

import java.util.Queue;
import java.util.Scanner;

public class 携程笔试 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLong()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            long a = in.nextLong();
            long b = in.nextLong();
            System.out.println(res(a,b));
        }
    }
    //读错题了，这题其实已经出来了
    public static long res(long n,long m){
        if(n<=2)return -1;

        //n是基数
        if (n%2==1) {
            //这是的i*2+1=n,所以我们要专门-1个，
            long i = n/2;
            while (((n - i * 2) / 3) % m == 0)i--;
            long i1 = (n - (i * 2)) / 3;
            return i1;
        }else {
            //可以被整除
            long i = n / 2;
            if (i%m==0) {
                return i;
            }else {
                while (((n - i * 2) / 3) % m == 0)i--;
                long i1 = (n - (i * 2)) / 3;
                return i1+i;
            }
        }

    }

    public static int solve(int n, int m) {
        if (n % 2 == 0)return (n / 2) - 1;
        else {
            if (n < m) return -1;
            return 1 + (n - m) / 2;
        }
    }

}
