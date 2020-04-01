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
	 * This method uses a while loop to loop over each element in the stack.
	 * As it loops it multiplies the result by 10 and then adds the next int 
	 * in the stack. At the end of this method the stack will be empty.
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
			
			int result = 0;			//Stores numerical representation
								
			//While the ints stack is not empty...
			while(!ints.isEmpty())
			{
				//...first check that the data is an integer then...
				if(!(ints.peek() instanceof Integer))
					throw new IllegalArgumentException();
				
				//...multiply result by 10 and add next int in stack...
				result = (result * 10) + ((int)ints.pop());
	
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
	
	/**
	 * 
	 * @param args
	 */
	public static int popSome(LinkedStack stack, int count)
	{
		try
		{
			if(stack.isEmpty())
				throw new EmptyStackException();
			
			int sum = 0;
			
			while(count > 0 && !stack.isEmpty())
			{	
				count--;
				sum = (int)stack.pop() + sum;
			}
			
			if(count > 0)
				return -1;
			
			return sum;
		
		}
		catch(EmptyStackException e)
		{
			System.out.println("The stack is empty.");
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
		
		stackToIntsTest.push(7);
		stackToIntsTest.push(5);
		stackToIntsTest.push(4);
		stackToIntsTest.push(2);
		
		System.out.println("Expected: 2457 Actual: " + Driver.stackToInt(stackToIntsTest));
		
		LinkedStack stackToIntsTestNotInts = new LinkedStack();
		stackToIntsTestNotInts.push(new Adventurer("","", 7));
		
		System.out.println("Expected: -1 Actual: " + Driver.stackToInt(stackToIntsTestNotInts));
		
		//Testing popSome()
		System.out.println();
		System.out.println("|----Testing popSome()----|");
		
		LinkedStack popSomeTests = new LinkedStack();
		
		popSomeTests.push(5);
		popSomeTests.push(7);
		popSomeTests.push(9);
		
		//3 Integers and count 3
		System.out.println("Expected: 21 Actual: " + Driver.popSome(popSomeTests, 3));
		
		popSomeTests.push(9);
		popSomeTests.push(5);
		popSomeTests.push(3);
		popSomeTests.push(7);
		popSomeTests.push(6);
		
		//More than 3 integers in stack, count is 3
		System.out.println("Excepted: 17 Actual: " + Driver.popSome(popSomeTests, 3));
		//Less than 3 integers in stack, count is 3
		System.out.println("Expected: -1 Actual: " + Driver.popSome(popSomeTests, 3));
		//No integers in stack, count is 3
		System.out.println("Expected: -1 Actual: " + Driver.popSome(popSomeTests, 3));
		
		popSomeTests.push(7);
		popSomeTests.push(3);
		popSomeTests.push(2);
		popSomeTests.push(4);
		
		//Several integers in stack, count is 0
		System.out.println("Expected: 0 Actual: " + Driver.popSome(popSomeTests, 0));
		//Several integers in stack, count is negative
		System.out.println("Expected: 0 Actual: " + Driver.popSome(popSomeTests, -1));
	}

}
