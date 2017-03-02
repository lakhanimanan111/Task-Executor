package edu.utdallas.taskExecutorImpl;

import java.util.ArrayList;
import java.util.List;

import edu.utdallas.blockingFIFO.BlockingQueue;
import edu.utdallas.taskExecutor.Task;
import edu.utdallas.taskExecutor.TaskExecutor;

public class TaskExecutorImpl implements TaskExecutor
{
	List<TaskRunner> runnerPool = new ArrayList<TaskRunner>();
	BlockingQueue queue = new BlockingQueue();
	
	public TaskExecutorImpl(int number) {
		for (int i = 0; i < number; i++) {
			TaskRunner newThread = new TaskRunner(queue);
			runnerPool.add(newThread);
			Thread t = new Thread(newThread);
			t.setName(""+i);
			t.start();
		}
	}
	 
	@Override
	public void addTask(Task task)
	{
		try {
			queue.putTask(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
