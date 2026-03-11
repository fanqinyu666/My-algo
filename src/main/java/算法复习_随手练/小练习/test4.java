package 算法复习_随手练.小练习;


import java.util.*;

public class test4 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{i, map.get(target - nums[i])};
            map.put(nums[i], i);
        }
        return null;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            if (!map.containsKey(s)) {
                List<String> s1 = new ArrayList<>();
                s1.add(strs[i]);
                map.put(s, s1);
            } else {
                List<String> strings = map.get(s);
                strings.add(strs[i]);
            }
        }
        for (Map.Entry entry : map.entrySet()) lists.add((List<String>) entry.getValue());
        return lists;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int result = 0;
        for (int num : num_set) {
            if (num_set.contains(num - 1)) {
                continue;
            }
            int count = 0;
            while (num_set.contains(num)) {
                count++;
                num++;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    public void moveZeroes(int[] nums) {
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int num = nums[left];
                nums[left] = nums[right];
                nums[right] = num;
                left++;
            }
            right++;
        }
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int l = height[left];
            int r = height[right];
            int i = Math.min(l, r) * (right - left);
            if (Math.min(l, r) == r) right--;
            else left++;
            max = Math.max(max, i);
        }
        return max;
    }


    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int lM = height[left], rM = height[right];
        int max = 0;
        while (left < right) {
            lM = Math.max(lM, height[left]);
            rM = Math.max(rM, height[right]);
            if (Math.min(lM, rM) == lM) {
                max += lM - height[left];
                left++;
            } else {
                max += rM - height[right];
                right--;
            }
        }
        return max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int num = nums[i] + nums[j] + nums[k];
                if (num == 0) {
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    lists.add(List.of(nums[i], nums[j], nums[k]));
                    k--;
                    j++;
                } else if (num > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return lists;
    }

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> integers = new ArrayList<>();
        int[] ints = new int[26];
        int[] intp = new int[26];
        for (int i = 0; i < p.length(); i++) intp[p.charAt(i) - 'a']++;
        for (int i = 0; i < p.length(); i++) ints[s.charAt(i) - 'a']++;
        for (int i = p.length(); i + p.length() < s.length(); i++) {
            for (int num = 0; num < ints.length; num++) {
                if (ints[num] != intp[num]) break;
            }
            integers.add(i);
            ints[s.charAt(i) - 'a']--;
            ints[s.charAt(i + p.length()) - 'a']++;
        }
        return integers;
    }


    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return -1;
        int max = Integer.MIN_VALUE;
        HashSet<Character> characters = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            if (!characters.contains(s.charAt(right))) {
                characters.add(s.charAt(right));
                right++;
                max = Math.max(max, characters.size());
                continue;
            }
            while (characters.contains(s.charAt(right))) {
                characters.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }

    public int subarraySum(int[] nums, int k) {
        int num = 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) num += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return num;
    }

    public int majorityElement(int[] nums) {
        int sum = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                pre = nums[i];
                sum++;
            } else {
                if (pre == nums[i]) sum++;
                else sum--;
            }
        }
        return pre;
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = Math.max(0, nums[0]);
        int maxSum = nums[0];     // 全局最大和
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = Math.min(intervals[i][0], intervals[i - 1][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            } else {
                lists.add(List.of(intervals[i - 1][0], intervals[i - 1][1]));
            }
        }

        lists.add(List.of(intervals[intervals.length - 1][0], intervals[intervals.length - 1][1]));
        int[][] ints = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> integers = lists.get(i);
            ints[i][0] = integers.get(0);
            ints[i][1] = integers.get(1);
        }
        return ints;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] d1 = new int[nums.length];
        int[] d2 = new int[nums.length];
        d1[0] = 1;
        d2[d2.length - 1] = 1;
        for (int i = 1; i < d1.length; i++) d1[i] = d1[i - 1] * nums[i - 1];
        for (int i = d2.length - 2; i >= 0; i--) d2[i] = d2[i + 1] * nums[i + 1];
        int[] res = new int[d2.length];
        for (int i = 0; i < d1.length; i++) res[i] = d1[i] * d2[i];
        return res;
    }

    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                int num = nums[i];
                nums[i] = nums[num - 1];
                nums[num - 1] = num;
            }
        }
        for (int i = 0; i < nums.length; i++) if (nums[i] != i + 1) return i + 1;
        return nums.length + 1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, index = matrix[0].length - 1;
        while (top < matrix.length && top >= 0) {
            if (matrix[top][index] < target) top++;
            else if (matrix[top][index] > target) index--;
            else return true;
        }
        return false;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int a = 0, w = 0, s = matrix.length - 1, d = matrix[0].length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (a <= d && w <= s) {
            for (int i = a; i <= d; i++) list.add(matrix[w][i]);
            w++;
            for (int i = w; i <= s; i++) list.add(matrix[i][d]);
            d--;
            if (w <= s) {
                for (int i = d; i >= a; i--) list.add(matrix[s][i]);
                s--;
            }
            if (a <= d) {
                for (int i = s; i >= w; i--) list.add(matrix[i][a]);
                a++;
            }
        }
        return list;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            if (l1 == null) l1 = headB;
            else l1 = l1.next;
            if (l2 == null) l2 = headA;
            else l2 = l2.next;
        }
        return l1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        while (l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val + l2.val + sum) % 10);
            sum = (l1.val + l2.val + sum) / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while (l1 != null) {
            cur.next = new ListNode((l1.val + sum) % 10);
            sum = (l1.val + sum) / 10;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = new ListNode((l2.val + sum) % 10);
            sum = (l2.val + sum) / 10;
            cur = cur.next;
            l2 = l2.next;
        }
        if (sum != 0) cur.next = new ListNode(sum);
        return dummy.next;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        dummy.next = cur;
        ListNode pre = dummy;
        while (cur != null) {
            int sum = 1;
            while (sum < k && cur != null) {
                sum++;
                cur = cur.next;
            }
            if (sum < k) break;

            ListNode next = cur.next;
            ListNode next1 = pre.next;
            //断开
            pre.next = null;
            cur.next = null;
            //反转
            ListNode reverse = reverse(next1);
            //连接
            pre.next = reverse;
            next1.next = next;
            //修改
            pre = next1;
            cur = next;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode sortList(ListNode head) {
        return breaks(head);
    }

    private ListNode breaks(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode h1 = dummy.next;
        ListNode h2 = slow.next;
        slow.next = null;
        ListNode res1 = breaks(h1);
        ListNode res2 = breaks(h2);
        return mergeTwoLists(res1, res2);
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) return lists[0];
        if (lists.length == 0) return null;
        ListNode[] res = new ListNode[(lists.length + 1) / 2];
        for (int i = 0; i < lists.length; i += 2) {
            if (lists.length > i + 1) res[i / 2] = mergeTwoLists(lists[i], lists[i + 1]);
            else res[i / 2] = mergeTwoLists(lists[i], null);
        }
        return mergeKLists(res);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                break;
            }
            if (list2 == null) {
                cur.next = list1;
                break;
            }
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val != fast.val) {
                if (slow.next != fast) {
                    slow = fast;
                } else {
                    pre.next = slow;
                    slow = fast;
                    pre = pre.next;
                }
                fast = fast.next;
            } else {
                fast = fast.next;
            }
        }
        if (pre.next != null) pre.next = null;
        return dummy.next;
    }

    public int maxDepth(TreeNode root) {
        return track(root);
    }

    private int track(TreeNode root) {
        if (root == null) return 0;
        int l = track(root.left);
        int r = track(root.right);
        return Math.max(l, r) + 1;
    }


    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[dp.length - 1];
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(List.of(1));
        if (numRows == 0) return null;
        if (numRows == 1) return lists;
        lists.add(List.of(1, 1));
        if (numRows == 2) return lists;

        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> integers2 = new ArrayList<>();
            integers2.add(1);
            List<Integer> integers1 = lists.get(lists.size() - 1);
            for (int j = 0; j < integers1.size() - 1; j++) {
                int i1 = integers1.get(j) + integers1.get(j + 1);
                integers2.add(i1);
            }
            integers2.add(1);
            lists.add(integers2);
        }
        return lists;
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
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
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[dp.length - 1];
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

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int a : nums) sum += a;
        int res = (sum - target) / 2;
        if (Math.abs(target) > sum) return 0;
        if ((target + sum) % 2 == 1) return 0;
        int[] dp = new int[res + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[dp.length - 1];
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<dp.length;i++){
            for (int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[dp.length-1];
    }


    public int change(int amount, int[] coins) {
        int[] dp= new int[amount + 1];
        dp[0]=1;

        for (int i=0;i<coins.length;i++){
            for (int j=coins[i];j<dp.length;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[dp.length-1];
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],nums[i-1]);
        }
        return dp[dp.length-1];
    }



    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i=1;i<dp.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[dp.length-1][0];
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][1]=-prices[0];
        dp[0][2]=0;
        dp[0][3]=-prices[0];
        dp[0][4]=0;
        for (int i=1;i<dp.length;i++){
            dp[i][0]=dp[i-1][0];
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
            dp[i][2]=Math.max(dp[i-1][1]+prices[i],dp[i-1][2]);
            dp[i][3]=Math.max(dp[i-1][2]-prices[i],dp[i-1][3]);
            dp[i][4]=Math.max(dp[i-1][3]+prices[i],dp[i-1][4]);
        }
        return Math.max(dp[dp.length-1][4],dp[dp.length-1][2]);
    }

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k*2+1];
        for (int i=1;i<dp[0].length;i+=2){
            dp[0][i]=-prices[0];
            dp[0][i+1]=0;
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < dp[0].length; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
            }
            for (int j = 2; j < dp[0].length; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j-1] + prices[i]);
            }
        }
        int max=0;
        for (int i = 2; i <=2*k; i+=2) {
            max=Math.max(max,dp[dp.length-1][i]);
        }
        return max;
    }

    public int maxProfit5(int[] prices) {
        int[][] dp = new int[prices.length][4];
        //买入
        dp[0][0]=-prices[0];
        //早卖了
        dp[0][1]=0;
        //当天卖
        dp[0][2]=0;
        //冷冻期
        dp[0][3]=0;
        for (int i=1;i<dp.length;i++){
            dp[i][0]=Math.max(Math.max(dp[i-1][0],dp[i-1][3]-prices[i]),dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][3],dp[i-1][1]);
            dp[i][2]=dp[i-1][0]+prices[i];
            dp[i][3]=dp[i-1][2];
        }
        int max=0;
        for (int i = 0; i < 4; i++) {
            max = Math.max(max, dp[prices.length - 1][i]);
        }
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max=0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max=0;
        for (int i = 1; i < dp.length; i++) {
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        int max=0;
        for (int i = 1; i < nums1.length+1; i++) {
            for (int j = 1; j < nums2.length+1; j++) {
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }


    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i=0;i<32;i++){
            int count=0;
            for (int j=0;j<nums.length;j++)count+=(nums[j]>>i)&1;
            if(count%3!=0)res=res|(1<<i);
        }
        return res;
    }
    public int[] singleNumber3(int[] nums) {
        int num=0;
        for (int i=0;i<nums.length;i++)num^=nums[i];
        int i=0;
        for (;i<32;i++)if(((num>>i)&1)==1)break;
        int i1=0,i2=0;
        for (int j=0;j<nums.length;j++){
            if(((nums[j]>>i)&1)==1)i1^=nums[j];
            else i2^=nums[j];
        }
        return new int[]{i1,i2};
    }
}

