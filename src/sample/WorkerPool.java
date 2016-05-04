/**
 * Worker pool class improves the performance of the next
 * generation method using concurrent programming. The game
 * board will split up and will be evaluated separately by
 * running threads in the computer.
 *
 * @author Rudi André Dahle
 */

package sample;

import org.omg.SendingContext.RunTime;

import java.util.LinkedList;
import java.util.List;


public class WorkerPool {

    //Data field
    private List<Thread> workerPool;
    private final int numWorkers;

    /**
     * WorkerPool's default constructor receives no
     * arguments.
     *
     * @author Rudie André Dahle
     */
    public WorkerPool(){
        workerPool = new LinkedList<>();
        numWorkers = Runtime.getRuntime().availableProcessors();
    }

    /**
     *
     * @author Rudie André Dahle
     * @throws InterruptedException
     */
    public void runWorkers() throws InterruptedException {
        workerPool.forEach(Thread::start);
        for(Thread t : workerPool){
            t.join();
        }
    }

    /**
     *
     *
     * @author Rudie André Dahle
     * @param task
     */
    public void setTask(Runnable task){
        for(int i = 0; i < Runtime.getRuntime().availableProcessors(); i++){
            workerPool.add(new Thread(task));
           // workers.add(new Thread(() ->{nextGen(index);}));
        }
    }

    /**
     *
     *
     * @author Rudie André Dahle
     */
    public void clearWorkers(){
        workerPool.clear();
    }
}
