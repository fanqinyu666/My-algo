package 代码随想录.数组;

import com.sun.jdi.connect.spi.Connection;

import java.util.Collections;

public class 寻找两个正序数组的中位数 {

    /*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left=0,right=nums1.length-1;


        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;
            //绳子完全在下面或者上面

            //num1的分割点i，如果等于0，说明绳子完全在下面
            if(i==0){
                //那就把左边设置为负无穷
                int left1=Integer.MIN_VALUE;
            }else {
                int left1=nums1[i-1];
            }
            //num1的分割点i，如果等于m，说明绳子完全在上面面
            if(i==m){

                int right1=Integer.MAX_VALUE;
            }else {
                int right1=nums1[i];
            }


            if(nums1[i-1]>nums2[j]){
                right=i-1;
            }
            if(nums2[j-1]>nums1[i]){
                left=i+1;
            }
            if(nums1[i-1]<=nums2[j]&&nums2[j-1]<=nums1[i]){
                if((m+n)%2==1){
                    return max(left1,left2);
                }

            }
        }
    }*/

}
