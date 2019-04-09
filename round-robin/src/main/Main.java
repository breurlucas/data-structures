package main;

import implementation.Process;
import implementation.RoundRobin;

public class Main {
	
	public static void main(String[] args) {
		
		Process p1 = new Process(67281, 45);
        Process p2 = new Process(921, 12);
        Process p3 = new Process(1928, 77);
        Process p4 = new Process(55555, 54);
        Process p5 = new Process(12345, 63);
         
        Process[] processes = {p1, p2, p3, p4, p5};
        
        RoundRobin.schedule(processes);
	}
}
