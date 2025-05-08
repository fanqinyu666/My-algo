package 代码随想录.贪心;

public class 最大子序和 {

    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            count+=nums[i];
            max= Math.max(count, max);
            if(count<0){
                count=0;
            }
        }
        return max;
    }

    public int maxSubArra2y(int[] nums) {
        int max = Integer.MIN_VALUE;
        int total=0;
        int left=0,right=0;
        for(right=0;right<nums.length;right++){
            total+=nums[right];
            max=Math.max(max,total);
            while (total<0&&left<=right){
                total-=nums[left];
                left++;
            }
        }
        return max;
    }

}
