package 面试经典150.双指针;

public class 两数之和II输入有序数组 {

    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        while (l<r){
            if(numbers[l]+numbers[r]>target){
                r--;
            }else if(numbers[l]+numbers[r]<target){
                l++;
            }else {
                return new int[]{l+1,r+1};
            }
        }
        return null;
    }

}
