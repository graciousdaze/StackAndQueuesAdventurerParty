import java.util.EmptyStackException;

/**
 * This class implements and uses the Stacks data structure to store and 
 * manipulate objects.
 * 
 * @author Grace O'Brien
 * April 1st, 2020
 *
 */
public class LinkedStack {
	
	private Node top; //Tracks object at the top of the stack
	private int numItems; //Number of items on stack
	
	/**
	 * LinkedStack constructor
	 * 
	 */
	public LinkedStack()
	{
		top = null;
		numItems = 0;
	}
	
	/**
	 * Checks to see if the stack is empty
	 * 
	 * @return False If the stack has at least 1 element
	 * 		   True	 If the stack has 0 elements
	 */
	public boolean isEmpty()
	{
		if(numItems == 0)
			return true;
		
		return false;
	}
	
	/**
	 * Returns a copy of the element stored at the top of the stack
	 * 
	 * @return Object, copy of the element at the top of the list
	 * 
	 */
	public Object peek()
	{
		try 
		{
			//If the stack is empty, throw exception
			if(numItems == 0)
				throw new EmptyStackException();
			
			//Else return the data
			return top.getData();
		} 
		catch (EmptyStackException e)
		{
			//If the stack is empty, print error and return null
			System.out.println("Cannot peek, the stack is empty.");
			return null;
		}
	}
	
	/**
	 * Removes and returns the object at the top of the stack
	 * 
	 * @return Object at top of the stack
	 */
	public Object pop()
	{
		try
		{
			//If the stack is empty return an EmptyStackException
			if(numItems == 0)
				return new EmptyStackException();
			
			//Set current to data of top node
			Object current = top.getData();
		
			//Set top node link to next in stack, and decrement numItems
			top = (top.getLink());
			numItems--;
		
			//Return data at top of stack
			return current;
		}
		catch(EmptyStackException e)
		{
			//If the stack is empty, print error and return null
			System.out.println("Cannot remove objects from an empty stack");
			return null;
		}
	}
	
	/**
	 * Adds a new object to the top of the stack
	 * 
	 * @param newTop Object to be added to the top of the stack
	 */
	public void push(Object newTop)
	{
		//Set top to a new node with the current top as its link
		top = new Node(newTop, top);
		numItems++;
	}
	
	/**
	 * Prints out all of the objects in the stack
	 * 
	 * @return String of all the objects
	 */
	public String toString()
	{
		String result = "";
		Node current = top;
		
		//While current node is not null...
		while(current != null)
		{
			//...add current Node's data to result and change current 
			//to next in stack
			result = result + current.getData().toString() + "\n";
			current = current.getLink();
		}
		
		return result;
	}
	
	/**
	 * Returns the current size of the stack
	 * 
	 * @return Int, the size of the stack
	 */
	public int size()
	{
		return numItems;
	}
}
