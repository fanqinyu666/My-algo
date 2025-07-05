package 其他算法.其他.JUC.原子类;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    public static void main(String[] args) {
        int a=4;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.decrementAndGet());
        System.out.println(atomicInteger.getAndDecrement());
        //++i,i++,--i,i--

        System.out.println(atomicInteger.getAndAdd(5));
        //随意增加

        //这两部是一起的
        System.out.println(atomicInteger.updateAndGet(x->x*5));
        System.out.println(atomicInteger.get());


        //这就是CAS，我们上面方法内部已经封装好了这个
        atomicInteger.compareAndSet(a,5);
    }

}
