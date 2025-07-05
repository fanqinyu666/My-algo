package 其他算法.其他.设计模式.责任链;

// 请求对象
class Request {
    private String type;
    private String content;
    public Request(String type, String content) {
        this.type = type;
        this.content = content;
    }
    // getters...
}