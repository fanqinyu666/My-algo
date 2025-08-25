package 其他算法.其他.排序算法;

public class 快排 {

    public void quick(int[] sum,int left,int right){
        if(left>=right)return;
        int jizhun = saobin(sum, left, right);
        quick(sum,jizhun+1,right);
        quick(sum,left,jizhun-1);
    }

    public int saobin(int[] sum,int left,int right) {
        //中间
        int jizhun=left+(right-left)/2;
        int res = sum[jizhun];
        swap(sum, left, jizhun);

        int l=left;
        int r=right;
        while (l<r){
            while (l<r&&res<=sum[r])r--;
            while (l<r&&res>=sum[l])l++;
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
