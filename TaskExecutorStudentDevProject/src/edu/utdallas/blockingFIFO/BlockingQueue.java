package edu.utdallas.blockingFIFO;
import java.util.concurrent.ArrayBlockingQueue;
import edu.utdallas.taskExecutor.Task;

public class BlockingQueue {
	ArrayBlockingQueue<Task> fifo = new ArrayBlockingQueue<Task>(100);
	
	public void putTask(Task task) throws InterruptedException{
		fifo.put(task);
	}
	
	public Task getTask() throws InterruptedException {
		return fifo.take();
	}
}
