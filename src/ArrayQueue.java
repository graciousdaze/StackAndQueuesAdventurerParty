import java.util.NoSuchElementException;

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
	
	/**
	 * Returns if the queue is empty or not
	 * 
	 * @return True The queue is empty
	 * 		   False The queue is not empty
	 */
	public boolean isEmpty()
	{
		if(numItems == 0)
			return true;
		
		return false;
	}
	
	/**
	 * Returns a copy of the element stored at the front of the queue
	 * 
	 * @return Object copy of the first item in the queue
	 */
	public Object peek()
	{
		try
		{
			if(numItems == 0)
				throw new NoSuchElementException();
			
			Object copy = contents[head];
			
			return copy;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("The queue is empty");
			return null;
		}
	}
	
	/**
	 * Removes and returns the object that is currently at the front of 
	 * the queue
	 * 
	 * @return The object at the front of the queue
	 */
	
	public Object remove()
	{
		try 
		{
			//If numItems is 0 throw an exception
			if(numItems == 0)
				return new NoSuchElementException();
			
			//Store the top item in a variable and set current head index
			//to null
			Object removed = contents[head];
			contents[head] = null;
			
			//If head position is equal to last index value, head == 0
			if(head == contents.length - 1)
			{
				head = 0;
			}
			else
			{
				//Otherwise increment head position by 1
				head = head++;
			}
			
			//Return removed object
			return removed;
		}
		catch(NoSuchElementException e)
		{
			//Print error and return null
			System.out.println("The queue is empty");
			return null;
		}
	}
	
}
