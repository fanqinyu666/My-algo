package 代码随想录.贪心;

public class 分发糖果 {

    public int candy(int[] ratings) {
        int sum=0;
        int[] first = new int[ratings.length];
        first[0]=1;
        for (int i = 1; i < first.length; i++) {
            if (ratings[i]>ratings[i-1]) {
                first[i]=first[i-1]+1;
            }
            else {
                first[i]=1;
            }
        }
        int[] second = new int[ratings.length];
        second[ratings.length-1]=1;
        for (int i = ratings.length-2; i>=0; i--) {
            if(ratings[i]>ratings[i+1]){
                second[i]=second[i+1]+1;
            }else {
                second[i]=1;
            }

        }
        for (int i = 0; i < ratings.length; i++) {
            sum=sum+Math.max(first[i],second[i]);
        }

    return sum;
    }
}
