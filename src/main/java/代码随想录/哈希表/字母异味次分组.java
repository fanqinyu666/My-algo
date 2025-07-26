package 代码随想录.哈希表;

import java.util.*;

public class 字母异味次分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        //最麻烦的就是很多层集合
        ArrayList<List<String>> lists = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            char[] charArray = strs[i].toCharArray();
            //排序
            Arrays.sort(charArray);
            //不能用toString，必须new，不然类似C@1b6d3586
            String s = new String(charArray);
            List<String> orDefault = map.getOrDefault(s, new ArrayList<String>());
            orDefault.add(strs[i]);
            map.put(s,orDefault);
        }
        //foreach的遍历方式一定要学会map.entrySet()
        for (Map.Entry entry:map.entrySet()){
            lists.add((List<String>) entry.getValue());
        }
        return lists;
    }
}
