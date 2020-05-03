package src.TheDiningPhilosophers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mingqiao
 * @Date 2020/3/15
 */
public class DiningPhilosophers {

    private ReentrantLock[] locks;

    private Semaphore eatLimit;

    public DiningPhilosophers() {
        //5个自旋锁叉子，最多只有4个哲学家去持有叉子
        locks = new ReentrantLock[] {new ReentrantLock(), new ReentrantLock(), new ReentrantLock(),
            new ReentrantLock(), new ReentrantLock()};
        eatLimit = new Semaphore(4);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        //左右手叉子编号
        int leftForkId = (philosopher + 1) % 5;
        int rightForkId = philosopher;

        //请求拿起叉子
        eatLimit.acquire();

        //左右叉子上锁
        locks[leftForkId].lock();
        locks[rightForkId].lock();

        //拿起叉子
        pickLeftFork.run();
        pickRightFork.run();

        //吃饭
        eat.run();

        //吃完放下叉子
        putLeftFork.run();
        putRightFork.run();

        //左右叉子解锁
        locks[leftForkId].unlock();
        locks[rightForkId].unlock();

        //释放叉子信号
        eatLimit.release();
    }
}
