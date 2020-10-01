package s06;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 错误的版本不能实现功能
 */
public class Sync extends AbstractQueuedSynchronizer {
    public boolean tryAcquire(int acquires) {
        if (compareAndSetState(0, 1)) { // 竞争锁
            // 互斥锁 共享锁
            setExclusiveOwnerThread(Thread.currentThread());    // 设定当前线程持有该锁
            return true;
        }
        return false;
    }

    protected boolean tryRelease(int releases) {    // 释放
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    public boolean isHeldExclusively() {
        return getState() == 1;
    }

}
