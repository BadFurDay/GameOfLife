/**
 * Worker pool class improves the performance of the next
 * generation method using concurrent programming. The game
 * board will split up and will be evaluated separately by
 * running threads in the computer.
 *
 * @author Rudi André Dahle
 * @author Olav Smevoll
 * @author Ginelle Ignacio
 */

package sample;


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
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     */
    public WorkerPool(){
        workerPool = new LinkedList<>();
        numWorkers = Runtime.getRuntime().availableProcessors();
    }

    /**
     * Method called to run the thread objects
     *
     * @author Rudie André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @throws InterruptedException Throws an exception when an
     *                              error occurs
     */
    public void runWorkers() throws InterruptedException {
        workerPool.forEach(Thread::start);
        for(Thread t : workerPool){
            t.join();
        }
    }

    /**
     * Method called to set the task of the threads
     *
     * @author Rudie André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     * @param task Parameters the value for Runnable
     */
    public void setTask(Runnable task){
        for(int i = 0; i < Runtime.getRuntime().availableProcessors(); i++){
            workerPool.add(new Thread(task));
        }
    }

    /**
     *  Clears the array list of threads
     *
     * @author Rudie André Dahle
     * @coauthor Olav Smevoll
     * @coauthor Ginelle Ignacio
     */
    public void clearWorkers(){
        workerPool.clear();
    }
}
