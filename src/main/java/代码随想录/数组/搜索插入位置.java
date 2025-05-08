package 代码随想录.数组;

public class 搜索插入位置 {

    public int searchInsert(int[] nums, int target) {
        int head=0;
        int tail=nums.length-1;

        while(head<=tail){
            int middle = head + (tail - head) / 2;
           /* if(nums[middle]==target){
                return middle;
            }*/
            if(nums[middle]>target){
                tail=middle-1;
            }
            if(nums[middle]<target){
                head=middle+1;
            }
        }
        return head;
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) {return new int[]{-1, -1};}
        int left=0;
        int right=nums.length-1;
        int res=-1;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(nums[mid]==target){
                res=mid;
                break;
            }
            if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }

        }

        if(res==-1){return new int[]{-1, -1};}
        left=res;
        right=res;

        while (left>0&&nums[left-1]==target){
            left--;
        }
        while (left>0&&nums[left+1]==target){
            right++;
        }
        return new int[]{left,right};
    }
}
