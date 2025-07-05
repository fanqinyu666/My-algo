package 其他算法.其他.设计模式.责任链;
/*
// 具体处理器A
class ConcreteHandlerA implements Handler {

    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }



    public void handle(Request request) {
        if ("A".equals(request.getType())) {
            System.out.println("HandlerA处理：" + request.getContent());
        } else if (next != null) {
            next.handle(request);
        }
    }


}
*/