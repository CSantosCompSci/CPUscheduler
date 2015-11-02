//Process creator
public class PCB implements Comparable<Object>{

	int process, arrivalTime, burstTime, priority, startTime, endTime;  
	public PCB(int readProcess, int readArrivalTime,  int readBurstTime, int readPriority)
	{
		this.process = readProcess;
		this.arrivalTime = readArrivalTime;
		this.burstTime = readBurstTime;
		this.priority = readPriority;
		this.startTime = 0;
		this.endTime = 0;

	}
	
	
	/*method that returns the value of the priority of the job
	 * @param
	 *
	 */
	//returns the process number of a process
	public int getProcess()
	{
		return process;
	}
	//returns the arrival time of a process
	public int getArrivalTime()
	{
		return arrivalTime;
	}
	//return the burst time of a process
	public int getBurstTime()
	{
		return burstTime;
	}
	
	//return the priority of the process
	public int getPriority()
	{
		return priority;
	}
	
	public int compareTo(PCB comparesTo)
	{
		int comparePriority = (comparesTo).getPriority();
		return this.priority-comparePriority;
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	//set the end of process execution
	public void setEndTime()
	{
		endTime = startTime + burstTime;
	}
	
	//returns the value of the start of process execution
	public int getStartTime()
	{
		return startTime;
	}
	
	//returns the value of the end of process execution
	public int getEndTime()
	{
		return endTime;
	}
	
	//set the start of the process execution
	public void setStartTime(int start)
	{
		startTime = start;
	}
	
}
