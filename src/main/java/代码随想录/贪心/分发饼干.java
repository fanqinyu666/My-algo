package 代码随想录.贪心;

import java.util.Arrays;

public class 分发饼干 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res=0;
        int index=s.length-1;
        for (int i = g.length-1; i >=0 ; i--) {
            while (index>=0&&s[index]>=g[i]){
                res++;
                index--;//有可能为负数所以上面再加一个条件
                break;
            }
        }
        return res;
    }


    public int findContentChildr2en(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0;
        for (int i=0; i <s.length ; i++) {
            if(j==g.length){
                break;
            }
            if (s[i]>=g[j]) {
                j++;
            }
        }
        return j;
    }
}
