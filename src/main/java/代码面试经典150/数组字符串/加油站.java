package 代码面试经典150.数组字符串;

public class 加油站 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] gass=new int[gas.length*2];
        int[] costs=new int[gas.length*2];
        for(int i=0;i<gas.length;i++){
            gass[i]=gas[i];
        }
        for(int i=0;i<gas.length;i++){
            gass[i+gas.length]=cost[i];
        }

        for(int i=0;i<cost.length;i++){
            costs[i]=cost[i];
        }
        for(int i=0;i<cost.length;i++){
            costs[i+cost.length]=cost[i];
        }
        int start=0;
        int sum=0;
        int total=0;
        for(int i=0;i<start+gas.length;i++){
            sum=sum+gass[i]-costs[i];
            total=total+gass[i]-costs[i];
            if(sum<0){
                sum=0;
                start=i+1;
            }
        }
        if(total<0){
            return -1;
        }else {
            return start;
        }
    }

}
