package PS_ALGO;
import java.util.*;
public class SRTN {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int num = scanner.nextInt();

        Map<Integer, Integer> processMap = new HashMap<>();
        Map<Integer, Integer> arrivalTimeMap = new HashMap<>();

        System.out.println("Enter the burst time of processes: ");
        for (int i = 0; i < num; i++) 
        {
            processMap.put(i + 1, scanner.nextInt());
        }

        System.out.println("Enter the arrival time of processes: ");
        for (int i = 0; i < num; i++) 
        {
            arrivalTimeMap.put(i + 1, scanner.nextInt());
        }

        scanner.close();

        findSRTN(processMap, arrivalTimeMap);
    }

    public static void findSRTN(Map<Integer, Integer> processMap, Map<Integer, Integer> arrivalTimeMap) 
    {
        int num = processMap.size();
        int currentTime = 0;
        int completed = 0;
        int[] completionTime = new int[num];
        boolean[] visited = new boolean[num];

        while (completed < num) 
        {
            int shortestIndex = -1;
            int shortestRemainingTime = Integer.MAX_VALUE;

            for (int i = 1; i <= num; i++) 
            {
                if (!visited[i - 1] && arrivalTimeMap.get(i) <= currentTime && processMap.get(i) < shortestRemainingTime)
                {
                    shortestRemainingTime = processMap.get(i);
                    shortestIndex = i;
                }
            }

            if (shortestIndex == -1) 
            {
                currentTime++;
                continue;
            }

            processMap.put(shortestIndex, processMap.get(shortestIndex) - 1);
            currentTime++;

            if (processMap.get(shortestIndex) == 0) 
            {
                completed++;
                visited[shortestIndex - 1] = true;
                completionTime[shortestIndex - 1] = currentTime;
            }
        }

        // Print completion time for each process
        for (int i = 1; i <= num; i++)
        {
            System.out.println("Process " + i + " completed at time " + completionTime[i - 1]);
        }
    }
    
}
