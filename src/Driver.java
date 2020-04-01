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
	 * This method returns the sum of a number of integers from a stack, the number
	 * of integers to pop and add to the sum is determined by the count.
	 * 
	 * This method takes two params, a LinkedStack of integers and a count. It then
	 * uses a while loop to loop through the stack until either the stack is empty
	 * or the count is zero. While it is looping it pops a value off of the stack,
	 * adds it to the sum, and decrements the count. It then returns the value.
	 * 
	 * @param stack The LinkedStack this method will operate on
	 * @param count The number of ints to pop from the stack to sum
	 * @return  The sum of the integers
	 * 		   -1 	If the number of integers in the stack is less than the count or
	 *              if an error has occurred
	 */
	public static int popSome(LinkedStack stack, int count)
	{
		try
		{
			//Check if stack is empty
			if(stack.isEmpty())
				throw new EmptyStackException();
			
			int sum = 0;	//Used to track sum
			
			//While the count is greater than 0 and stack is not empty...
			while(count > 0 && !stack.isEmpty())
			{	
				//Decrement count and add the top value to the sum
				count--;
				sum = (int)stack.pop() + sum;
			}
			
			//If count is still greater than 0 return -1
			if(count > 0)
				return -1;
			
			//Return the sum
			return sum;
		
		}
		catch(EmptyStackException e)
		{
			System.out.println("The stack is empty.");
			return -1;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}
	}
	
	/**
	 * This method takes a stack of Adventurer objects and then removes any 
	 * object in the stack that matches the key passed in. It uses a temporary 
	 * stack to store popped objects that don't match, and pushes the objects 
	 * back into the adventurerStack in order to progress through the stack
	 * and hold onto the items that do not match the key.
	 * 
	 * @param stack The stack of adventurer objects to be progress through
	 * @param key	String, the key to be comparing against the objects
	 */
	public static void extractFromStack(LinkedStack adventurerStack, String key)
	{
		try
		{
			//If the stack is empty throw an exception
			if(adventurerStack.isEmpty())
				throw new EmptyStackException();
			
			LinkedStack temporary = new LinkedStack();			//Holds popped objects that don't match the key
			Adventurer comparison = new Adventurer("", key);	//Adventurer object with key to be compared to
			Adventurer current = new Adventurer("","");			//Tracks current adventurer in stack being compared
		
			//While the adventurerStack is not empty
			while(!adventurerStack.isEmpty())
			{
				//Pop off current top and set to current
				current = (Adventurer) adventurerStack.pop();
				
				//If current adventurer is not equal to search key, add it to temporary stack
				if(current.compareTo(comparison) != 0)
					temporary.push(current);	
			}
		
			//While temporary is not empty, push the top object in temporary back into the adventurerStack
			while(!temporary.isEmpty())
				adventurerStack.push(temporary.pop());
		}
		catch(EmptyStackException e)
		{
			System.out.println("No changes, the stack is currently empty.");
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
	
		//Testing extractFromStack()
		System.out.println();
		System.out.println("|----Testing extractFromStack()----|");
		
		LinkedStack adventurerStack = new LinkedStack();
		
		//Stack is empty
		System.out.println("Expected: 'No changes, the stack is currently empty.'\nActual: ");
		Driver.extractFromStack(adventurerStack, "Wizard");
		
		Adventurer adventurer_one = new Adventurer("", "Paladin", 3);
		Adventurer adventurer_two = new Adventurer("", "Cleric", 5);
		Adventurer adventurer_three = new Adventurer("", "Wizard", 6);
		Adventurer adventurer_four = new Adventurer("", "Druid", 7);
		Adventurer adventurer_five = new Adventurer("", "Paladin", 7);
		
		adventurerStack.push(adventurer_one);
		adventurerStack.push(adventurer_two);
		adventurerStack.push(adventurer_three);
		
		//Stack has multiple things, only one matches parameter
		System.out.println("\nCurrent stack:\n" + adventurerStack.toString());
		Driver.extractFromStack(adventurerStack, "Cleric");
		System.out.println("Expected:\n\tWizard\t6\n\tPaladin\t3 \nActual: \n" + adventurerStack.toString());
		
		adventurerStack.push(adventurer_five);
		adventurerStack.push(adventurer_one);
		adventurerStack.push(adventurer_four);
		adventurerStack.push(adventurer_one);
		
		//Stack has multiple things, several which match the parameter
		System.out.println("Current stack:\n" + adventurerStack.toString());
		Driver.extractFromStack(adventurerStack, "Paladin");
		System.out.println("Expected:\n\tDruid\t7\n\tWizard\t6\nActual:\n" + adventurerStack.toString());
		
		//Stack has multiple things, none of which match the parameter
		adventurerStack.push(adventurer_five);
		adventurerStack.push(adventurer_three);
		Driver.extractFromStack(adventurerStack, "Rogue");
		System.out.println("Expected:\n\tWizard\t6\n\tPaladin\t7\n\tDruid\t7\n\tWizard\t6\nActual:\n" +
							adventurerStack.toString());
		
		
	}

}
