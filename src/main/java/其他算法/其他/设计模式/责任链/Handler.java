package 其他算法.其他.设计模式.责任链;

// 处理器接口
interface Handler {

    void setNext(java.util.logging.Handler next);

    void handle(Request request);

}