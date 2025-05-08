package 算法复习.复习1;
import java.util.*;

public class 非递减子序列 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return result;
    }
    public void backtracking (int[] nums,int startindex){
        if(path.size()>=2){
            result.add(new ArrayList<>(path));
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = startindex; i < nums.length; i++) {

            if(!path.isEmpty() && path.get(path.size() -1 ) > nums[i] || hs.contains(nums[i]))
                continue;

            hs.add(nums[i]);
            path.addLast(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();

        }
    }





}
