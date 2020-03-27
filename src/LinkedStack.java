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
	
}
