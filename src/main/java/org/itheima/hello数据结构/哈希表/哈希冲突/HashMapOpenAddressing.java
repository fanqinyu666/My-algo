package org.itheima.hello数据结构.哈希表.哈希冲突;

/* 开放寻址哈希表 */
class HashMapOpenAddressing {
    private int size; // 键值对数量
    private int capacity = 4; // 哈希表容量
    private final double loadThres = 2.0 / 3.0; // 触发扩容的负载因子阈值
    private final int extendRatio = 2; // 扩容倍数
    private Pair[] buckets; // 桶数组
    private final Pair TOMBSTONE = new Pair(-1, "-1"); // 删除标记

    /* 构造方法 */
    public HashMapOpenAddressing() {//长度为4的
        size = 0;
        buckets = new Pair[capacity];//数组
    }

    /* 哈希函数 */
    private int hashFunc(int key) {
        return key % capacity;
    }

    /* 负载因子 */
    private double loadFactor() {
        return (double) size / capacity;
    }

    /* 搜索 key 对应的桶索引 */
    private int findBucket(int key) {
        int index = hashFunc(key);
        int firstTombstone = -1;

        // 线性探测，当遇到空桶时跳出
        while (buckets[index] != null) {

            // 若遇到 key ，返回对应的桶索引
            if (buckets[index].key == key) {

                // 若之前遇到了删除标记，则将键值对移动至该索引处
                if (firstTombstone != -1) {
                    buckets[firstTombstone] = buckets[index];
                    buckets[index] = TOMBSTONE;
                    //交换位置
                    return firstTombstone; // 返回移动后的桶索引
                }
                return index; // 返回桶索引
            }
            // 记录遇到的首个删除标记
            if (firstTombstone == -1 && buckets[index] == TOMBSTONE) {
                firstTombstone = index;
            }
            // 计算桶索引，越过尾部则返回头部
            index = (index + 1) % capacity;
        }
        // 若 key 不存在，则返回添加点的索引
        return firstTombstone == -1 ? index : firstTombstone;
    }

    /* 查询操作 */
    public String get(int key) {
        // 搜索 key 对应的桶索引
        int index = findBucket(key);

        // 若找到键值对，则返回对应 val
        if (buckets[index] != null && buckets[index] != TOMBSTONE) {
            return buckets[index].val;
        }

        // 若键值对不存在，则返回 null
        return null;
    }

    /* 添加操作 */
    public void put(int key, String val) {
        // 当负载因子超过阈值时，执行扩容
        if (loadFactor() > loadThres) {
            extend();
        }

        // 搜索 key 对应的桶索引
        int index = findBucket(key);

        // 若找到键值对，则覆盖 val 并返回
        if (buckets[index] != null && buckets[index] != TOMBSTONE) {
            buckets[index].val = val;
            return;
        }

        // 若键值对不存在，则添加该键值对
        buckets[index] = new Pair(key, val);
        size++;
    }

    /* 删除操作 */
    public void remove(int key) {
        // 搜索 key 对应的桶索引
        int index = findBucket(key);

        // 若找到键值对，则用删除标记覆盖它
        if (buckets[index] != null && buckets[index] != TOMBSTONE) {
            buckets[index] = TOMBSTONE;
            size--;
        }

    }

    /* 扩容哈希表 */
    private void extend() {
        // 暂存原哈希表
        Pair[] bucketsTmp = buckets;
        // 初始化扩容后的新哈希表
        capacity *= extendRatio;
        buckets = new Pair[capacity];
        size = 0;
        // 将键值对从原哈希表搬运至新哈希表
        for (Pair pair : bucketsTmp) {
            if (pair != null && pair != TOMBSTONE) {
                put(pair.key, pair.val);
            }
        }
    }

    /* 打印哈希表 */
    public void print() {
        for (Pair pair : buckets) {
            if (pair == null) {
                System.out.println("null");
            } else if (pair == TOMBSTONE) {
                System.out.println("TOMBSTONE");
            } else {
                System.out.println(pair.key + " -> " + pair.val);
            }
        }
    }
}