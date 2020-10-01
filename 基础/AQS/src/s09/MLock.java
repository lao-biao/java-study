package s09;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MLock implements Lock {

    private Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
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
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    /**
     * 使用内部类--推荐写法
     */
    private class Sync extends AbstractQueuedSynchronizer {

        @Override
        public boolean tryAcquire(int acquires) {
            assert acquires == 1;
            if (compareAndSetState(0, 1)) { // 竞争锁
                // 互斥锁 共享锁
                setExclusiveOwnerThread(Thread.currentThread());    // 设定当前线程持当前锁
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int releases) {    // 释放
            assert releases == 1;
            if (!isHeldExclusively()) throw new IllegalMonitorStateException(); // 判断当前线程是否持有当前锁
            setExclusiveOwnerThread(null);
            setState(0);    // 释放
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

    }
}
