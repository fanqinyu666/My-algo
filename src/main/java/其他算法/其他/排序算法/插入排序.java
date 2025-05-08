package 其他算法.其他.排序算法;

public class 插入排序 {

    public static void main(String[] args) {
        插入排序 插入排序 = new 插入排序();
        插入排序.insertionSort2(new int[]{1,5,2,4,4});
    }
    /* 插入排序 */
    void insertionSort(int[] nums) {
        // 外循环：已排序区间为 [0, i-1]
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i], j = i - 1;
            // 内循环：将 base 插入到已排序区间 [0, i-1] 中的正确位置
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j]; // 将 nums[j] 向右移动一位
                j--;
            }
            nums[j + 1] = base;        // 将 base 赋值到正确位置
        }
    }

    /* 插入排序 */
    void insertionSort2(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int base = nums[i];
            int j = i;
            while (nums[i]<nums[j-1]){
                nums[j]=nums[j-1];
                j--;
            }
            nums[j]=base;

        }
    }



}
