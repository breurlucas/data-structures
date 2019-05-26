package impl;
import net.datastructures.DefaultComparator;
import net.datastructures.EmptyPriorityQueueException;
import net.datastructures.Entry;
import net.datastructures.InvalidKeyException;
import net.datastructures.PriorityQueue;
import net.pl.*;
import java.util.Comparator;

/**
 * 
 * @author Lucas Breur
 */

public class UnsortedListPriorityQueue<K,V> implements PriorityQueue<K,V> {
	/** 
	  * The following code fragment is based on the initialization of the sorted 
	  * list priority queue by:
	  * @author Roberto Tamassia, Michael Goodrich, Eric Zamore
	  * 
	  * Start of fragment 
	  * 
	  */
	
	protected PositionList<Entry<K,V>> entries;
	protected Comparator<K> c;	
	
	/** Inner class for entries */
	protected static class MyEntry<K,V> implements Entry<K,V> {
	  protected K k; // key
	  protected V v; // value
	  public MyEntry(K key, V value) {
		k = key;
		v = value;
	  }
	  // methods of the Entry interface
	  public K getKey() { return k; }
	  public V getValue() { return v; }
	  // overrides toString, useful for debugging
	  public String toString() { return "(" + k  + "," + v + ")"; }
	}
	  
	/** Creates the priority queue with the default comparator. */  
	public UnsortedListPriorityQueue () {
	  entries = new NodePositionList<Entry<K,V>>();
	  c = new DefaultComparator<K>();
	}

	/** Returns the number of elements in the priority queue. */
	public int size () {return entries.size(); }
	
	/** Returns whether the priority queue is empty. */
	public boolean isEmpty () { return entries.isEmpty(); }
	
	/** Determines whether a key is valid. */
	protected boolean checkKey(K key) throws InvalidKeyException {
	  boolean result;
	  try {		// check if the key can be compared to itself
	 	result = (c.compare(key,key)==0);
   	  } catch (ClassCastException e)
		{	throw new InvalidKeyException("key cannot be compared"); }
      return result;
	}
	
	// overrides toString, useful for debugging
	public String toString() {
	  return entries.toString(); 
	}
	
	/** End of the fragment **/
	
	// Method that returns the position of the smallest key, it is used by the min() and removeMin() methods
	private Position<Entry<K,V>> getMin () throws EmptyPriorityQueueException {
	  if (entries.isEmpty()) {
		  throw new EmptyPriorityQueueException("Priority queue is empty!");
	  }
	  else {
		// Current position equals the first position in the queue
	    Position<Entry<K,V>> smallest = entries.first();
	    /* Compare the current smallest key to all other keys in the queue and return the smallest value found. 
	       for( x : y ) represents a foreach loop. In this case it loops through all the positions in the entries 
	       list */
	    for(Position<Entry<K, V>> pos : entries.positions()) {
	    	// If the current key is smaller than the current smallest key, they get swapped
	    	if(c.compare(smallest.element().getKey(), pos.element().getKey()) > 0) {
	    		smallest = pos; 
	    	}
	    }
	    
	    return smallest;
	  }
	}
	
	// Method that returns the element with the smallest key
	public Entry<K,V> min() throws EmptyPriorityQueueException {
	  return getMin().element();
	}
	
	// Method that removes and returns the element with the smallest key
	public Entry<K,V> removeMin() throws EmptyPriorityQueueException {
	  return entries.remove(getMin());
	}
	
	// Method that inserts a key at the beginning
	public Entry<K,V> insert (K k, V v) throws InvalidKeyException {
	  checkKey(k); 
	  Entry<K,V> entry = new MyEntry<K,V>(k, v);
	  entries.addFirst(entry);               
	  return entry;
	}
}

