package 算法复习_随手练.小练习;

public class test {

    public int majorityElement(int[] nums) {
        int max=0;
        int pre=0;
        for (int i=0;i<nums.length;i++){
            if(max==0)pre=nums[i];
            if (pre==nums[i])max++;
            else max--;
        }
        return pre;
    }
    public void sortColors(int[] nums) {
        int l=0,i=0,r=nums.length-1;;
        while (i<=r){
            if(nums[i]==0){
                swap(nums,l,i);
                i++;
                l++;
            }else if(nums[i]==2){
                swap(nums,i,r);
                r--;
                // 注意：这里 i 不要自增！因为从右边交换过来的数还没经过检查，可能是 0 或 1
            }else {
                i++;
            }
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0&&nums[i] > nums[i + 1]) if (nums[i] > nums[i + 1])i--;
        int right = nums.length - 1;
        if (i>= 0) {
            while (right >= 0 && nums[i] >= nums[right])right--;
            swap(nums, i, right);
        }
        reverse(nums, i + 1);
    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }




}
