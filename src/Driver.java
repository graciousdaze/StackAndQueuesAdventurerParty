import java.util.EmptyStackException;

/**
 * Implements static methods demonstrating the usage of stacks and queues
 * 
 * @author Grace O'Brien
 * April 1st, 2020
 *
 */
public class Driver {

	/**
	 * This takes a stack of integers and returns them with an integer
	 * number representation, with the value at the top of the stack
	 * stored in the most significant digit of the resulting integer.
	 * 
	 * This method creates a temporary stack that all of the integers
	 * from the param stack ints are popped and pushed into. The temporary
	 * stack is then used to pop the values from its list, multiply accordingly
	 * to add the digit into the numerical representation, and then pushed back 
	 * onto the ints stack. The purpose of using a second stack is to be 
	 * able to preserve the original stack. 
	 * 
	 * @param ints Stack of integers
	 * @return Number representation of the stack
	 */
	public static int stackToInt(LinkedStack ints)
	{
		try
		{
			//If list is empty throw an exception
			if(ints.isEmpty())
				throw new EmptyStackException();
			
			LinkedStack temporary = new LinkedStack();	//Temporary Stack
			int result = 0;			//Stores numerical representation
			int multiplier = 1;		//Used to push values at correct significants
			int current = 0;		//Used to track current int values
			
			//While the ints stack is not empty...
			while(!ints.isEmpty())
			{
				//...first check that the data is an integer...
				if(!(ints.peek() instanceof Integer))
					throw new IllegalArgumentException();
				
				//...pop the first value from ints and push it into temporary
				current = (int)ints.pop();
				temporary.push(current);
				
			}
			
			//While temporary is not empty...
			while(!temporary.isEmpty())
			{
				//...pop the first value off of temporary and store in current...
				current = (int)temporary.pop();
				
				//...add the current value times the multiplier to the result...
				result = result + (current * multiplier);
				
				//...multiply the multiplier by 10...
				multiplier = multiplier * 10;
				
				//...and push the current value back into ints
				ints.push(current);
				
			}
			
			//return the result
			return result;
		}
		catch(EmptyStackException e)
		{
			System.out.println("Cannot operate on an empty list.");
			return -1;
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Wrong param. Only stacks with integers can be used.");
			return -1;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Testing stackToInt()
		System.out.println("|----Testing stackToInt()----|");
		
		LinkedStack stackToIntsTest = new LinkedStack();
		
		System.out.println("Expected: -1 Actual: " + Driver.stackToInt(stackToIntsTest));
		
		stackToIntsTest.push(0);
		
		System.out.println("Expected: 0 Actual: " + Driver.stackToInt(stackToIntsTest));
		
		stackToIntsTest.pop();
		stackToIntsTest.push(7);
		stackToIntsTest.push(5);
		stackToIntsTest.push(4);
		stackToIntsTest.push(2);
		
		System.out.println("Expected: 2457 Actual: " + Driver.stackToInt(stackToIntsTest));
		
		LinkedStack stackToIntsTestNotInts = new LinkedStack();
		stackToIntsTestNotInts.push(new Adventurer("","", 7));
		
		System.out.println("Expected: -1 Actual: " + Driver.stackToInt(stackToIntsTestNotInts));
		
	}

}
