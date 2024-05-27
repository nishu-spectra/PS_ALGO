package PS_ALGO;
import java.util.*;
//Process Scheduling 
public class FCFS {
    public static void main(String[] args)
	{
		Scanner obj = new Scanner(System.in);
		Queue<Integer> q1 = new LinkedList<Integer>();
		System.out.print("Enter the number of processes: ");
		int process = obj.nextInt();
		System.out.print("Enter the burst time of processes: ");
		for(int i=0;i<process;i++)
		{
			q1.add(obj.nextInt());
		}
		System.out.println("Stored burst time: "+q1);
		int arrivalTime=0; //initializing arrival time as 0
		int completionTime[] = new int[process];
		int turnAroundTime[] = new int[process];
		int waitingTime[] = new int[process];
		completionTime[0]=q1.peek(); //first process completes when its burst time is over
		turnAroundTime[0]= completionTime[0]-arrivalTime;
		waitingTime[0]= turnAroundTime[0]- completionTime[0]; //equal to 0 as first process doesn't wait
		for(int i=1;i<process;i++)
		{
			arrivalTime += q1.poll();
			completionTime[i]=q1.peek()+completionTime[i-1];
			turnAroundTime[i]= completionTime[i]-arrivalTime;
			waitingTime[i]= completionTime[i]-turnAroundTime[i];
		}
		//Displaying the completion, turn around and waiting time of the processes
		System.out.println("Completion Time:");
		for(int i=0;i<process;i++)
		{
			System.out.print(completionTime[i]+" ");
		}
		System.out.println("\nTurnaround Time:");
		for(int i=0;i<process;i++)
		{
			System.out.print(turnAroundTime[i]+" ");
		}
		System.out.println("\nWaiting Time:");
		for(int i=0;i<process;i++)
		{
			System.out.print(waitingTime[i]+" ");
		}
      
	}

    
}
