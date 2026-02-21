package 代码面试经典150.数组字符串;

public class 轮转数组 {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums,int left,int right){
        while (left<right){
            int l = nums[left];
            nums[left]=nums[right];
            nums[right]=l;
            left++;
            right--;
        }
    }

}
