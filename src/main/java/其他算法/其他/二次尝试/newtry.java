package 其他算法.其他.二次尝试;

import java.util.*;

public class newtry {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int max = Math.max(left, right);
        return max + 1;
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null || root.right != null) {
            return Integer.MAX_VALUE;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        int min = Math.min(left, right);
        return min + 1;
    }


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int dl = 0;
        int dr = 0;
        while (left != null) {
            dl++;
            left = left.left;
        }
        while (right != null) {
            dr++;
            right = right.right;
        }
        if (dl == dr) {
            return (2 << dl) - 1;
        }//如果是满二叉树就结束了，直接返回数量。否则才走下面的逻辑
        //继续向下遍历，最后到了叶子节点的上一个节点的时候一定会得到结果的
        int i = countNodes(left);//左
        int l = countNodes(right);//右
        return i + l + 1;//中
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        }
        return -1;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, ArrayList<Integer> paths, ArrayList<String> res) {
        if (root == null) {
            return;
        }
        paths.add(root.val);
        if (root.left != null && root.right == null) {//左边有
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);
            return;
        }
        if (root.left == null && root.right != null) {//右边有
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);
            return;
        }
        if (root.left == null && root.right == null) {//都没有
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                Integer i1 = paths.get(i);
                stringBuilder.append(i1);
                stringBuilder.append("->");
            }
            stringBuilder.append(paths.get(paths.size() - 1));
            res.add(stringBuilder.toString());
            paths.remove(paths.size() - 1);
            return;
        }
        traversal(root.left, paths, res);
        traversal(root.right, paths, res);
        paths.remove(paths.size() - 1);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);
        //是叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            left = root.left.val;
        }
        return left + right;
    }


    private int Deep = -1;
    private int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    private void findLeftValue(TreeNode root, int deep) {
        if (root == null) return;

        if (deep >= Deep) {
            Deep = deep;
            value = root.val;
        }
        findLeftValue(root.right, deep + 1);
        findLeftValue(root.left, deep + 1);
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        }
        boolean a = hasPathSum(root.left, targetSum - root.val);
        boolean b = hasPathSum(root.right, targetSum - root.val);
        return a || b;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);

        int index = 0;

        int first = preorder[0];
        for (int i = 0; i < inorder.length; i++) {
            if (first == inorder[i]) {
                index = i;
                break;
            }
        }
        int[] prepre = new int[index];
        int[] aftpre = new int[preorder.length - index - 1];

        int[] preino = new int[index];
        int[] aftino = new int[preorder.length - index - 1];


        for (int i = 0; i < preino.length; i++) {
            preino[i] = inorder[i];
        }
        for (int i = 0; i < aftino.length; i++) {
            aftino[i] = inorder[index + 1 + i];
        }

        for (int i = 0; i < prepre.length; i++) {
            prepre[i] = preorder[i + 1];
        }
        for (int i = 0; i < aftpre.length; i++) {
            aftpre[i] = preorder[1 + preino.length + i];
        }
        root.left = buildTree(prepre, preino);
        root.right = buildTree(aftpre, aftino);
        return root;
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[nums.length - 1]);
        }

        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max == nums[i]) {
                index = i;
            }
        }

        TreeNode root = new TreeNode(nums[index]);

        int[] left = new int[index];
        int[] right = new int[nums.length - index - 1];

        for (int i = 0; i < left.length; i++) {
            left[i] = nums[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = nums[index + 1 + i];
        }
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);
        return root;
    }


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }


    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val > val) {
            TreeNode treeNode1 = searchBST(root.left, val);
            return treeNode1;
        }

        if (root.val < val) {
            TreeNode treeNode2 = searchBST(root.right, val);
            return treeNode2;
        }

        return root;
    }

    long s = Long.MIN_VALUE;

    //二叉搜索树中序遍历是顺序的
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }

        if (s <= root.val) {
            s = root.val;
        } else {
            return false;
        }

        boolean right = isValidBST(root.right);
        if (!right) {
            return false;
        }
        return left && right;
    }


