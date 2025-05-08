package 代码随想录.双指针;
import 代码随想录.链表.ListNode;
public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int slow=0;
        for (int fast= 0; fast < nums.length; fast++) {
            if(nums[fast]!=val) {
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }


}
