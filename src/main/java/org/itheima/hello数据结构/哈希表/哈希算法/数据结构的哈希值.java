package org.itheima.hello数据结构.哈希表.哈希算法;

import java.util.Arrays;

public class 数据结构的哈希值 {
    int num = 3;
    int hashNum = Integer.hashCode(num);
// 整数 3 的哈希值为 3

    boolean bol = true;
    int hashBol = Boolean.hashCode(bol);
// 布尔量 true 的哈希值为 1231

    double dec = 3.14159;
    int hashDec = Double.hashCode(dec);
// 小数 3.14159 的哈希值为 -1340954729

    String str = "Hello 算法";
    int hashStr = str.hashCode();
// 字符串“Hello 算法”的哈希值为 -727081396

    Object[] arr = { 12836, "小哈" };
    int hashTup = Arrays.hashCode(arr);
// 数组 [12836, 小哈] 的哈希值为 1151158

    ListNode obj = new ListNode(0);
    int hashObj = obj.hashCode();
// 节点对象 utils.ListNode@7dc5e7b4 的哈希值为 2110121908

}
