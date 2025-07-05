package 代码随想录.数组;

public class 移除元素 {

    public int removeDuplicates(int[] nums) {
        int left=1;
        int right=1;
        for (;right <nums.length; right++) {
            if(nums[left-1]!=nums[right]) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public void moveZeroes(int[] nums) {

        int left=0;
        int right=0;
        for (;right <nums.length; right++) {
            if(nums[right]!=0) {
                nums[left]=nums[right];
                left++;
            }
        }
        for (;left <nums.length;left++) {
            nums[left]=0;
        }
    }

    public boolean backspaceCompare(String s, String t) {
        String change1 = change(s);
        String change2 = change(t);
        return change2.equals(change1);
    }
    public String change(String str) {
       StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c!='#'){
                stringBuffer.append(c);
            }
        }
        String string = stringBuffer.toString();
        return string;
    }







}

