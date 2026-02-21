package 代码面试经典150.位运算;

public class 只出现一次的数字III {

    public int[] singleNumber(int[] nums) {
        int ind=0;
        for(int num:nums)ind^=num;
        int index=0;
        while (index<32){
            if (((ind>>index)&1)==1)break;
            index++;
        }
        int res1=0,res2=0;
        for (int num:nums){
            if (((num>>index)&1)==1)res1^=num;
            else res2^=num;
        }
        return new int[]{res1,res2};
    }
}
