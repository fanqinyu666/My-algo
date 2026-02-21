package 代码面试经典150.数组字符串;

import java.util.logging.Level;

public class 合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l=m+n-1;
        while (m>0&&n>0){
            if(nums1[m-1]<nums2[n-1]){
                nums1[l]=nums2[n-1];
                l--;
                n--;
            }else {
                nums1[l]=nums1[m-1];
                l--;
                m--;
            }
        }
        while (n > 0) {
            nums1[l] = nums2[n - 1];
            l--;
            n--;
        }
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index=m+n-1;
        while (m>0&&n>0){
            if (nums1[m-1]>nums2[n-1]) {
                nums1[index--]=nums1[m-1];
                m--;
            }else {
                nums1[index--]=nums2[n-1];
                n--;
            }
        }
        while (n > 0) {
            nums1[index--] = nums2[n - 1];
            n--;
        }
    }

}
