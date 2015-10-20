import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Scheduler {

	//main method that creates ready queue and scans input file
	public static void main(String[] args)
	{
		Queue<Processor> readyQueue = new LinkedList<Processor>();
	try
	{
		Scanner reader = new Scanner(new File("input.data"));
		int numOfJobs =Integer.parseInt(reader.next());
		
		
		while(reader.hasNextLine())
		{
			//Array structure should be [job number][arrivalTime}[burstTime][priority
		}
	
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	
	}
	
}
