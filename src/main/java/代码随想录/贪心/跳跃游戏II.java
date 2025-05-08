package 代码随想录.贪心;

public class 跳跃游戏II {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int cover=0;
        //当前节点覆盖范围
        int temp =0;
        //下一个节点的覆盖范围
        int result=0;
        //记录具体跳了几步
        for (int i = 0; i <=cover&&i<=nums.length-1; i++) {
            //关键重点  i<=cover
            temp =Math.max(i+nums[i],temp );
            //更新覆盖范围
            if(i==cover){
                //未到终点
                if(cover<nums.length-1){
                    result++;
                    cover=temp;
                }else {
                    break;
                }
            }
        }
        return result;
    }



    public int jump2(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int cover=0;
        int temp =0;
        int result=0;
        for (int i = 0; i <=cover; i++) {
            cover = Math.max(i + nums[i], cover);
            while (temp<=cover) {

            }
            result++;
        }


        return result;
    }
}
