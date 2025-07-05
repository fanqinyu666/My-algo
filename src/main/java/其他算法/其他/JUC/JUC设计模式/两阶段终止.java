package 其他算法.其他.JUC.JUC设计模式;

public class 两阶段终止 {

    public static void main(String[] args) throws InterruptedException {
        Thread ss = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("<UNK>");
                        break;
                    }
                    System.out.println("kal");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("<UNK>");
                        break;
                    }
                }
            }
        });
        ss.start();
        Thread.sleep(100);
        ss.interrupt();

    }

    private volatile boolean stop=false;

    public void test() throws InterruptedException {
        Thread ss = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if (stop) {
                        System.out.println("<UNK>");
                        break;
                    }
                    System.out.println("kal");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        //这里不需要了
                    }
                }
            }
        });
        ss.start();
        Thread.sleep(100);
        stop=true;
        ss.interrupt();//如果你不希望他多等1s，可以打断，不过内部什么都不需要做了
    }




}
