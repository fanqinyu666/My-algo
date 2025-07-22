package 代码随想录.堆_优先队列;

/**
 * @author 20520
 */
public class 数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        track(nums,0,nums.length-1,nums.length-k);
        return nums[nums.length-k];
    }

    private void track(int[] nums,int left,int right,int k){
        if(left>=right)return;
        int index = shaobin(nums, left, right);
        if(index==k){
            return;
        }
        if(index<k){
            track(nums,index+1,right,k);
        }else{
            track(nums,left,index-1,k);
        }
    }

    //快排必须，实现分割函数
    private int shaobin(int[] nums,int left,int right){
        int index = (left + right) / 2;
        swap(nums,index,left);
        int l=left,r=right;
        while (l<r){
            while (l < r && nums[r] >= nums[left])
                r--;
            while (l < r && nums[l] <= nums[left])
                l++;
            swap(nums,l,r);
        }
        swap(nums,l,left);
        return l;
    }

    private void swap(int[] nums,int left,int right){
        int tmp = nums[left];
        nums[left]=nums[right];
        nums[right]= tmp;
    }
}
