package 代码面试经典150.数组字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> arrayList;
    public RandomizedSet() {
        map=new HashMap<Integer,Integer>();
        arrayList=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))return false;
        arrayList.add(val);
        map.put(val,arrayList.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))return false;
        //先做交换
        Integer i = arrayList.get(arrayList.size() - 1);
        arrayList.set(map.get(val),i);
        //再更新map和末尾
        map.put(i,map.get(val));
        map.remove(val);
        arrayList.remove(arrayList.size()-1);
        return true;
    }
    

    public int getRandom() {
        Random random=new Random();
        // 使用 nextInt(bound) 既安全又方便
        return arrayList.get(random.nextInt(arrayList.size()));
    }

}