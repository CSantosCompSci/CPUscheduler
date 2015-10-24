//Process creator
public class PCB implements Comparable<Object>{

	int process, arrivalTime, burstTime,priority,waitTime;  
	public PCB(int readProcess, int readArrivalTime,  int readBurstTime, int readPriority)
	{
		this.process = readProcess;
		this.arrivalTime = readArrivalTime;
		this.burstTime = readBurstTime;
		this.priority = readPriority;
		this.waitTime = 0;
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
	
}
