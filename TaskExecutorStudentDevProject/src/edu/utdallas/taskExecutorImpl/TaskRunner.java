package edu.utdallas.taskExecutorImpl;

import edu.utdallas.blockingFIFO.BlockingQueue;
import edu.utdallas.taskExecutor.Task;

public class TaskRunner implements Runnable {
	private BlockingQueue queue;
	
	public TaskRunner(BlockingQueue queue) {
		this.queue = queue;
	}
	//static Semaphore s = new Semaphore(1);
	public void run() {
		while(true) {
			try {
				//s.acquire();
				Task t;
				t = queue.getTask();
				t.execute();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//s.release();
		}
	}
}
