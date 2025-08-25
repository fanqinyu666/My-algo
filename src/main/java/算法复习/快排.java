package 算法复习;

public class 快排 {

    public void quickSort(int[] nums,int left,int right){
        if(left>=right)return;
        int shaobin = shaobin(nums, left, right);
        quickSort(nums,left,shaobin-1);
        quickSort(nums,shaobin+1,right);
    }

    public int shaobin(int[] nums,int left,int right){

        int yea=(left+right)/2;//得到基准数
        swap(nums,left,yea);//交换到边边
        int l=left,r=right;

        while (l<r){
            //找左边比我大的，所以规则是比我小
            while (l<r&&nums[yea]>=nums[l])l++;
            while (l<r&&nums[yea]<=nums[r])r--;
            swap(nums,l,r);
        }
        swap(nums,yea,l);//l和r此时一样，换了就行
        return l;//返回，这里返回的下标其实是l
    }

    public void swap(int[] nums,int left,int right){
        int num = nums[left];
        nums[left]=nums[right];
        nums[right]= num;
    }

}
