AQS:AbstractQueuedSynchronizer 抽象队列同步器
所在包:java.util.concurrent.locks.AbstractQueuedSynchronizer;
先进先出队列:CLH 

``
ReentrantLock
Semaphore
CountDownLatch
ReentrantReadWriteLock
``

偏向锁:偏向第一个线程(JDK1.6) JVM内部
轻量级锁
自旋锁 ----(自旋10次)-->重量级锁  悲观锁

Synchronized 在JDK1.5之前被视为重量级锁，在JDK1.6以后视为轻量级锁
JVM--OS
用户--kernel (费时)

JDK1.5之后在JVM添加各种锁，不需要再与OS交互
接口　　
public interface Lock{
    void lock();
}

CAS Compare and Swap
CAS 必须是原子操作 
现代CPU都支持CAS CAS属于乐观锁

Synchronized--适合-->高并发（超高并发，锁代码执行时间长）
    调用wait()    阻塞线程    不消耗cpu
CAS--适合--锁的竞争不激烈
    for循环 while(true) 消耗cpu

AbstractQueuedSynchronizer 官方实现Lock模板：Mutex.java

volatile关键字 
    1.线程（内存）在写入变量后立即提交给主线程（内存），其他线程可见其改变
    2.禁止指令重排序--单例模式中懒汉式
        synchronized 防止指令重排
        instance=new Instance()【只执行第2步和第4步】 半初始化，使用volatile修饰instance禁止指令重排序
        

​     CountDownLatch 基于AQS实现的