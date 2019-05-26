package main;
import impl.UnsortedListPriorityQueue;

/**
 *
 * @author Lucas Breur
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	UnsortedListPriorityQueue<Integer,String> priorityQ = new UnsortedListPriorityQueue<Integer, String>();
        
        priorityQ.insert(3,"Heineken");
        priorityQ.insert(4,"Amstel");
        priorityQ.insert(6,"Budweiser");
        System.out.println(priorityQ.toString());
        priorityQ.insert(2,"Brand");
        priorityQ.insert(1,"Hoegaarden");
        priorityQ.insert(5,"Stella Artois");
        
        System.out.println("Priority queue with size " + priorityQ.size() + " and an unsorted list:\n");
        
        System.out.println(priorityQ.min());
        System.out.println(priorityQ.removeMin().toString() + "\n");
 
        System.out.println(priorityQ.min());
        System.out.println(priorityQ.removeMin().toString() + "\n");
        
        System.out.println(priorityQ.removeMin().toString());
        System.out.println(priorityQ.removeMin().toString());
        System.out.println(priorityQ.removeMin().toString());
        System.out.println(priorityQ.removeMin().toString());
    } 
}
