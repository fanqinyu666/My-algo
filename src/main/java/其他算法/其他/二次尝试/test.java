package 其他算法.其他.二次尝试;

import java.util.*;

public class test {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right--;
            } else if (nums[mid] < target) {
                left++;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1, left = 0;
        int[] ints = new int[nums.length];
        int index = right;
        while (left <= right) {
            int ll = nums[left] * nums[left];
            int rr = nums[right] * nums[right];
            if (ll > rr) {
                ints[index] = ll;
                left++;
            } else {
                ints[index] = rr;
                right--;
            }
            index--;
        }
        return ints;
    }

    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
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

    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lM = height[l], rM = height[r];
        int max = 0;
        while (l < r) {
            lM = Math.max(lM, height[l]);
            rM = Math.max(rM, height[r]);
            if (Math.min(height[l], height[r]) == height[l]) {
                max += lM - height[l];
                l++;
            } else {
                max += rM - height[r];
                r--;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> characters = new HashSet<>();
        int max = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!characters.contains(c)) {
                characters.add(c);
                max = Math.max(max, right - left + 1);
                right++;
                continue;
            }
            while (characters.contains(c)) {
                char c1 = s.charAt(left);
                characters.remove(c1);
                left++;
            }
            characters.add(c);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = Math.min(intervals[i][0], intervals[i + 1][0]);
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            } else {
                lists.add(List.of(intervals[i][0], intervals[i][1]));
            }
        }
        lists.add(List.of(intervals[intervals.length - 1][0], intervals[intervals.length - 1][1]));
        int[][] ints = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++) {
            ints[i][0] = lists.get(i).get(0);
            ints[i][1] = lists.get(i).get(1);
        }
        return ints;
    }


    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 &&
                    nums[i] < nums.length + 1 &&
                    nums[i] != nums[nums[i] - 1]) {
                int num = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = num;
            }
        }
        for (int i = 0; i < nums.length; i++) if (nums[i] != i + 1) return i + 1;
        return nums.length + 1;
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

    public boolean searchMatrix(int[][] matrix, int target) {
        int tob = 0, right = matrix[0].length - 1;
        while (tob < matrix.length && right >= 0) {
            if (target > matrix[tob][right]) {
                tob++;
            } else if (target < matrix[tob][right]) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }


    public int searchInsert(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            int mid = head + (tail - head) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                tail = mid - 1;
                continue;
            }
            if (nums[mid] < target) {
                head = mid + 1;
                continue;
            }
        }
        return head;
    }

    public static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        LinkedList<pair> deque = new LinkedList<>();
        int refresh = 0, count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) refresh++;
                if (grid[i][j] == 2) deque.addLast(new pair(i, j));
            }
        }
        while (!deque.isEmpty() && refresh > 0) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                pair pair = deque.removeFirst();
                int curX = pair.getX();
                int curY = pair.getY();
                for (int j = 0; j < 4; j++) {
                    int nextX = curX + dir[j][0];
                    int nextY = curY + dir[j][1];
                    if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) continue;
                    if (grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = 2;
                        deque.addLast(new pair(nextX, nextY));
                        refresh--;
                    }
                }
            }
            count++;
        }
        if (refresh > 0) {
            return -1;
        } else {
            return count;
        }
    }


    public class pair {
        private int x;
        private int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ints = new int[nums2.length + nums1.length];
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = (m + n + 1) / 2;
            int left1=(i==0)?Integer.MIN_VALUE:nums1[i-1];
            int right1=(i==m)?Integer.MAX_VALUE:nums1[i];
            int left2=(j==0)?Integer.MIN_VALUE:nums2[j-1];
            int right2=(j==n)?Integer.MAX_VALUE:nums2[j];

        }
        int i = ints.length % 2;
        float res = 0;
        if (i == 0) {
            float f = ints[ints.length / 2];
            float q = ints[ints.length / 2 + 1];
            res = (f + q) / 2;
        } else {
            res = ints[ints.length / 2];
        }
        return res;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ints = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            map.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            ArrayList<Integer> arrayList = map.get(prerequisites[i][1]);
            arrayList.add(prerequisites[i][0]);
            //统计每个课程的入度，1，0.1被0指向，记录0
            ints[prerequisites[i][0]]++;
        }

        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        //得到入度为0的节点
        for (int i = 0; i < numCourses; i++) {
            if (ints[i] == 0) {
                deque.add(i);
                count++;
            }
        }


        //遍历入度为0的节点
        while (!deque.isEmpty()) {
            Integer remove = deque.remove();
            ArrayList<Integer> arrayList = map.getOrDefault(remove, new ArrayList<>());
            //遍历队列里的节点，把该节点相邻节点的入度-1
            for (int i = 0; i < arrayList.size(); i++) {
                Integer i1 = arrayList.get(i);
                ints[i1]--;
                if (ints[i1] == 0) {
                    deque.add(i1);
                    //这个节点入度为0时，入度为0的节点数+1
                    ++count;
                }
            }
        }
        return count == numCourses;

    }


    ArrayList<List<Integer>> lists=new ArrayList<List<Integer>>();
    ArrayList<Integer> list=new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        brack(candidates,0,target);
        return lists;
    }
    public void brack(int[] nums,int start,int target) {
        if(target==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(target<0)return;
        for (int i = start; i <nums.length; i++) {

            list.add(nums[i]);
            brack(nums,i,target-nums[i]);
            list.remove(list.size() - 1);
        }
    }
}