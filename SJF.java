package PS_ALGO;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class SJF {
    public static void main(String[] args) 
	{
		Scanner obj = new Scanner(System.in);
		Queue<Integer> q1 = new LinkedList<Integer>();
		System.out.print("Enter the number of processes: ");
		int process = obj.nextInt();
		System.out.println("Enter the burst time of processes: ");
		for(int i=0;i<process;i++)
		{
			q1.add(obj.nextInt());
		}
		//creating list for sorting queue
		List<Integer> l1= new ArrayList<Integer>(q1);
		Collections.sort(l1); //sorting the list of queue
		q1.clear(); //deleting burst time i.e, all elements from the queue
		q1.addAll(l1);//adding sorted list on the queue
		System.out.println("Stored burst time "+q1);
		int arrivalTime = 0;
        int completionTime[] = new int[process];
        int waitingTime[] = new int[process];
        int turnAroundTime[] = new int[process];
		completionTime[0] = q1.peek(); // First process completes when its burst time elapses
        waitingTime[0] = 0; // First process doesn't wait
        turnAroundTime[0] = completionTime[0] - arrivalTime;

        for (int i = 1; i < process; i++) {
            arrivalTime += q1.poll(); // Increase arrival time by the burst time of the completed process
            completionTime[i] = q1.peek() + completionTime[i - 1];
            turnAroundTime[i] = completionTime[i] - arrivalTime;
            waitingTime[i] = completionTime[i - 1]; // Wait time for process i is the completion time of the previous process
        }

        // Displaying completion times, waiting times, and turn around times
        System.out.println("Completion Time:");
        for (int i = 0; i < process; i++)
        {
            System.out.print(completionTime[i] + " ");
        }
        
        System.out.println("\nTurnaround Time:");
        for (int i = 0; i < process; i++) 
        {
            System.out.print(turnAroundTime[i] + " ");
        }
        System.out.println("\nWaiting Time:");
        for (int i = 0; i < process; i++)
        {
            System.out.print(waitingTime[i] + " ");
        }	
        obj.close();
	}
}
