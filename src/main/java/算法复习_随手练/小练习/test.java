package 算法复习_随手练.小练习;

import java.util.*;

public class test {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            if (!map.containsKey(new String(charArray))) {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                map.put(new String(charArray), strings);
                continue;
            }
            List<String> strings = map.get(new String(charArray));
            strings.add(strs[i]);
            map.put(new String(charArray), strings);
        }
        List<List<String>> lists = new LinkedList<>();
        for (Map.Entry entry : map.entrySet()) {
            lists.add((List<String>) entry.getValue());
        }
        return lists;
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int num = nums[i];
            if (!set.contains(num - 1)) {
                while (set.contains(num + 1)) {
                    count++;
                    num++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
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
            int hight = Math.min(height[left], height[right]);
            int i = hight * (right - left);
            max = Math.max(max, i);
            if (hight == height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, r = nums.length - 1;
            while (j < r) {
                int num = nums[i] + nums[j] + nums[r];
                if (num < 0) {
                    j++;
                } else if (num > 0) {
                    r--;
                } else {
                    while (j < r && nums[j] == nums[j + 1]) j++;
                    while (j < r && nums[r] == nums[r - 1]) r--;
                    lists.add(List.of(nums[i], nums[j], nums[r]));
                    r--;
                    j++;
                }
            }
        }
        return lists;
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> characters = new HashSet<>();
        int len = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            while (characters.contains(s.charAt(right))) {
                characters.remove(s.charAt(left));
                left++;
            }
            characters.add(s.charAt(right));
            right++;
            len = Math.max(len, characters.size());
        }
        return len;
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (!map.containsKey(pre - k)) {
                Integer orDefault = map.getOrDefault(pre, 0) + 1;
                map.put(pre, orDefault);
                continue;
            }
            count += map.get(pre - k);
            Integer orDefault = map.getOrDefault(pre, 0) + 1;
            map.put(pre, orDefault);
        }
        return count;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        MyQueue myQueue = new MyQueue(k);
        for (int i = 0; i < k - 1; i++) myQueue.add(nums[i]);
        for (int i = k - 1; i < nums.length; i++) {
            myQueue.add(nums[i]);
            res[i - k + 1] = myQueue.deque.getFirst();
            myQueue.remove(nums[i - k + 1]);
        }

        return res;
    }

    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();
        int capity;

        public MyQueue(int capity) {
            this.capity = capity;
        }

        public void add(int num) {
            while (!deque.isEmpty() && deque.getLast() < num) deque.removeLast();
            deque.addLast(num);
        }

        public void remove(int num) {
            if (!deque.isEmpty() && num == deque.getFirst()) deque.removeFirst();
        }

    }

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (pre < 0) pre = 0;
            max = Math.max(max, pre);
        }
        return max;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
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

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int l = nums[left];
            nums[left] = nums[right];
            nums[right] = l;
            left++;
            right--;
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int[] is = new int[nums.length];
        int[] os = new int[nums.length];
        is[0] = 1;
        os[os.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) is[i] = is[i - 1] * nums[i - 1];
        for (int i = nums.length - 2; i >= 0; i--) os[i] = os[i + 1] * nums[i + 1];
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) res[i] = is[i] * os[i];
        return res;
    }


    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (0 < nums[i] && nums[i] < nums.length + 1 &&
                    nums[nums[i] - 1] != nums[i]) {
                int num = nums[i];
                nums[i] = nums[num - 1];
                nums[num - 1] = num;
            }
        }
        for (int i = 0; i < nums.length; i++) if (nums[i] != i + 1) return i + 1;
        return nums.length + 1;
    }

    public void setZeroes(int[][] matrix) {
        boolean ish = false;
        boolean isl = false;
        for (int i = 0; i < matrix.length; i++) if (matrix[i][0] == 0) ish = true;
        for (int i = 0; i < matrix[0].length; i++) if (matrix[0][i] == 0) isl = true;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (ish) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (isl) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0, r = matrix[0].length - 1;
        int u = 0, d = matrix.length - 1;
        ArrayList<Integer> integers = new ArrayList<>();
        while (l <= r && u <= d) {
            for (int i = l; i <= r; i++) integers.add(matrix[u][i]);
            u++;
            for (int i = u; i <= d; i++) integers.add(matrix[i][r]);
            r--;
            if (u <= d) {
                for (int i = r; i >= l; i--) integers.add(matrix[d][i]);
                d--;
            }
            if (l <= r) {
                for (int i = d; i >= u; i--) integers.add(matrix[i][l]);
                l++;
            }
        }
        return integers;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1=headA;
        ListNode l2=headB;
        while (l1!=l2){
            if(l1==null)l1=headB;
            else l1=l1.next;
            if(l2==null)l2=headA;
            else l2=l2.next;
        }
        return l1;
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode pre = head;
        ListNode cur= head.next;
        while (pre!=null&&pre.next!=null){
            pre=pre.next.next;
            cur=cur.next;
        }
        ListNode next = cur.next;
        cur.next=null;
        ListNode listNode = reverseList(next);
        while (listNode!=null&&head!=null){
            if(listNode.val!=head.val)return false;
            listNode=listNode.next;
            head=head.next;
        }
        return true;
    }

    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode slow=head,fast=head.next;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                slow=head;
                while (fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return fast;
            }
        }
        return null;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(0);
        ListNode pre=dummy;
        while (list1!=null||list2!=null){
            if(list1 == null){
                pre.next=list2;
                break;
            }
            if(list2 == null){
                pre.next=list1;
                break;
            }
            if(list1.val<list2.val){
                pre.next=list1;
                pre=pre.next;
                list1=list1.next;
            }else {
                pre.next=list2;
                pre=pre.next;
                list2=list2.next;
            }
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        int bef=0;
        while (l1!=null||l2!=null){
            if(l1==null&&l2!=null){
                pre.next=new ListNode((l2.val+ bef)%10);
                bef=(l2.val+ bef)/10;
                pre=pre.next;
                l2=l2.next;
                continue;
            }
            if(l2==null&&l1!=null){
                pre.next=new ListNode((l1.val+ bef)%10);
                bef=(l1.val+ bef)/10;
                pre=pre.next;
                l1=l1.next;
                continue;
            }
            pre.next=new ListNode((l1.val+l2.val+ bef)%10);
            bef=(l1.val+l2.val+ bef)/10;
            pre=pre.next;
            l2=l2.next;
            l1=l1.next;
        }
        if(bef!=0)pre.next=new ListNode(bef);
        return dummy.next;
    }

    List<String> list=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> generateParenthesis(int n) {
        brack(0,0,n);
        return list;
    }
    private void brack(int l,int r,int n){
        if(l==n&&r==n){
            list.add(sb.toString());
            return;
        }
        if(l<n){
            sb.append('(');
            brack(l+1,r,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(l>r){
            sb.append(')');
            brack(l,r+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }



}
