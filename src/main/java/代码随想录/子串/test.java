package 代码随想录.子串;

import java.util.*;

public class test {
    public static void main(String[] args) {
        test test = new test();
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }
    public int[] productExceptSelf(int[] nums) {
        int[] is = new int[nums.length];
        int[] os = new int[nums.length];
        is[0]=1;
        os[os.length-1]=1;
        for (int i=1;i<nums.length;i++){
            is[i]=is[i-1]*nums[i-1];
        }
        for (int i=nums.length-2;i>=0;i--){
            os[i]=os[i+1]*nums[i+1];
        }

        int[] res = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            res[i]=is[i]*os[i];
        }
        return res;
    }

    public int firstMissingPositive(int[] nums) {
        for (int i=0;i<nums.length;i++){
            //nums[i]!=nums[nums[i]-1]这个判断必须写while上，不能写里面，不然会死循环
            //我理解这个意思了，如果nums[i]=3，nums[i]！=nums[nums[i]-1]，3！=nums[2]
            while (0<nums[i]&&nums[i]<=nums.length&&
                    nums[i]!=nums[nums[i]-1]){
                int num = nums[i];
                nums[i]=nums[num-1];
                nums[num-1]=num;
            }
        }

        for (int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
    public void setZeroes(int[][] matrix) {
        boolean ish=false;
        boolean isl=false;
        for (int i = 0; i <matrix.length; i++) if(matrix[i][0]==0)ish=true;
        for (int i = 0; i <matrix[0].length; i++) if(matrix[0][i]==0)isl=true;

        for (int i=1;i<matrix.length;i++){
            for (int j = 1; j <matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if(matrix[i][0]==0){
                for (int j = 0; j <matrix[0].length; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i]==0){
                for (int j = 0; j <matrix.length; j++) {
                    matrix[j][i]=0;
                }
            }
        }

        if(ish){
            for (int i = 0; i <matrix.length; i++) {
                matrix[i][0]=0;
            }
        }
        if(isl){
            for (int i = 0; i <matrix[0].length; i++) {
                matrix[0][i]=0;
            }
        }
    }









}