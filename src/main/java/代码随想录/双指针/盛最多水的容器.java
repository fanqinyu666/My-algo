package 代码随想录.双指针;

public class 盛最多水的容器 {
    //双指针秒了

    //左边和右边哪个小就替换哪个
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=0;
        while(left<right){
            int h=Math.min(height[left],height[right]);
            int res=h*(right-left);
            max=Math.max(max,res);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

}
