package 代码面试经典150.数组字符串;

public class 分发糖果 {

    public int candy(int[] ratings) {
        int [] res=new int[ratings.length];
        for(int i=0;i<ratings.length;i++){
            res[i]=1;
        }
        //从左向右遍历
        for (int i = 0; i < ratings.length; i++) {
            if (i>0&&(ratings[i] > ratings[i-1])) res[i]=res[i-1]+1;
        }
        //从右向左遍历
        for (int i =ratings.length-1; i>=0; i--) {
            if(i<ratings.length-1&&ratings[i]>ratings[i+1])res[i]= Math.max(res[i], res[i + 1] + 1);
        }
        int sum=0;
        for (int i = 0; i < ratings.length; i++)sum+=res[i];
        return sum;
    }


}
