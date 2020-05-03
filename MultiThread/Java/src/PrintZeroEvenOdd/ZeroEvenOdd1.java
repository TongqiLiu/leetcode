package src.PrintZeroEvenOdd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author mingqiao
 * @Date 2020/3/6
 */
public class ZeroEvenOdd1 {

    private int n;

    //volatile这里其实不使用也可以，turn表示此时轮到哪种线程类型了
    private volatile int turn;
    private volatile int start = 1;

    private Lock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (turn != 0) {
                    zero.await();
                }
                printNumber.accept(0);
                if (start % 2 == 0) {
                    turn = 2;
                    even.signal();
                } else {
                    turn = 1;
                    odd.signal();
                }
                zero.await();
            }
            //循环结束后两个锁释放掉
            odd.signal();
            even.signal();
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (turn != 2) {
                    even.await();
                } else {
                    printNumber.accept(start++);
                    turn = 0;
                    zero.signal();
                }
            }
            //System.out.println(start);
        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (turn != 1) {
                    odd.await();
                } else {
                    printNumber.accept(start++);
                    turn = 0;
                    zero.signal();
                }
            }
            //System.out.println(start);
        } finally {
            lock.unlock();
        }
    }
}
