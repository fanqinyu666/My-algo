package 其他算法.JUC.JUC设计模式.两阶段终止;

public class 两阶段终止2 {

    private volatile boolean stop=false;

    public void test() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if (stop) {
                        //被打断了，结束
                        System.out.println("<UNK>");
                        break;
                    }

                    try {
                        //继续睡
                        System.out.println("kal");
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        thread.start();
        Thread.sleep(100);
        stop=true;
        thread.interrupt();//如果你不希望他多等1s，可以打断，不过内部什么都不需要做了
    }

}
