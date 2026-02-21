package 其他算法.排序算法;

public class test {

    public void quick(int[] sum,int left,int right) {
        if(left<right)return;
        int mid = shaobin(sum, left, right);
        quick(sum,mid+1,right);
        quick(sum,left,mid-1);
    }

    private int shaobin(int[] sum, int left, int right) {
        int mid=left+(right-left)/2;
        swap(sum,mid,left);
        int l=left,r=right;
        while (l<r){
            while (l<r&&sum[r]>=sum[left])r--;
            while (l<r&&sum[l]<=sum[left])l++;
            swap(sum,l,r);
        }
        swap(sum,left,l);
        return l;
    }

    public void swap(int[] sum,int left,int right){
        int num = sum[left];
        sum[left]=sum[right];
        sum[right]=num;
    }
}
