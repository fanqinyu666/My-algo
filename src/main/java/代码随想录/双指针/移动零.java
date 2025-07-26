package 代码随想录.双指针;

public class 移动零 {
    public void moveZeroes(int[] nums) {
        int left=0;
        int right=0;
        while (right<nums.length){
            if(nums[right]!=0){
                int num = nums[left];
                nums[left]=nums[right];
                nums[right]=num;
                left++;
            }
            right++;
        }
    }
}
