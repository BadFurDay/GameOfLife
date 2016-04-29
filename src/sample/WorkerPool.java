package sample;

import org.omg.SendingContext.RunTime;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by RudiAndre on 28.04.2016.
 */
public class WorkerPool {
    private List<Thread> workerPool;
    private final int numWorkers;


    public WorkerPool(){
        workerPool = new LinkedList<>();
        numWorkers = Runtime.getRuntime().availableProcessors();
    }

    public void runWorkers() throws InterruptedException {
        workerPool.forEach(Thread::start);
        for(Thread t : workerPool){
            t.join();
        }
    }

    public void setTask(Runnable task){
        for(int i = 0; i < Runtime.getRuntime().availableProcessors(); i++){
            workerPool.add(new Thread(task));
           // workers.add(new Thread(() ->{nextGen(index);}));
        }
    }

    public void clearWorkers(){
        workerPool.clear();
    }
}
