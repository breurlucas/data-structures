package implementation;

/*
 * 
 * @author Lucas Breur 
 */
public class Process {
	
	private int pid = 0;
    private int load = 0;
    
    public int getPid() { return pid; }
    public int getLoad() { return load; }
    public void setLoad(int load) { this.load = load; }
    
    // Constructor
    public Process(int a, int b) {
        pid = a;
        load = b;
    }
}
