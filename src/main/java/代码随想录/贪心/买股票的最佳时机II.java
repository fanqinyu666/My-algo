package 代码随想录.贪心;

public class 买股票的最佳时机II {


    public int maxProfit2(int[] prices) {
        int total=0;
        for(int i=1;i<prices.length;i++){
            int i1 = prices[i] - prices[i - 1];
            if(i1>0) {
                total+=i1;
            }
        }
        return total;
    }

    public int maxProfit(int[] prices) {
        int max=0;
        int sou=prices[0];
        for(int i=0;i<prices.length;i++){
            if(prices[i]<sou)sou=prices[i];
            if(prices[i]>sou)max=Math.max(max,prices[i]-sou);
        }
        return max;
    }

    public static void main(String[] args) {
        买股票的最佳时机II 买股票的最佳时机II = new 买股票的最佳时机II();
        买股票的最佳时机II.maxProfit(new int[]{7,1,5,3,6,4});
    }

}
