package 其他算法.其他.JUC;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class DIY {
    public static void main(String[] args) {
        pool pool = new pool(2);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Connection borrow = pool.borrow();
                    System.out.println(Thread.currentThread());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }finally {
                        pool.free(borrow);
                    }
                }
            }).start();
        }
    }
}

class pool{
    //连接池大小
    private int captity;
    //连接对象数组
    private Connection[] connections;
    //连接状态数组,一个集合里有很多线程，每个线程有状态，0.空闲，1.繁忙。而且多线程下一定要线程安全用原子类
    private AtomicIntegerArray status;

    public pool(int captity) {
        this.captity = captity;
        connections=new Connection[captity];
        status=new AtomicIntegerArray(captity);
        for (int i = 0; i < captity; i++) {
            connections[i]=new MockConnection();//全部初始化出来
        }
    }
    //获取连接
    public Connection borrow(){//你要借就要一直借用，当然你后续可以加最大尝试时间
        while (true){//虚假唤醒问题，其实我们如果每次就唤醒一个，这里可以if，但是虚假唤醒绝对用while，不要有叫醒
            for (int i = 0; i <captity ; i++) {
                if (status.get(i)==0) {//多线程下需要双重判断
                    if (status.compareAndSet(i,0,1)) {//原子类里可以cas代替第二个判断
                        return connections[i];//成功的才返回
                    }
                }
            }
            //如果一轮没用空闲连接，可以进入等待一下
            synchronized (this){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    //归还连接
    public void free(Connection connection){
        for (int i = 0; i < captity; i++) {
            if (connections[i]==(connection)) {
                status.set(i,0);//没线程安全问题
                synchronized (this) {//wc细节，这个要在这里
                    this.notify();//这里我们就唤醒一个就行，不用全部唤醒，可以简单的避免虚假
                }
                break;
            }
        }

    }

}
class MockConnection implements Connection{

    @Override
    public Statement createStatement() throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return null;
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return null;
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {

    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return false;
    }

    @Override
    public void commit() throws SQLException {

    }

    @Override
    public void rollback() throws SQLException {

    }

    @Override
    public void close() throws SQLException {

    }

    @Override
    public boolean isClosed() throws SQLException {
        return false;
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return null;
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {

    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return false;
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {

    }

    @Override
    public String getCatalog() throws SQLException {
        return null;
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {

    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return 0;
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return null;
    }

    @Override
    public void clearWarnings() throws SQLException {

    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return null;
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return null;
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

    }

    @Override
    public void setHoldability(int holdability) throws SQLException {

    }

    @Override
    public int getHoldability() throws SQLException {
        return 0;
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return null;
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return null;
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {

    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {

    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return null;
    }

    @Override
    public Clob createClob() throws SQLException {
        return null;
    }

    @Override
    public Blob createBlob() throws SQLException {
        return null;
    }

    @Override
    public NClob createNClob() throws SQLException {
        return null;
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return null;
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return false;
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {

    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {

    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return null;
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return null;
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return null;
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return null;
    }

    @Override
    public void setSchema(String schema) throws SQLException {

    }

    @Override
    public String getSchema() throws SQLException {
        return null;
    }

    @Override
    public void abort(Executor executor) throws SQLException {

    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return 0;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}







