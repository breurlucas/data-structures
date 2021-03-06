package implementation;

import net.datastructures.ArrayQueue;
import implementation.Process;

/*
 * 
 * @author Lucas Breur 
 */
public class RoundRobin {
	
	    /* Process order:
	       RoundRobin
	       e = Q.dequeue
	       Service element e
	       Q.enqueue(e) */

    public static void schedule(Process[] arr) {
        ArrayQueue<Process> Q = new ArrayQueue<>();
        int i = 0;
        while (i < arr.length) {
            Q.enqueue(arr[i]);
            i++;
        }
        
        Process process;
        while (!Q.isEmpty()) {
            process = Q.dequeue();
            int temp = process.getLoad();
            // Service the process
            temp -= 3;
            process.setLoad(temp);
            if (temp <= 0) {
            System.out.println("Process " + process.getPid() + " is finished!");
            }
            else {
            	// Enqueue the process if not finished
                Q.enqueue(process);
                System.out.println("Process " + process.getPid() + " is at " +
                        temp + " load");
            }   
        }
    }
}
