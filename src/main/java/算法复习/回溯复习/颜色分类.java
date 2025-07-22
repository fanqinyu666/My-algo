package 算法复习.回溯复习;

public class 颜色分类 {

    public void sortColors(int[] nums) {

        int fast = 0, slow = 0;
        for (;fast < nums.length;fast++) {
            if(nums[fast] == 0) {
                int num = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = num;
                slow++;

            }
        }
        fast=0;
        for (;fast < nums.length;fast++) {
            if(nums[fast] == 1) {
                int num = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = num;
                slow++;
            }
        }
        fast=0;
        for (;fast < nums.length;fast++) {
            if(nums[fast] == 2) {
                int num = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = num;
                slow++;
            }
        }

    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        slow = nums[0];
        fast = nums[nums[0]];
        while (true) {
            fast=nums[nums[fast]];
            slow=nums[slow];
            if (fast == slow) {
                break;
            }
        }
        slow=0;
        while (true) {
            fast=nums[fast];
            slow=nums[slow];
            if (fast == slow) {
                break;
            }
        }
        return slow;
    }

    public void nextPermutation(int[] nums){





    }

























}
