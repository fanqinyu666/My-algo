package 算法复习.回溯复习;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 子集 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort( nums );
        backTracking(nums,0);
        return res;
    }
    private void backTracking(int[] nums,int startindex) {
        if(startindex > nums.length) {
            return;
        }
        res.add(new ArrayList<>(path));
        for (int i = startindex; i < nums.length; i++) {
            if(i > startindex && nums[i] == nums[i-1]) {
                continue;
            }
            path.addFirst(nums[i]);
            backTracking(nums,i+1);
            path.removeFirst();
        }
    }
}
