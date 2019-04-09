package main;

import implementation.ParenthesisMatching;

public class Main {
	
	public static void main(String[] args) {
		
		ParenthesisMatching sequence = new ParenthesisMatching();
		
        String A = "{,[,(,(,[,[,{,[,],},],],),),],}"; // Matched
        String B = "{,[,(,(,[,[,{,[,},},],],),),],}"; // Unmatched
		String C = "{,[,(,(,[,[,{,[,],},],],),),],)"; // Unmatched
        String D = "{,[,(,(,[,[,{,[,{,{,(,),},},],},],],),),],}"; // Matched

        String[] a = A.split(",");
        String[] b = B.split(",");
        String[] c = C.split(",");
        String[] d = D.split(",");
        
        String[][] content = {a,b,c,d};
        
        System.out.println("Verify the matching of brackets");
        System.out.println("");
        
        for(int i = 0; i < content.length; i++) {
	    	if(sequence.verify(content[i]))
	    		System.out.println("	--> The sequence of brackets is valid.");
	    	else
	    		System.out.println("	--> The sequence of brackets is invalid.");   	
        }
	}
}
