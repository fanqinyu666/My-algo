package 算法复习.回溯复习;

import java.util.*;

public class 贪心 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = 0;
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (n == g.length) break;
            if (s[i] >= g[n]) {
                count++;
                n++;
            }
        }
        return count;
    }


    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int curDiff = 0;
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff < 0) || (curDiff < 0 && preDiff > 0)) {
                count++;
                preDiff = curDiff;
            }
            if (curDiff == 0) {
                preDiff = curDiff;
            }
        }
        return count;
    }


    public int maxSubArray(int[] nums) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            max = Math.max(max, count);
            if (count < 0) {
                count = 0;
            }
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int count = 0;

        for (int i = 1; i < prices.length; i++) {
            int i1 = prices[i] - prices[i - 1];
            if (i1 > 0) {
                count += i1;
            }
        }
        return count;

    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int count = 0;
        for (int i = 0; i <= count; i++) {
            count = Math.max(count, nums[i] + i);
            if (count >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }


    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int curDistance = 0;
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }


    public int largestSumAfterKNegations(int[] nums, int k) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                if (min == nums[j]) {
                    index = j;
                }
            }
            nums[index] = -min;
            min = Integer.MAX_VALUE;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        return sum;
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] gass = new int[gas.length * 2];
        int[] costs = new int[gas.length * 2];
        for (int i = 0; i < gas.length; i++) {
            gass[i] = gas[i];
        }
        for (int i = 0; i < gas.length; i++) {
            gass[i + gas.length] = cost[i];
        }

        for (int i = 0; i < cost.length; i++) {
            costs[i] = cost[i];
        }
        for (int i = 0; i < cost.length; i++) {
            costs[i + cost.length] = cost[i];
        }
        int start = 0;
        int sum = 0;
        int total = 0;
        for (int i = 0; i < start + gas.length; i++) {
            sum = sum + gass[i] - costs[i];
            total = total + gass[i] - costs[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        if (total < 0) {
            return -1;
        } else {
            return start;
        }
    }


    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            res[i] = 1;
        }
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && (ratings[i] > ratings[i - 1])) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += res[i];
        }
        return sum;
    }


    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            }
            if (bill == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            que.add(people[i][1], people[i]);
            //两个参数，将value插入指定下标，前面是下标，后面是value
        }
        return que.toArray(new int[people.length][]);
    }


    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int count = 1;
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i][1] < points[i + 1][0]) {
                count++;
            } else {
                points[i + 1][1] = Math.min(points[i + 1][1], points[i][1]);
            }
        }
        return count;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                count++;
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            }
        }
        return count;
    }


    public List<Integer> partitionLabels(String s) {
        int[] hash = new int[27];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int right = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, hash[s.charAt(i) - 'a']);
            if (i == right) {
                arrayList.add(i-left);
                left = i;
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        贪心 ts = new 贪心();
        ts.partitionLabels("ababcbacadefegdehijhklij");

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> ints = new ArrayList<>();
        int count=intervals.length;
        for (int i = 1; i < intervals.length; i++) {

            if(intervals[i-1][1] >= intervals[i][0]) {
                intervals[i][0] = Math.min(intervals[i-1][0],intervals[i][0]);
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            }else {
                ints.add(intervals[i-1]);
            }
        }
        ints.add(intervals[intervals.length-1]);
        return ints.toArray(new int[ints.size()][]);
    }




    //4种情况
    int res=0;
    public int minCameraCover(TreeNode root) {
        int trantce = trantce(root);
        if(trantce==0){
            res++;
        }
        return res;

    }
    private int trantce(TreeNode root) {
        if (root == null) return 2;
        int left = trantce(root.left);
        int right = trantce(root.right);
        if(left==2&&right==2) {
            return 0;
        }
        if(left==0||right==0) {
            res++;
            return 1;
        }
        if(left==1||right==1) {
            return 2;
        }
        return -1;
        //随便返回，反正走不到这里
    }


}
