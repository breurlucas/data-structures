package implementation;

import net.datastructures.ArrayStack;

public class ParenthesisMatching {
    
    //  Method that verifies the matching of brackets
    public boolean verify(String[] X) { 
    	
        ArrayStack<String> newStack = new ArrayStack<>();
        
        int i=0;
        while (i<X.length) {
        	System.out.print(X[i]);
            if (X[i].contentEquals("(") || X[i].contentEquals("[") || X[i].contentEquals("{")) {
            	newStack.push(X[i]);
            	i++;
            	
            } else {
            	
                if (newStack.isEmpty()) {
                	
                    return false;
                }
                // Inverts the string before comparing a pair
                else if (newStack.pop().contentEquals( invert(X[i])) ) {
                	
                    i++;
                    
                } else {
                	
                    return false;
                }
            }
        }
        
        if (newStack.isEmpty()) {
        	
            return true;
        }
        else {
        	
            return false;
        }
    }
    
    // Method that inverts the input string
    private String invert(String Z) {
        if (Z.contentEquals(")")) {
        	
            return Z = "(";
            
        } else if (Z.contentEquals("]")) {
        	
            return Z = "[";
            
        } else {
        	
            return Z = "{";
        }
    }
}
