package org.itheima.hello数据结构.数组与链表.列表;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 列表
/*列表（list）是一个抽象的数据结构概念，它表示元素的有序集合，支持元素访问、修改、添加、
删除和遍历等操作，无须使用者考虑容量限制的问题。列表可以基于链表或数组实现。链表天然可以
看作一个列表，其支持元素增删查改操作，并且可以灵活动态扩容。数组也支持元素增删查改，但由
于其长度不可变，因此只能看作一个具有长度限制的列表。当使用数组实现列表时，长度不可变的性
质会导致列表的实用性降低。这是因为我们通常无法事先确定需要存储多少数据，从而难以选择合适
的列表长度。若长度过小，则很可能无法满足使用需求；若长度过大，则会造成内存空间浪费。为解
决此问题，我们可以使用动态数组（dynamic array）来实现列表。它继承了数组的各项优点，并
且可以在程序运行过程中进行动态扩容。实际上，许多编程语言中的标准库提供的列表是基于动态数
组实现的，例如 Python 中的 list 、Java 中的 ArrayList 、C++ 中的 vector 和 C#
中的 List 等。在接下来的讨论中，我们将把“列表”和“动态数组”视为等同的概念。*/

public class list {
    public static void main(String[] args) {

        //列表的使用
        //列表里有这些方法


        /* 初始化列表 */
        // 无初始值
        List<Integer> nums1 = new ArrayList<>();


        // 有初始值（注意数组的元素类型需为 int[] 的包装类 Integer[]）
        Integer[] numbers = new Integer[] { 1, 3, 2, 5, 4 };
        List<Integer> nums = new ArrayList<>(Arrays.asList(numbers));



        /* 访问元素 */
        int num = nums.get(1);  // 访问索引 1 处的元素


        /* 更新元素 */
        nums.set(1, 0);  // 将索引 1 处的元素更新为 0


        /* 清空列表 */
        nums.clear();

        /* 在尾部添加元素 */
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(5);
        nums.add(4);

        /* 在中间插入元素 */
        nums.add(3, 6);  // 在索引 3 处插入数字 6


        /* 删除元素 */
        nums.remove(3);  // 删除索引 3 处的元素


        /* 通过索引遍历列表 */
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            count += nums.get(i);
        }
        System.out.println(nums.size());
        //和length一样是5,都是长度

        /* 直接遍历列表元素 */
        for (int num001 : nums) {
            count += num001;
        }

        /* 拼接两个列表 */
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(new Integer[] { 6, 8, 7, 10, 9 }));
        nums.addAll(nums1);  // 将列表 nums1 拼接到 nums 之后

    }


    ArrayList arrayList=new ArrayList<>();
    int[] aa={1,2,3,4,5};
    Integer[] integers=new Integer[]{1,2,3};
    ArrayList arrayList1=new ArrayList<>(Arrays.asList(aa));
    //数组构造列表
    ArrayList arrayList2=new ArrayList<>(Arrays.asList(integers));
    //封装数据构造列表

}
