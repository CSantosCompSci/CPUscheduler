 import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Scheduler {
	static PriorityQueue<PCB> readyQueue = new PriorityQueue<PCB>();
	//main method that creates ready queue and scans input file
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		
	//integer variable that is assigned as the process number for each process read in from file
		int processNum = 0;
		ArrayList<PCB> scheduler = new ArrayList<PCB>();
	
	try
	{
		Scanner reader = new Scanner(new File("input.data"));
		int numOfJobs =reader.nextInt();
		//System.out.println(numOfJobs);
		int quantumTime = reader.nextInt();
		//System.out.println(quantumTime);
		int random = reader.nextInt();
		//System.out.println(random);
		do
		{
			processNum++;
			int arrival = reader.nextInt();
			//System.out.print(" " + arrival);
			int burst = reader.nextInt();
			//System.out.print(" " + burst);
			int priority = reader.nextInt();
			//System.out.print(" " + priority);
			PCB process = new PCB(processNum,arrival, burst, priority);
			//System.out.println(processNum + "" + arrival + ""+  burst +"" + priority);

			scheduler.add(process);
			//System.out.println(processNum);
			
		
		}while(reader.hasNextInt());
		
		beginScheduling(scheduler, processNum);
			
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	scheduler.sort(Comparator.comparing(PCB::getStartTime));
	PrintWriter writer = new PrintWriter("output.data", "UTF-8");
	for(int index = 0; index < scheduler.size(); index++)
	{
		writer.print(scheduler.get(index).getStartTime() + "  " + scheduler.get(index).getEndTime() + "  " + scheduler.get(index).getProcess());
		writer.println();
	}
	writer.close();
	}
	
	public static void beginScheduling(ArrayList<PCB> scheduler,int totalNum)
	{
		
		
		CPU cpu = new CPU(0);
		int numOfProcesses = totalNum;
		//System.out.println(numOfProcesses);
		int currentTime = 0;
		while(numOfProcesses != 0 )
		{
			//System.out.println("Current Time = " + currentTime);
			//method call that will add to the ready queue if there is an arrival of a process at that current time
			checkForProcessArrival(scheduler, currentTime);
			//Scanner enter = new Scanner(System.in);
			//String a = enter.next();
			//if the queue isnt empty and the cpu isnt busy remove head of queue and begin process execution.
			//decrement number of processes
			if(!readyQueue.isEmpty() && !cpu.isBusy())
			{
			//	System.out.println("if(!readyQueue.isEmpty() && !cpu.isBusy())");
				PCB process = (PCB)readyQueue.remove();
				process.setStartTime(currentTime);
				int time = process.getBurstTime();
				cpu = new CPU(time);
				cpu.startProcess();
				numOfProcesses--;
			//	System.out.println(numOfProcesses);
			}
			if(cpu.isBusy())
			{
				cpu.reduceProcessTime();
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
				//System.out.println("Arrival = " + arrival);
				//System.out.println("Time = " + time);
				if(arrival == time)
				{
					//System.out.println("Entered for loop");
					readyQueue.add(scheduler.get(index));
				}
			}
		
		}
}

	
	
	
	
	
	
	