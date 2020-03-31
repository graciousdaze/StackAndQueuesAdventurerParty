/**
 * This class implements the Queue data structure by using circular arrays
 * to store and manipulate objects.
 * 
 * @author Grace O'Brien
 * April 1st, 2020
 *
 */
public class ArrayQueue {

	private Object[] contents;	//Array to contain objects
	private int head;			//Tracks index of first object
	private int rear;			//Tracks index of rear object
	private int numItems;		//Tracks numItems in queue
	
	public ArrayQueue()
	{
		head = 0;
		rear = 0;
		numItems = 0;
	}
	
	public ArrayQueue(int capacity)
	{
		contents = new Object[capacity];
		head = 0;
		rear = 0;
		numItems = 0;
	}
	
}
