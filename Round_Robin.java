package PS_ALGO;

import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
class Process
{
	int burst;
	int process;
	int slice;
	Process(int process, int burst)
	{
		this.process= process;
		this.burst= burst;
		this.slice= 2;
	}
}
public class Round_Robin {
    public static void RR(List<Process> li)
	{
		Queue<Process> queue = new LinkedList<Process>(li);
		int currentTime = 0;

        while (!queue.isEmpty()) {
            Process currentProcess = queue.poll();
            int remainingBurst = currentProcess.burst;

            // Execute the process for its time slice or remaining burst time, whichever is smaller
            int timeSlice = Math.min(currentProcess.slice, remainingBurst);
            currentTime += timeSlice;
            remainingBurst -= timeSlice;

         //If the process has remaining burst time, re-queue it
            if (remainingBurst > 0) {
                currentProcess.burst = remainingBurst;
                queue.add(currentProcess);
            }
            else
            {
            	System.out.println("Process "+currentProcess.process+" completed at "+currentTime);
            }
        }
		
	}
	public static void main(String[] args) 
	{
		
		List<Process> li = new ArrayList<>();
		li.add(new Process(1,10));
		li.add(new Process(2,5));
		li.add(new Process(3,8));
		RR(li);		
	}
    
}
