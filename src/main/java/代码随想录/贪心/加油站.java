package 代码随想录.贪心;

public class 加油站 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0;
        for (int i = 0; i < gas.length; i++) {
            total=total+gas[i]-cost[i];
        }
        if(total<0){
            return -1;
        }
        int sum=0;
        int start=0;
        for (int i = 0; i < gas.length; i++) {
            sum+= gas[i] - cost[i];
            if(sum<0){
                sum=0;
                start=i+1;
            }
        }
        return start;
    }






}
