package 代码随想录.数组;

public class 有序数组的平方 {

    public int[] sortedSquares(int[] nums) {
        int[] sum = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int newright = nums.length - 1;
        while (newright >= 0) {
            int ll = nums[left] * nums[left];
            int rr = nums[right] * nums[right];
            if (ll > rr) {
                sum[newright] = ll;
                left++;
                newright--;
            } else {
                sum[newright] = rr;
                right--;
                newright--;
            }
        }
        return sum;
    }
}
