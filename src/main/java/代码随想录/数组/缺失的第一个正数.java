package 代码随想录.数组;

public class 缺失的第一个正数 {

    public static void main(String[] args) {
        缺失的第一个正数 s = new 缺失的第一个正数();
        s.firstMissingPositive2(new int[]{-1,4,2,1,9,10});
    }
    public int firstMissingPositive(int[] nums) {
        for (int i=0;i<nums.length;i++){
            //nums[i]!=nums[nums[i]-1]是避免死循环，如果有两个1，就会相互一直交换
            while (0<nums[i]&&nums[i]<nums.length && nums[i]!=nums[nums[i]-1]){
                //交换
                int num = nums[i];
                nums[i]= nums[num-1];
                nums[num-1]=num;
            }
        }

        for (int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }



    public int firstMissingPositive2(int[] nums) {

        for (int i=0;i<nums.length;i++){
            //原本的判断条件nums[i]!=i-1,容易出现死循环，11一直重复
            //while (nums[i]!=i-1&&nums[i]!=nums[nums[i-1]])
            while (0<nums[i]&&nums[i]<nums.length&&nums[i]!=nums[nums[i]-1]) {
                int num = nums[i];
                //这里和谁交换元素也是核心
                nums[i]= nums[num-1];
                nums[num-1]=num;
            }
        }
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }



}
