import java.util.NoSuchElementException;

/**
 * This class implements the Queue data structure by using circular arrays
 * to store and manipulate objects.
 * 
 * @author Grace O'Brien
 * April 1st, 2020
 *
 */
public class ArrayQueue<E> {

	private Object[] contents;	//Array to contain objects
	private int head;			//Tracks index of first object
	private int rear;			//Tracks index of rear object
	private int numItems;		//Tracks numItems in queue
	
	/**
	 * ArrayQueue constructor. By default creates an array with size 5.
	 */
	public ArrayQueue()
	{
		contents = new Object[15];
		head = 0;
		rear = 0;
		numItems = 0;
	}
	
	/**
	 * ArrayQueue constructor. Sets the capacity for the array.
	 * 
	 * @param capacity Size of the array
	 */
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
	public E peek()
	{
		try
		{
			if(numItems == 0)
				throw new NoSuchElementException();
			
			E copy = (E) contents[head];
			
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
	public E remove()
	{
		try 
		{
			//If numItems is 0 throw an exception
			if(numItems == 0)
				throw new NoSuchElementException();
			
			//Store the top item in a variable and set current head index
			//to null
			E removed = (E)contents[head];
			
			//If head position is equal to last index value, head == 0
			if(head == contents.length - 1)
			{
				head = 0;
			}
			else
			{
				//Otherwise increment head position by 1
				head++;
			}
			
			numItems--;
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
	
	/**
	 * Adds a new element to the rear of the queue
	 * 
	 * @param data Object to be added
	 */
	public void add(Object data)
	{
		try
		{
			//Throw an exception if queue is already full
			if(numItems == contents.length)
				throw new IllegalStateException();
			
			//Set new rear index to data and increment items
			contents[rear] = data;
			numItems++;
			
			//Set rear to 0 if it is equal to last index, otherwise increment
			if(rear == contents.length - 1)
				rear = 0;
			else
				rear++;
		}
		catch(IllegalStateException e)
		{
			System.out.println("Queue is full, remove elements before adding.");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * Returns the objects in the queue as a string
	 * 
	 * @return String of the objects in the queue
	 */
	public String toString()
	{
		int current = head;			//Store current index
		String result = "";			//Store results of object strings
		boolean endOfQueue = false;	//Tracks if end is reached
				
		//While end of queue has not been reached...
		while(!endOfQueue)
		{
			if(numItems == 0)
				return "";
			
			result = result + contents[current].toString() + "\n";
			
			//If current is at end of index, set to 0, otherwise increment
			if(current == contents.length - 1)
			{
				current = 0;
			}
			else
			{
				current++;
			}
			
			//If current index is equal to head index then endOfQueue is reached
			if(current == rear || contents[current] == null)
			{
				endOfQueue = true;
			}
		}
		
		return result;
	}
	
	/**
	 * Returns the size of the queue
	 * 
	 * @return Number of elements in the queue
	 */
	public int size()
	{
		return numItems;
	}
	
}
