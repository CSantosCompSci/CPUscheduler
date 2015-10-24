
public class CPU {
	
	private int timeForProcess;
	private int process_time_left;
	
	
	public CPU(int passedBurstTime)
	{
		timeForProcess = passedBurstTime;
		process_time_left = 0;
	}
	
	public boolean isBusy()
	{
		return (process_time_left > 0)
	}

	public void reduceProcessTime()
	{
		if(process_time_left > 0)
			process_time_left--;
	}
	
	public void startProcess()
	{
		if(process_time_left > 0)
			throw new IllegalStateException("Cpu is busy");
		process_time_left = timeForProcess
	}
}
