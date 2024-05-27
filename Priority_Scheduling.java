package PS_ALGO;
import java.util.*;

class P_Process
{
	int burst;
	int process;
	int priority;
	P_Process(int process, int burst, int priority)
	{
		this.process= process;
		this.burst = burst;
		this.priority= priority;
	}
}
public class Priority_Scheduling {
    public static void P_S(List<P_Process> li)
	{
		int size = li.size();
		 int currentTime = 0;
		int completionTime[]= new int[size];
		int turnaroundTime[]= new int[size];
		int waitingTime[]= new int[size];
		// Sort processes by priority
        li.sort(Comparator.comparingInt(p -> p.priority));
        for (int i = 0; i < size; i++) {
            P_Process currentProcess = li.get(i);
            int processTime = currentProcess.burst;

            // Update completion time
            currentTime += processTime;
            completionTime[currentProcess.process - 1] = currentTime;

            // Calculate turn around time and waiting time
            turnaroundTime[currentProcess.process - 1] = currentTime;
            waitingTime[currentProcess.process - 1] = currentTime - processTime;
        }

        // Print completion time, turn around time, and waiting time for each process
        System.out.println("Process\tCompletion Time\tTurnaround Time\tWaiting Time");
        for (int i = 0; i < size; i++) {
            System.out.println(li.get(i).process + "\t\t" + completionTime[i] + "\t\t" + turnaroundTime[i] + "\t\t" + waitingTime[i]);
        }
		
	}
	public static void main(String[] args) 
	{
		List<P_Process> li = new ArrayList<P_Process>();
		li.add(new P_Process(1,21,2));
		li.add(new P_Process(2,3,1));
		li.add(new P_Process(3,6,4));
		li.add(new P_Process(4,2,3));
		P_S(li);

	}
    
}
