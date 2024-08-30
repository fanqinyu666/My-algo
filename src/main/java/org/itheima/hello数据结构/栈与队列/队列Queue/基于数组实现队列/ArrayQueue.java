package org.itheima.hello数据结构.栈与队列.队列Queue.基于数组实现队列;

/* 基于环形数组实现的队列 */
//实现栈的是动态数组(队列Queue),所以用arraylist集合
//实现队列用的是环形数组
class ArrayQueue {

    //near=front+size，队首索引加数组长度等于队尾元素的下一个索引
    //数组索引属于 [front,rear-1]

    private int[] nums; // 用于存储队列元素的数组
    private int front; // 队首指针，指向队首元素
    private int queSize; // 队列长度

    public ArrayQueue(int capacity) {
        nums = new int[capacity];
        front = queSize = 0;
    }

    /* 获取队列的容量 */
    public int capacity() {
        return nums.length;
    }

    /* 获取队列的长度 */
    public int size() {
        return queSize;
    }

    /* 判断队列是否为空 */
    public boolean isEmpty() {
        return queSize == 0;
    }



    /* 入队 */
    public void push(int num) {
        if (queSize == capacity()) {
            System.out.println("队列已满");
            return;
        }

        // 计算队尾指针，指向队尾索引 + 1
        // 通过取余操作实现 rear 越过数组尾部后回到头部

        //front+queSize,队首加队列长度等于队尾+1
        //(队尾+1)%数组长度
        int rear = (front + queSize) % capacity();
        // 将 num 添加至队尾
        nums[rear] = num;
        queSize++;
    }

    /* 出队 */
    public int pop() {
        int num = peek();
        // 队首指针向后移动一位，若越过尾部，则返回到数组头部
        front = (front + 1) % capacity();
        queSize--;
        return num;
    }

    /* 访问队首元素 */
    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return nums[front];
    }

    /* 返回数组 */
    public int[] toArray() {
        // 仅转换有效长度范围内的列表元素
        int[] res = new int[queSize];
        for (int i = 0, j = front; i < queSize; i++, j++) {
            res[i] = nums[j % capacity()];
        }
        return res;
    }
}


/*在数组中删除首元素的时间复杂度为
 ，这会导致出队操作效率较低。然而，我们可以采用以下巧妙方法来避免这个问题。

我们可以使用一个变量 front 指向队首元素的索引，并维护一个变量 size 用于记录队列长度。定义 rear = front + size ，
这个公式计算出的 rear 指向队尾元素之后的下一个位置。

基于此设计，数组中包含元素的有效区间为 [front, rear - 1]，各种操作的实现方法如图 5-6 所示。

入队操作：将输入元素赋值给 rear 索引处，并将 size 增加 1 。
出队操作：只需将 front 增加 1 ，并将 size 减少 1 。
可以看到，入队和出队操作都只需进行一次操作，时间复杂度均为
 。*/

/*
以上实现的队列仍然具有局限性：其长度不可变。然而，这个问题不难解决，
我们可以将数组替换为动态数组，从而引入扩容机制。有兴趣的读者可以尝试自行实现。
*/