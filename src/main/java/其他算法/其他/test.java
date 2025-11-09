package 其他算法.其他;
import 算法复习.复习2.LRUCache;

import java.util.*;

public class test {
    public int trap(int[] height) {
        int total=0;
        int l=0,r=height.length-1;
        int lM=height[l],rM=height[r];
        while (l<r){
            lM=Math.max(lM,height[l]);
            rM=Math.max(rM,height[r]);
            if (lM>rM) {
                total+=rM-height[r];
                r--;
            }else {
                total+=lM-height[l];
                l++;
            }
        }
        return total;
    }
}
