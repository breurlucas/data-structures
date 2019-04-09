package main;

import net.datastructures.SinglyLinkedList;

public class UsingSinglyLinkedList {
	
	// Args is an array that receives arguments from the command prompt
	public static void main(String[] args) {
		// println prints in a new line
		System.out.println("Singly Linked List example.");
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		
		list.addFirst("Horse");
		list.addFirst("Dog");
		list.addLast("Chicken");
		list.addLast("Turkey");
		
		System.out.println(list.toString());
        System.out.println( list.removeFirst() );
        System.out.println(list.toString());
	}

}
