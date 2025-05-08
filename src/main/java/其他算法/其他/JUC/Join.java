package 其他算法.其他.JUC;
public class Join {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Thread thread1 = Thread.currentThread();
                    if(thread1.isInterrupted()){
                        System.out.println("处理后事");
                        System.out.println("被打断");
                        break;
                    }
                    try {
                        Thread.sleep(50);
                        System.out.println("监控期间");
                    } catch (InterruptedException e) {
                        thread1.interrupt();
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }






}
