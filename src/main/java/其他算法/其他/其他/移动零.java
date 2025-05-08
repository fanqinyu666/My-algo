package 其他算法.其他.其他;

import java.util.*;

public class 移动零 {


    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            if (nums[right] != 0) {
                int r = nums[right];
                nums[right] = nums[left];
                nums[left] = r;
                left++;

            } else {
                continue;
            }
        }

    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int result = 0;

        for (int num : nums) {
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

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }

        //方法1：将结果集合转为数组
        int[] arr = new int[resSet.size()];
        int j = 0;
        for (int i : resSet) {
            arr[j++] = i;
        }

        return arr;

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                Integer i1 = map.get(target - nums[i]);
                ints[0] = i1;
                ints[1] = i;
            } else {
                map.put(nums[i], i);
            }

        }
        return ints;

    }


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();//二位集合
        Arrays.sort(nums);//排序数组

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  //去重a
                //i=0的时候不需要去重
                //i>0的时候，判断当前的元素和前一个元素是否一样
                //为何不是nums[i] == nums[i + 1]，并让i从0开始遍历呢？
                continue;
            }
            int left = i + 1;//他俩位置要理解
            int right = nums.length - 1;
            while (right > left) {//不可相等，相等就不是三元了，而是二元
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {//等于0的时候就存入一个数组，存入集合
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();//二位集合
        Arrays.sort(nums);//排序数组

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  //去重a
                //i=0的时候不需要去重
                //i>0的时候，判断当前的元素和前一个元素是否一样
                //为何不是nums[i] == nums[i + 1]，并让i从0开始遍历呢？
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    //等于0的时候就存入一个数组，存入集合
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }


            }
        }
        return result;
    }


    public boolean isPalindrome(ListNode head) {
        ListNode currentNode = head;

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (currentNode.next != null) {
            arrayList.add(currentNode.val);
            currentNode = currentNode.next;
        }
        int left = 0;
        int right = arrayList.size() - 1;
        while (left < right) {
            if (arrayList.get(left) != arrayList.get(right)) {
                return false;
            }
            left++;
            right--;

        }
        return true;
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

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }

        }
        return false;


    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur = headA;
        HashMap<Integer, ListNode> hashMap = new HashMap<>();
        while (cur != null) {
            hashMap.put(cur.val, cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            if (hashMap.containsKey(cur.val)) {
                return hashMap.get(cur.val);
            }
        }
        return null;
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode cur = new ListNode();
        cur = res;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
                continue;
            }
            if (list2 == null) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
                continue;
            }

            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        return res.next;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode();
        ListNode cur = res;

        ListNode one = l1;
        ListNode two = l2;
        int exr = 0;
        while (one != null || two != null) {

            if (one == null) {

                cur.next = new ListNode((two.val + exr) % 10);
                exr = (two.val + exr) / 10;
                cur = cur.next;
                two = two.next;
                continue;
            }
            if (two == null) {
                cur.next = new ListNode((one.val + exr) % 10);
                exr = (one.val + exr) / 10;
                cur = cur.next;
                one = one.next;
                continue;
            }
            cur.next = new ListNode((one.val + two.val + exr) % 10);
            exr = (one.val + two.val + exr) / 10;
            cur = cur.next;
            one = one.next;
            two = two.next;

        }
        if (exr != 0) {
            cur.next = new ListNode(exr);
        }
        return res.next;
    }


    public void moveZeroes2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            int j = i;
            for (; j < nums.length - 1; j++) {
                if (nums[j] != 0) {
                    break;
                }
            }

            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int left = 0; left < nums.length; left++) {
            int sum = 0;
            for (int right = left; right < nums.length; right++) {
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < sb.length() - 1) {

            if (2 * k <= sb.length() - index - 1) {
                String substring = s.substring(index, index + k);//0-1
                StringBuffer stringBuffer = new StringBuffer(substring);
                StringBuffer reverse = stringBuffer.reverse();
                res.append(reverse);
                String substring1 = s.substring(index + k, index + 2 * k);
                res.append(substring1);
                index = index + 2 * k - 1;

            } else if (sb.length() - index + 1 < k) {
                res.append(s.substring(index + 1));
                index = s.length() - 1;
            } else if (k <= sb.length() - index - 1 && sb.length() - index - 1 < 2 * k) {

                String substring = s.substring(index, index + k + 1);//0-1
                StringBuffer stringBuffer = new StringBuffer(substring);
                StringBuffer reverse = stringBuffer.reverse();
                res.append(reverse);
                res.append(s.substring(index + k + 1));

                index = s.length() - 1;
            }

        }
        return res.toString();
    }


    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);

        while (cur != null && cur.next != null) {
            if (!set.contains(cur.next.val)) {
                set.add(cur.next.val);
                cur = cur.next;
                continue;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
/*

    public static void main(String[] args) {
        移动零 移动零 = new 移动零();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        移动零.reorderList(listNode1);

    }
*/

    public void reorderList(ListNode head) {
        ListNode cur = head;
        ListNode tail = head;
        int i = 0;
        while (tail.next != null) {
            tail = tail.next;
            i++;
        }
        int i1 = i / 2;
        while (i1 != 0) {
            cur = cur.next;
            i1--;
        }

        ListNode right = cur.next;
        cur.next = null;
        ListNode pre = null;
        ListNode curr = right;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        mergeList(head, pre);


    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode node1;
        ListNode node2;
        ListNode fin = new ListNode();


        while (l1 != null && l2 != null) {
            node1 = l1.next;
            node2 = l2.next;

            fin.next = l1;
            fin = fin.next;
            fin.next = l2;
            fin = fin.next;
            l1 = node1;
            l2 = node2;
        }
        if (l1 != null) {
            fin.next = l1;
        }
        if (l2 != null) {
            fin.next = l2;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return fast;

            }
        }


        return null;

    }

    public String reverseWords(String s) {// 使用双指针法！
        Set<Object> objects = new HashSet<>();
        objects.contains(4);
        int m = s.length() - 1;
        StringBuilder str = new StringBuilder();
        // 除去尾部空格
        while (s.charAt(m) == ' ' && m > 0) m--;
        int n = m; // n是另一个指针
        while (m >= 0) {
            while (m >= 0 && s.charAt(m) != ' ') m--;
            str.append(s.substring(m + 1, n - m) + ' '); // 获取单词并加上空格
            while (m >= 0 && s.charAt(m) == ' ') m--;
            n = m;

        }
        return str.substring(0, str.length() - 1); // 忽略最后一位的空格
    }


    class LRUCache {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode next;
            DLinkedNode prev;

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public DLinkedNode() {
            }
        }

        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            size = 0;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        private int size;
        HashMap<Integer, DLinkedNode> map = new HashMap<>();
        private DLinkedNode head;
        private DLinkedNode tail;


        public int get(int key) {
            DLinkedNode dLinkedNode = map.get(key);
            if (dLinkedNode == null) {
                return -1;
            }
            //通过hash表定位，再移动到头部
            moveToHead(dLinkedNode);
            return dLinkedNode.value;
        }

        public void put(int key, int value) {
            DLinkedNode dLinkedNode = map.get(key);
            if (dLinkedNode == null) {
                DLinkedNode dLinkedNode1 = new DLinkedNode(key, value);
                map.put(key, dLinkedNode1);
                addToHead(dLinkedNode);
                size++;
                if (size > capacity) {
                    DLinkedNode dLinkedNode2 = removeTail();
                    map.remove(dLinkedNode2.key);
                    size--;
                }
            } else {
                dLinkedNode.value = value;
                moveToHead(dLinkedNode);
            }

        }

        public void addToHead(DLinkedNode dLinkedNode) {
            dLinkedNode.prev = head;
            dLinkedNode.next = head.next;
            head.next.prev = dLinkedNode;
            head.next = dLinkedNode;
        }


        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if (height[i] <= height[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    Integer min = stack.pop();
                    if (!stack.isEmpty()) {
                        Integer left = stack.peek();
                        int board = i - left - 1;
                        int hight = Math.min(height[i], height[left]) - height[min];
                        total += board * hight;
                    }
                }
                stack.push(i);
            }
        }

        return total;


    }

    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }

        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        //队列队顶元素始终为最大值
        int peek() {
            return deque.peek();
        }
    }

    public static void main(String[] args) {
        移动零 移动零 = new 移动零();
        移动零.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue2 myQueue2 = new MyQueue2(k);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            myQueue2.add(nums[i]);
        }
        arrayList.add(myQueue2.deque.getFirst());
        for (int i = k; i < nums.length; i++) {
            myQueue2.add(nums[i]);
            myQueue2.poll();
            arrayList.add(myQueue2.deque.getFirst());
        }
        int[] ints = new int[arrayList.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=arrayList.get(i);
        }
        return ints;

    }

    class MyQueue2 {
        Deque<Integer> deque = new LinkedList<>();
        int cap;
        int size = 0;
        public MyQueue2(int cap) {
            this.cap = cap;
        }

        void poll() {
            if (deque.size() > cap) {
                deque.removeFirst();
            }
        }

        void add(int s) {
            while (!deque.isEmpty() && deque.getLast() < s) {
                deque.removeLast();
            }
            deque.addLast(s);
        }
    }


}

