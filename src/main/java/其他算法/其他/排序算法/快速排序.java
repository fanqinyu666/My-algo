package 其他算法.其他.排序算法;

public class 快速排序 {

    public int saobin(int[] sum,int left,int right){
        int i=left;
        int j=right;
        while (i<j){
            while (i<j&&sum[left]<=sum[j])j--;
            while (i<j&&sum[left]>=sum[i])i++;
            swap(sum,i,j);
        }
        swap(sum,left,i);
        return i;
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
        if(left>=right)return;

        int shaobin = shaobin(sum, left, right);
        quick(sum,left,shaobin-1);
        quick(sum,shaobin+1,right);

    }






}
