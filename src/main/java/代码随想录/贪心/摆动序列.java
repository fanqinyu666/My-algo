package 代码随想录.贪心;

public class 摆动序列 {


    public int wiggleMaxLength2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int curDiff = 0;
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }


    public int wiggleMaxLength(int[] nums) {
        int num=0;
        int cur=0;
        int pre=0;
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i] - nums[i + 1];
            if ((cur > 0 && pre <= 0) || (cur < 0 && pre >= 0)) {
                //这里pre带有0，也就是平坡算最右边的，如果cur带有=0，那就留最左
                num++;
                pre = cur;
            }
        }
        return num;
    }
}
