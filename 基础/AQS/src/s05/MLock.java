package s05;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MLock implements Lock {

    private volatile int i = 0; //0被释放，1锁定

    @Override
    public void lock() {
        synchronized (this) {
            while (i != 0) {    //已经有线程占用
                try {
                    this.wait();    //等待，也可使用CAS自旋
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i = 1;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        synchronized (this) {
            i = 0;
            this.notifyAll();   //唤醒其他等待该锁的线程
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
