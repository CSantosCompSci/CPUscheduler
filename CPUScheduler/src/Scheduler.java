 import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Scheduler {

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
		int quantumTime = reader.nextInt();
		
		while(reader.hasNextLine())
		{
			
			int arrival = reader.nextInt();
			int burst = reader.nextInt();
			int priority = reader.nextInt();
			PCB process = new PCB(processNum,arrival, burst, priority);
			scheduler.add(process);
			
			processNum++;
		
		}
		beginScheduling(scheduler, processNum);
		
		
	
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	
	}
	
	public static void beginScheduling(ArrayList<PCB> scheduler,int totalNum)
	{
		Queue<Integer> readyQueue = new LinkedList<Integer>();
		Collections.sort(scheduler);
		CPU cpu;
		int numOfProcesses = totalNum;
		int currentTime = 0;
		while(numOfProcesses != 0)
		{
			//each time this loop
			for (int index; index <= numOfProcesses; index ++)
			{
				if(!cpu.isBusy() && scheduler.get(index).getArrivalTime() >= currentTime)
				{
					cpu = new CPU(scheduler.get(index).getBurstTime());
			}
				if (scheduler.get(index).getArrivalTime() >= currentTime)
				{
					readyQueue.add(scheduler.get(index).getArrivalTime());
				}
			currentTime++;
		}
		
		
		CPU cpu = new CPU(process.getBurstTime());
		
}

	
	
	
	
	
	
	