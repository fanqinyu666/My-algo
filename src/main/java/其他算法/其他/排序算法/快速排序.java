package 其他算法.其他.排序算法;

public class 快速排序 {

    public void swap(int[] sum ,int left,int right){
        int i = sum[left];
        sum[left]=sum[right];
        sum[right]=i;
    }

    public int saobin(int[] sum,int left,int right){
        int i=left;
        int j=right;
        while (i<j){
            while (i<j&&sum[left]<=sum[j])j--;
            while (i<j&&sum[left]>=sum[i])i++;
            swap(sum,i,j);
        }
        swap(sum,sum[left],i);
        return i;
    }

    public void quick(int[] sum,int left,int right){
        if(left>=right){
            return;
        }
        int jizhu=saobin(sum,left,right);

        quick(sum,left,jizhu-1);
        //递归左数组
        quick(sum,jizhu+1,right);
        //递归右数组
    }




























}