/*

    TreeNode pre;
    TreeNode cur;
    int min=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return Integer.MAX_VALUE;
        }
        getMinimumDifference(root.left);
        if(pre==null){
            pre=root;
        }else {
            cur = root;
            min=Math.min(min, Math.abs(cur.val - pre.val));
            pre = root;

        }
        getMinimumDifference(root.right);
        return min;
    }


*/



   /* TreeNode pre;
    int count=0;
    int maxCount=0;
    ArrayList<Integer> arrayList;
    public int[] findMode(TreeNode root) {
        arrayList=new ArrayList<>();
        pre = null;

        test2(root);
        int[] ints = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ints[i]=arrayList.get(i);
        }
        return ints;
    }
    public void test2(TreeNode root) {
        if(root==null){
            return;
        }

        test2(root.left);

        if(pre==null){
            count=1;
        }else if (root.val==pre.val){
            count++;

        }else {
            count=1;
        }

        if(count==maxCount){
            arrayList.add(root.val);
        }
        if(count>maxCount){
            maxCount=count;
            arrayList.clear();
            arrayList.add(root.val);
        }
        pre=root;
        test2(root.right);
    }


*/


    int max = 0;
    HashMap<Integer, Integer> map = new HashMap();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        get(root);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                arrayList.add(entry.getKey());
            }
        }
        int[] ints = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ints[i] = arrayList.get(i);
        }
        return ints;
    }

    private void get(TreeNode root) {
        if (root == null) {
            return;
        }
        get(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        max = Math.max(map.get(root.val), max);
        get(root.right);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode treeNode = new TreeNode(val);
            return treeNode;
        }

        if (val < root.val) {
            TreeNode treeNode = insertIntoBST(root.left, val);
            root.left = treeNode;
        }
        if (val > root.val) {
            TreeNode treeNode = insertIntoBST(root.right, val);
            root.right = treeNode;
        }
        return root;
    }


    //五种情况+删除操作写在终止条件里
    public TreeNode deleteNode(TreeNode root, int key) {
        //遍历到空，没找到删除节点
        if (root == null) {
            return null;
        }

        //找到删除节点
        if (root.val == key) {

            //左右子树都是空（删除的是叶子节点）
            if (root.left == null && root.right == null) {
                return null;

                //左子树不为空，右为空
            } else if (root.left != null && root.right == null) {
                return root.left;

                //右子树为空，左为空
            } else if (root.left == null && root.right != null) {
                return root.right;

                //左右都不为空
            } else if (root.left != null && root.right != null) {

                //得到删除节点的右节点
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }//遍历到删除节点的右节点的最左侧节点（这个节点是比原节点大的最小节点）
                cur.left = root.left;
                //把删除节点的左节点作为右节点最左侧节点的左节点。
                return root.right;//并把删除节点的右节点作为返回节点
            }
        }

        //前面都是终止条件

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        return root;

    }


    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // root在[low,high]范围内
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }


    //字母****异味次
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }


    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int count = 0;
            while (set.contains(num)) {
                count++;
                num++;
            }
            max = Math.max(max, count);

        }
        return max;
    }


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] ints = new int[nums.length];
        int index = right;
        while (index >= 0) {
            int l = nums[left];
            int r = nums[right];
            if (l * l > r * r) {
                ints[index] = l * l;
                left++;
            } else {
                ints[index] = r * r;
                right--;
            }
            index--;
        }
        return ints;
    }


    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int yuan = n / 2;
        int hang = 0;
        int lie = 0;
        int sum = n;
        int count = 1;
        while (0 < yuan) {
            for (; lie < sum - 1; lie++) {
                res[hang][lie] = count++;
            }
            for (; hang < sum - 1; hang++) {
                res[hang][lie] = count++;
            }
            for (; lie > n - sum; lie--) {
                res[hang][lie] = count++;
            }
            for (; hang > n - sum; hang--) {
                res[hang][lie] = count++;
            }
            lie++;
            hang++;
            sum--;
            yuan--;
        }
        if (n % 2 == 1) {
            res[n / 2][n / 2] = count;
        }
        return res;
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int mid = nums[right];
                nums[right] = nums[left];
                nums[left] = mid;
                left++;
            }
            right++;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return lists;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
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
                    lists.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    //着玩儿是去重的逻辑
                    while (nums[right] == nums[right - 1] && right > left) right--;
                    while (nums[left] == nums[left + 1] && right > left) left++;
                    right--;
                    left++;
                }
            }
        }
        return lists;
    }


    public int trap(int[] height) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if (height[stack.peek()] >= height[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    Integer min = stack.pop();
                    if (!stack.isEmpty()) {
                        Integer left = stack.peek();
                        int board = i - left - 1;
                        int hight = Math.min(height[i], height[left]) - height[min];
                        max += board * hight;
                    }
                }
                stack.push(i);
            }
        }
        return max;
    }


    public int maxArea(int[] height) {
        int total = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int board = right - left;
            int hight = Math.min(height[left], height[right]);
            max = Math.max(hight * board, max);
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        return total;
    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
        return dummy.next;
    }


    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        dummy.next = head;
        ListNode cur = dummy;
        ListNode next = cur.next;
        while (next != null) {
            ListNode next1 = next.next;
            next.next = cur;
            cur = next;
            next = next1;
        }
        return cur;

    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode nextt = cur.next.next;
            ListNode next = cur.next;
            next.next = nextt.next;
            cur.next = nextt;
            cur.next.next = next;
            cur = cur.next.next;
        }
        return dummy.next;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = dummy;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }


    public boolean isAnagram(String s, String t) {
        int[] ints = new int[27];

        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            ints[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int total = 0;
            while (n > 0) {
                int i = n % 10;
                n = n / 10;
                total += i * i;
            }
            if (total == 1) {
                return true;
            }
            if (!set.contains(total)) {
                set.add(total);
            } else {
                return false;
            }
            n = total;
        }
    }


    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] ints = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ints[p.charAt(i) - 'a']++;
        }
        int[] res = new int[26];
        int left = 0, right = p.length() - 1;
        for (int i = 0; i <= right; i++) {
            res[s.charAt(i) - 'a']++;
        }
        while (right < s.length()) {
            int qsq = 0;

            for (int i = 0; i < ints.length; i++) {
                if (ints[i] != res[i]) {
                    qsq = 1;//只要有一个不同
                }
            }

            if (qsq == 0) {
                arrayList.add(left);
            }
            if (right == s.length() - 1) break;
            right++;
            res[s.charAt(right) - 'a']++;
            res[s.charAt(left) - 'a']--;
            left++;
        }
        return arrayList;
    }



    public int subarraySum(int[] nums, int k) {
        int count = 0;//着玩儿纯暴力就出来了啊，卧槽
        for (int left = 0; left < nums.length; left++) {
            int sum = 0;
            for (int right = left; right < nums.length; right++) {//唯一的细节就是这里而已
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            max = Math.max(max, right - left);
        }
        return max;

    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue(k);
        int[] res = new int[nums.length - k+1];
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        int index=0;
        for (int i = k; i <nums.length; i++) {

            res[index]=myQueue.deque.getFirst();
            myQueue.add(nums[i]);
            index++;
        }

        res[index]=myQueue.deque.getFirst();
        return res;
    }


    public static void main(String[] args) {
        newtry newtry = new newtry();
        newtry.maxSlidingWindow(new int[]{1,3,1,2,0,5},3);
        /*newtry.findAnagrams("cbaebabacd","abc");*/
        /*ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3= new ListNode(6);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        listNode6.next=listNode7;
        newtry.removeElements(listNode1,6);*/
    }






}
