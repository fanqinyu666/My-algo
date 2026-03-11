package 其他算法.排序算法;

public class 堆排序 {

    //排序方法
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int n = arr.length;

        //建堆-时间复杂度 O(n)，从最后一个非叶子节点开始，依次向前、向下进行堆化调整
        for (int i = n / 2 - 1; i >= 0; i--)heapify(arr, n, i);

        //排序-时间复杂度 O(n log n)，经过上面的建堆，此时 arr[0] 已经是最大值（大根堆）
        for (int i = n - 1; i > 0; i--) {
            // 将堆顶（最大值 arr[0]）与当前未排序部分的最后一个元素 arr[i] 交换
            swap(arr, 0, i);
            // 交换后，新的堆顶元素可能破坏了堆的性质，需要重新向下调整，此时堆的大小缩小为 i（因为排好序的最大值不再参与调整）
            heapify(arr, i, 0);
        }
    }

    //堆化方法（向下调整）
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;          // 假设当前父节点是最大值
        //左右节点下标
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 检查左/右孩子是否越界，且左/右孩子的值是否大于当前最大值
        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest])largest = right;


        // 如果最大值不是最初的父节点，说明孩子节点比它大，需要交换
        if (largest != i) {
            swap(arr, i, largest);
            // 交换后，被换下去的父节点所在的那棵子树可能不再满足堆的性质
            // 因此需要递归地继续往下调整
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试代码
    public static void main(String[] args) {
        // 使用您笔记中的一组无序数据作为示例
        int[] arr = {7, 19, 18, 27, 53, 30, 51, 48, 48, 60};
        System.out.println("排序前:");
        printArray(arr);

        heapSort(arr);

        System.out.println("排序后:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

}
