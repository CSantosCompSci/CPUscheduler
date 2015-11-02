 import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Scheduler {
	static Queue<PCB> readyQueue = new LinkedList<PCB>();
	//main method that creates ready queue and scans input file
	public static void main(String[] args)
	{
		
	//integer variable that is assigned as the process number for each process read in from file
		int processNum = 1;
		ArrayList<PCB> scheduler = new ArrayList<PCB>();
	
	try
	{
		Scanner reader = new Scanner(new File("input.data"));
		int numOfJobs =reader.nextInt();
		System.out.println(numOfJobs);
		int quantumTime = reader.nextInt();
		System.out.println(quantumTime);
		int random = reader.nextInt();
		System.out.println(random);
		while(reader.hasNextInt())
		{
			
			int arrival = reader.nextInt();
			System.out.print(" " + arrival);
			int burst = reader.nextInt();
			System.out.print(" " + burst);
			int priority = reader.nextInt();
			System.out.print(" " + priority);
			PCB process = new PCB(processNum,arrival, burst, priority);
			System.out.println(processNum + "" + arrival + ""+  burst +"" + priority);

			scheduler.add(process);
			
			processNum++;
		
		}
		beginScheduling(scheduler, processNum);
			
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	for(int index = 0; index < scheduler.size(); index++)
	{
		System.out.print("start time= "+ scheduler.get(index).getStartTime() + "end time = " + scheduler.get(index).getEndTime() + "process number = " + scheduler.get(index).getProcess());
		System.out.println();
	}
	
	}
	
	public static void beginScheduling(ArrayList<PCB> scheduler,int totalNum)
	{
		
		//Collections.sort(scheduler);
		CPU cpu = new CPU(0);
		int numOfProcesses = totalNum;
		int currentTime = 0;
		while(numOfProcesses != 0)
		{
			//method call that will add to the ready queue if there is an arrival of a process at that current time
			checkForProcessArrival(scheduler, currentTime);
					
			//if the queue isnt empty and the cpu isnt busy remove head of queue and begin process execution.
			//decrement number of processes
			if(!readyQueue.isEmpty() && !cpu.isBusy())
			{
				readyQueue.peek().setStartTime(currentTime);
				int r =readyQueue.peek().setStartTime(currentTime);
				cpu = new CPU(readyQueue.remove().getBurstTime());
				numOfProcesses--;
			}
			currentTime++;
		}
		
		//when all processes have been executed then end times are set for processes 
		for (int index = 0; index <scheduler.size(); index ++)
		{
			scheduler.get(index).setEndTime();
		}
	}
		
		public static void checkForProcessArrival(ArrayList<PCB> scheduler, int time)
		{
			for(int index = 0; index < scheduler.size();index++)
			{
				int arrival = scheduler.get(index).getArrivalTime();
				if(arrival == time)
				{
					readyQueue.add(scheduler.get(index));
				}
			}
		
		public int compare(PCB process1, PCB process2)
		{
			return Integer.valueOf(process1.getPriority()).compareTo(process2)
		}
		}
}

	
	
	
	
	
	
	