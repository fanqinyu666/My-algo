package 算法复习_随手练.小练习;

import 代码随想录.二叉树.TreeNode;

import java.util.*;

public class test1 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[dp.length - 1];
    }


    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[i - j - 1] * dp[j];
            }
        }
        return dp[dp.length - 1];
    }

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(List.of(1));
        if (numRows == 1) return lists;
        lists.add(List.of(1, 1));
        if (numRows == 2) return lists;
        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(1);
            List<Integer> integers = lists.get(lists.size() - 1);
            for (int j = 0; j < integers.size() - 1; j++) {
                arrayList.add(integers.get(j) + integers.get(j + 1));
            }
            arrayList.add(1);
            lists.add(arrayList);
        }
        return lists;
    }

    public boolean canPartition(int[] nums) {
        int max = 0;
        for (int num : nums) max += num;
        if (max % 2 == 1) return false;
        int[] dp = new int[max / 2 + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[dp.length - 1] == dp.length - 1;
    }


    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (j >= coins[i]) dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[dp.length - 1];
    }

    public int rob(TreeNode root) {
        int[] brack = brack(root);
        return Math.max(brack[0],brack[1]);
    }

    private int[] brack(TreeNode root) {
        if(root==null)return new int[]{0,0};
        int[] l = brack(root.left);
        int[] r = brack(root.right);
        int[] brack = new int[2];
        brack[1]=l[0]+r[0]+root.val;
        brack[0]=Math.max(l[0],l[1])+Math.max(r[0],r[1]);
        return brack;
    }

    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int lx=height[0],rx=height[height.length-1];
        int max=0;
        while (l<r){
            lx=Math.max(height[l],lx);
            rx=Math.max(height[r],rx);
            if(lx>rx){
                max+=rx-height[r];
                r--;
            }else {
                max+=lx-height[l];
                l++;
            }
        }
        return max;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        MyQueue myQueue = new MyQueue(k);
        for (int i=0;i<k;i++)myQueue.put(nums[i]);
        res[0]= myQueue.deque.getFirst();
        for (int i=k;i<nums.length;i++){
            myQueue.remove(nums[i-k]);
            myQueue.put(nums[i]);
            res[i-k+1]=myQueue.deque.getFirst();
        }
        return res;
    }
    class MyQueue{
        LinkedList<Integer> deque=new LinkedList<Integer>();
        int captity;

        public MyQueue(int captity) {
            this.captity = captity;
        }

        public void put(int i){
            while (!deque.isEmpty()&&i>deque.getLast())deque.removeLast();
            deque.addLast(i);
        }

        public void remove(int i){
            if(i==deque.getFirst())deque.removeFirst();
        }
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0;
        int pre=0;
        map.put(0,1);
        for (int i=0;i<nums.length;i++){
            pre+=nums[i];
            if (map.containsKey(pre-k)) count+=map.get(pre-k);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        int[] ls=new int[nums.length];
        int[] rs=new int[nums.length];
        ls[0]=1;
        rs[rs.length-1]=1;
        for(int i=0;i<nums.length-1;i++)ls[i+1]=ls[i]*nums[i];
        for(int i=nums.length-1;i>0;i--)rs[i-1]=rs[i]*nums[i];
        for(int i=0;i<ls.length;i++)res[i]=ls[i]*rs[i];
        return res;
    }
    public int firstMissingPositive(int[] nums) {

        for (int i=0;i<nums.length;i++){
            while (nums[i]>=1&&nums[i]<=nums.length+1&&nums[i]!=nums[nums[i]-1]){
                int num = nums[i];
                nums[i] = nums[num - 1];
                nums[num - 1]=num;
            }
        }
        for (int i=0;i<nums.length;i++)if(nums[i]!=i+1)return i+1;
        return nums.length;
    }

}

