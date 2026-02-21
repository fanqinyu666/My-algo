package 其他算法.面试变种;

public class 找出数组中两个唯一数字 {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2, 8, 5, 4}; // 结果应该是 8 和 5
        int[] result = findTwoSingleNumbers(nums);
        System.out.println("这两个只出现一次的数字是: " + result[0] + " 和 " + result[1]);
    }

    public static int[] findTwoSingleNumbers(int[] nums) {
        // 1. 全员异或
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }

        // 2. 找到异或结果中最低位的 1 (diff)
        // 这个位可以将 A 和 B 区分开
        int diff = xorResult & (-xorResult);

        int num1 = 0;
        int num2 = 0;

        // 3. 分组异或
        for (int num : nums) {
            if ((num & diff) == 0) {
                // 第 k 位为 0 的组
                num1 ^= num;
            } else {
                // 第 k 位为 1 的组
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }
}
