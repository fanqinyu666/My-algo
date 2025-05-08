package 代码随想录.哈希表;

import java.util.*;

public class 字母异味次分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> res = new HashMap<Integer, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            int sum=0;
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                int i1 = c - 'a';
                sum+=i1;
            }
            if(res.containsKey(sum)){
                List<String> strings = res.get(sum);
                strings.add(str);
            }else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                res.put(sum,list);
            }
        }

        return new ArrayList<List<String>>(res.values());

    }
    public List<List<String>> groupAnagrams2(String[] strs) {
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
}
