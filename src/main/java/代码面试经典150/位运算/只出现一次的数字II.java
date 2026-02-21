package 代码面试经典150.位运算;

public class 只出现一次的数字II {
    //天才！
    public int singleNumber(int[] nums) {
        int res=0;
        //int是32位的数字
        for (int i = 0; i < 32; i++) {
            int count=0;
            for (int j = 0; j < nums.length; j++)count+=(nums[j]>>i)&1;
            if (count%3!=0)res=res|(1<<i);
        }
        return res;
    }

}
