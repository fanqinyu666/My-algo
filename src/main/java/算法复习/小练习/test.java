package 算法复习.小练习;

import java.util.*;

public class test {


    private static void test(int a) {
        a = 8;
        System.out.println(a);

    }

    public int test3(String string) {
        char c = string.charAt(0);
        if (c == '+') {
            return 0;
        }
        if (c == '0') {
            return 1;
        }

        int sum;
        int start;
        if (c == '-') {
            sum = 1;
            start = 1;
        } else {
            sum = 0;
            start = 0;
        }
        for (; start < string.length(); ) {
            if (string.charAt(start) == '0' || string.charAt(start) == '+' || string.charAt(start) == '-') {
                return sum - 1;
            }

            while (string.charAt(sum) != '-' && string.charAt(sum) != '+') {
                sum++;
            }

            start = sum;

            if (start == string.length() - 1) {
                return start;
            }
            start = start + 1;
            sum = sum + 1;
        }
        return start;
    }

    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] ints = new int[nums.length];
        int index = nums.length - 1;

        while (index >= 0) {
            int ll = nums[left] * nums[left];
            int rr = nums[right] * nums[right];
            if (ll > rr) {
                ints[index] = ll;
                left++;
                index--;
            } else {
                ints[index] = rr;
                right--;
                index--;
            }

        }
        return ints;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    public int[] topKFrequent(int[] nums, int k) {
        int[] ints = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }


        for (int i = k - 1; i >= 0; i--) {
            ints[i] = priorityQueue.poll()[0];
        }
        return ints;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                int res = nums[i] + nums[right] + nums[left];
                if (res > 0) {
                    right--;
                } else if (res < 0) {
                    left++;
                } else {
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    lists.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            for (; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long res = (long) nums[j] + nums[i] + nums[left] + nums[right];
                    if (res > target) {
                        right--;
                    } else if (res < target) {
                        left++;
                    } else {
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        lists.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        left++;
                        right--;
                    }
                }
            }
        }
        return lists;
    }


    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if (height[i] <= height[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    Integer mid = stack.pop();
                    if (!stack.isEmpty()) {
                        Integer left = stack.peek();
                        int h = Math.min(height[left], height[i]) - height[mid];
                        int b = i - left - 1;
                        res += h * b;
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] res = new int[nums1.length];
        //结果集都是-1
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], i);
        }
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    Integer pop = stack.pop();
                    if (hashMap.containsKey(nums2[pop])) {
                        Integer i1 = hashMap.get(nums2[pop]);
                        res[i1] = nums2[i];
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }

    public int[] nextGreaterEleme56nt(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        //构建数组1的hashmap，k是值，v是下标。数组2可以用contain判断是否有这个数组一的值
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], i);
        }
        stack.push(0);

        for (int i = 1; i < nums2.length; i++) {
            if (nums2[stack.peek()] >= nums2[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    boolean b = hashMap.containsKey(nums2[stack.peek()]);
                    if (b) {
                        Integer i1 = hashMap.get(nums2[stack.peek()]);
                        res[i1] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }


    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++) {
            newHeights[index + 1] = heights[index];
        }
        heights = newHeights;
        Deque<Integer> stack = new LinkedList<Integer>();
        int max = 0;
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            if (heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    Integer mid = stack.pop();
                    if (!stack.isEmpty()) {
                        Integer left = stack.peek();
                        int h = heights[mid];
                        int bro = (i - left - 1);
                        max = Math.max(bro * h, max);
                    }
                }
                stack.push(i);
            }
        }
        return max;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            List<String> orDefault = map.getOrDefault(new String(array), new ArrayList<>());
            orDefault.add(str);
            map.put(new String(array), orDefault);
        }

        return new ArrayList<>(map.values());
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) integers.add(num);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i] - 1)) continue;
            int dd = 0;
            int num = nums[i];
            while (integers.contains(num)) {
                dd++;
                num++;
            }
            max = Math.max(max, dd);
        }
        return max;
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
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


    public int trap5(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            int peek = height[stack.peek()];
            if (!stack.isEmpty() && height[i] >= peek) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] < peek) {
                    Integer mid = stack.pop();
                    if (!stack.isEmpty()) {
                        Integer left = stack.peek();
                        int h = Math.min(height[left], height[i]) - height[mid];
                        int b = (i - left - 1);
                        res += h * b;
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        while (right<nums.length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0,right = 0,sum=0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            if(sum>target){
                min = Math.min(min,right-left+1);
                sum-=nums[left];
                left++;
            }else{
                sum+=nums[right];
                right++;
            }
        }
        return min;
    }






    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int hang = 0;
        int lie = 0;
        int coo = n / 2;
        int lun=n;
        int num=1;
        while (0 < coo) {
            for(;lie < lun-1; lie++) {
                matrix[hang][lie] = num++;
            }
            for (; hang < lun-1; hang++) {
                matrix[hang][lie] = num++;
            }
            for (; lie>n-lun;lie--) {
                matrix[hang][lie] = num++;
            }
            for (; hang >n-lun; hang--) {
                matrix[hang][lie] = num++;
            }
            coo--;
            lie++;
            hang++;
            lun--;
        }
        if(n%2==1){
            matrix[n/2][n/2] = n*n;
        }
        return matrix;
    }



    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(p.length()>s.length())return arrayList;
        int[] ints = new int[26];
        int[] is = new int[26];
        for (int i = 0; i < p.length(); i++)ints[p.charAt(i) - 'a']++;
        for (int i = 0; i < p.length(); i++)is[s.charAt(i) - 'a']++;
        int left = 0,right = p.length()-1;
        boolean flag;
        while (right < s.length()) {
            flag = true;
            for (int i = 0; i < ints.length; i++) {
                if(ints[i]!=is[i]){
                    flag = false;
                    break;
                }
            }
            if(flag)arrayList.add(left);
            is[s.charAt(left) - 'a']--;
            right++;
            left++;
            if(right==s.length())break;
            is[s.charAt(right) - 'a']++;
        }
        return arrayList;
    }


    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if(map.containsKey(pre-k))count += map.get(pre-k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }



    class MyQueue {
        Deque<Integer> deque=new LinkedList<>();
        int capy;
        public MyQueue(int capy) {
            this.capy = capy;
        }
        public void push(int x) {
            while(!deque.isEmpty()&&deque.getLast()<x)deque.removeLast();
            deque.addLast(x);
        }
        public void pop(int i) {
            if(!deque.isEmpty()&&deque.getFirst()==i) deque.removeFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue(k);
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++)myQueue.push(nums[i]);
        int idx = 0;
        res[idx++]=myQueue.deque.getFirst();

        for (int i = k; i < nums.length; i++) {
            myQueue.pop(nums[i-k]);
            myQueue.push(nums[i]);
            res[idx++]=myQueue.deque.getFirst();
        }
        return res;
    }


    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) return "";
        String res="";

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> test = new HashMap<>();

        for(int i=0;i<t.length();i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }

        int count= map.size();
        int have=0;
        int resStart=0,resLen=Integer.MAX_VALUE;;
        int left=0,right=0;
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))) {
                test.put(s.charAt(right), test.getOrDefault(s.charAt(right),0)+1);
                if(test.get(s.charAt(right))>=map.get(s.charAt(right))){
                    have++;
                }
            }
           
            while(have==count){
                if(right-left+1<resLen){
                    resLen=right-left+1;
                    res=s.substring(left,right+1);
                }
                if(map.containsKey(s.charAt(left))){
                    test.put(s.charAt(left), test.get(s.charAt(left))-1);
                    if(test.get(s.charAt(left))<map.get(s.charAt(left))){
                        have--;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }
    //TODO

    public String reverseStr(String s, int k) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i+=2*k) {
            if(s.length()-i>=2*k){
                String substring = s.substring(i, i +k);
                StringBuilder reverse = new StringBuilder(substring).reverse();
                stringBuilder.append(reverse);
            }else if(k<=s.length()-i&&s.length()-i<2*k){
                String substring = s.substring(i, i + k);
                StringBuilder reverse = new StringBuilder(substring).reverse();
                stringBuilder.append(reverse);
                stringBuilder.append(s.substring(i+k,s.length()));

            }else if(s.length()-i<k){
                String substring = s.substring(i);
                StringBuilder reverse = new StringBuilder(substring).reverse();
                stringBuilder.append(reverse);
            }
        }
        return stringBuilder.toString();
    }



    public void swap(int[] sum,int left,int right){
        int num = sum[left];
        sum[left]=sum[right];
        sum[right]=num;
    }

    public int shaobin(int[] sum,int left,int right){
        int i=left,j=right;

        while (i<j){
            //右边找到第一个比基准元素小的
            while (i<j&&sum[j]>sum[left])j--;
            //左边找到第一个比基准元素大的
            while (i<j&&sum[j]<=sum[left])i++;
            //交换
            swap(sum,left,right);
        }
        //i和j在一块，空位留给基准元素，我们这里的及基准元素是left
        swap(sum,i,left);
        //返回其下标
        return i;
    }
    public void quick(int[] sum,int left,int right){
        if(left>right)return;
        int shaobin = shaobin(sum, left, right);
        quick(sum,left,shaobin-1);
        quick(sum,shaobin+1,right);
    }

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<dp.length;i++){
            for (int j=1;j<=i;j++){
                dp[i]+=dp[i-j]*dp[j-1];
            }
        }
        return dp[n];
    }



    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for (int i=3;i<dp.length;i++){
            for (int j=1;j<i;j++){
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }








}
