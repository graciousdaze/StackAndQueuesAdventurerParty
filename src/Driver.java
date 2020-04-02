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
	public static int stackToInt(LinkedStack<Integer> ints)
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
	public static int popSome(LinkedStack<Integer> stack, int count)
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
	public static void extractFromStack(LinkedStack<Adventurer> adventurerStack, String key)
	{
		try
		{
			//If the stack is empty throw an exception
			if(adventurerStack.isEmpty())
				throw new EmptyStackException();
			
			LinkedStack<Adventurer> temporary = new LinkedStack<Adventurer>();			//Holds popped objects that don't match the key
			Adventurer comparison = new Adventurer("", key);	//Adventurer object with key to be compared to
			Adventurer current = new Adventurer("","");			//Tracks current adventurer in stack being compared
		
			//While the adventurerStack is not empty
			while(!adventurerStack.isEmpty())
			{
				//Pop off current top and set to current
				current = adventurerStack.pop();
				
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
	
	/**
	 * This methods takes two different stacks holding Adventurer objects. It then
	 * compares each of the items in the stacks to see if the stacks are equal. It uses
	 * two temporary stacks to hold the elements in each list in order to traverse the
	 * stacks without losing data. The temporary stacks data is then pushed back into the
	 * stacks at the end
	 * 
	 * @param stack_one One of the stacks to be compared with
	 * @param stack_two One of the stacks to be compared with
	 * @return True If the stacks are equal
	 * 		   False If the stacks are not equal
	 */
	public static boolean equalStacks(LinkedStack<Adventurer> stack_one, LinkedStack<Adventurer> stack_two)
	{
		//If both stacks are empty return true, otherwise if one list is empty return false
		if(stack_one.isEmpty() && stack_two.isEmpty())
			return true;
		else if(stack_one.isEmpty() || stack_two.isEmpty())
			return false;
		
		LinkedStack<Adventurer> temp_one = new LinkedStack<Adventurer>();	//Temporary stack to hold stack one data
		LinkedStack<Adventurer> temp_two = new LinkedStack<Adventurer>();	//Temporary stack to hold stack two data
		
		Adventurer current_one = stack_one.pop();	//Tracks stack_one's current Adventurer
		Adventurer current_two = stack_two.pop();	//Tracks stack_two's current Adventurer
		
		boolean isEqual = false;	//Tracks if stacks are equal
		
		//While stack one's current adventurer is equal to stack two's current adventurer...
		while(current_one.compareTo(current_two) == 0)
		{
			//...if both stacks are now empty, the stacks are equal, break from loop...
			if(stack_one.isEmpty() && stack_two.isEmpty())
			{
				isEqual = true;
				break;
			}
			//...else if only one stack is empty, the stacks are not equal, break from loop
			else if(stack_one.isEmpty() || stack_two.isEmpty())
				break;
				
			current_one = stack_one.pop();	//Move to next object in stack_one
			current_two = stack_two.pop();	//Move to next object in stack_two
			
			temp_one.push(current_one);		//Store current stack_one object in temp_one
			temp_two.push(current_two);		//Store current stack_two object in temp_two
		}
		
		//While temp_one is not empty, push its contents back into stack_one
		while(!temp_one.isEmpty())
			stack_one.push(temp_one.pop());
		
		//While temp_two is not empty, push its contents back into stack_two
		while(!temp_two.isEmpty())
			stack_two.push(temp_two.pop());
		
		return isEqual;
	}
	
	/**
	 * This method takes a LinkedStack and an ArrayQueue of integers. It then swaps the values between the two data
	 * structures.
	 * 
	 * @param s LinkedStack of integers to be swapped
	 * @param q ArrayQueue of integers to be swapped
	 */
	public static void swap(LinkedStack<Integer> s, ArrayQueue<Integer> q)
	{
		//LinkedStack: pop() from front(), push() to front()
		//ArrayQueue: add() to rear, remove() from front
		
		int queueSize = q.size();	//Tracks number of items to swap from queue
		int stackSize = s.size();	//Tracks number of items to swap from stack
		
		//For i < the number of items in stack, pop off item in s and add to q
		for(int i = 0; i < stackSize; i++)
			q.add(s.pop());
		
		//For i < number of items in queue, remove item in q and push to s
		for(int i = 0; i < queueSize; i++)
			s.push(q.remove());
	}
	
	/**
	 * This method takes an ArrayQueue of integers and replaces any occurrences of a specified
	 * int in the queue with a new value. It maintains the order of the queue.
	 * 
	 * @param q			ArrayQueue to have values replaced in
	 * @param oldVal	int to be replaced
	 * @param newVal	int that is the replacement
	 */
	public static void replace(ArrayQueue<Integer> q, int oldVal, int newVal)
	{
		//Create a temp queue to preserve data
		ArrayQueue<Integer> temp = new ArrayQueue<Integer>(q.size());
		int currentVal = 0;	//Tracks current value
		
		//While the q is not empty...
		while(!q.isEmpty())
		{
			//...remove item and save to currentVal...
			currentVal = q.remove();
			
			//...if the current int equals int to be updated, 
			//update and add to temp queue, otherwise add val to temp
			if(currentVal == oldVal)
				temp.add(newVal);
			else
				temp.add(currentVal);
		}
		
		//While temp is not empty, remove items and place back into q
		while(!temp.isEmpty())
			q.add(temp.remove());
		
	}
	
	/**
	 * This method takes a queue of Adventurer objects and searches until it finds the first object
	 * with a matching search key. It then returns the position of the object. The queue remains
	 * unchanged after the method has been run.
	 * 
	 * @param q		ArrayQueue<Adventurer> to be searched through
	 * @param key	String, the key to be looking for in the queue
	 * @return		int, matching the position of the found object
	 * 				-1 if the list is empty or matching object is not found
	 */
	public static int searchQueue(ArrayQueue<Adventurer> q, String key)
	{
		//Use to preserve values while traversing the queue
		ArrayQueue<Adventurer> temp = new ArrayQueue<Adventurer>(q.size());
		Adventurer current = null;		//Used to track current Adventurer data
		Adventurer comparison = new Adventurer("", key);	//Object to be compared to
		boolean found = false;	//Tracks if item is found
		int position = 1;		//Tracks position of current item
		
		//While q is not empty...
		while(!q.isEmpty())
		{			
			//Set current to the item removed from q...
			current = q.remove();
			
			//...if current item is the one being looked for set found to true...
			if(current.compareTo(comparison) == 0)
				found = true;
			//...otherwise, if item is still not found increment the position
			else if(!found)
				position++;
			
			//Add current adventurer data to the temp queue
			temp.add(current);
		}
		
		//While temp is not empty, remove data and add back to q
		while(!temp.isEmpty())
			q.add(temp.remove());
			
		//If found is true return position
		if(found)
			return position;
					
		//Return -1 as item is not found or list is empty
		return -1;
	}
	
	/**
	 * This method takes a queue of integers. It removes the even ints from the queue 
	 * and returns a new queue with all of the even elements. The param queue maintains the 
	 * odd elements unchanged and in the same order.
	 * 
	 * @param q ArrayQueue<Integer> to have even elements removed from
	 * @return	ArrayQueue<Integer> with all the even elements removed from queue q
	 */
	public static ArrayQueue<Integer> evenElements(ArrayQueue<Integer> q)
	{
		//Use to hold even elements to be returned
		ArrayQueue<Integer> even = new ArrayQueue<Integer>(q.size());
		//Used to preserve odd numbers to put back into q after traversing
		ArrayQueue<Integer> odd = new ArrayQueue<Integer>(q.size());
		int current = 0;	//Tracks current data being looked at
		
		//While q is not empty
		while(!q.isEmpty())
		{
			//Remove an item and set current equal to it
			current = q.remove();
			
			//If current mod 2 is 0, add it to even, otherwise add it to odd
			if(current % 2 == 0)
				even.add(current);
			else
				odd.add(current);
		}
		
		//While odd is not empty, remove items and put back into q
		while(!odd.isEmpty())
			q.add(odd.remove());
		
		//Return the queue of even elements
		return even;
	}
	
	/**
	 * This method takes an ArrayQueue<Integer> and splits the items into two queues, one with 
	 * even ints and the other with odd ints. It then returns an array holding the two new
	 * queues. The input queue at the end of this method is empty.
	 * 
	 * @param q	ArrayQueue<Integer> to be split into two queues, one with even ints and one with odd
	 * @return	ArrayQueue<Integer>[] array containing the resulting even and odd queues
	 */
	public static ArrayQueue<Integer>[] split(ArrayQueue<Integer> q)
	{
		ArrayQueue<Integer> even = new ArrayQueue<Integer>(q.size());
		ArrayQueue<Integer> odd = new ArrayQueue<Integer>(q.size());
		ArrayQueue[] evensAndOdds = {even,odd};
		int current = 0;
		
		//While q is not empty
		while(!q.isEmpty())
		{
			//Remove an item and set current equal to it
			current = q.remove();
			
			//If current mod 2 is 0, add it to even, otherwise add it to odd
			if(current % 2 == 0)
				even.add(current);
			else
				odd.add(current);
		}
		
		return evensAndOdds;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Testing stackToInt()
		System.out.println("|----Testing stackToInt()----|");
		
		LinkedStack<Integer> stackToIntsTest = new LinkedStack<Integer>();
		
		System.out.println("Expected: -1 Actual: " + Driver.stackToInt(stackToIntsTest));
		
		stackToIntsTest.push(0);
		
		System.out.println("Expected: 0 Actual: " + Driver.stackToInt(stackToIntsTest));
		
		stackToIntsTest.push(7);
		stackToIntsTest.push(5);
		stackToIntsTest.push(4);
		stackToIntsTest.push(2);
		
		System.out.println("Expected: 2457 Actual: " + Driver.stackToInt(stackToIntsTest));
				
		//Testing popSome()
		System.out.println();
		System.out.println("|----Testing popSome()----|");
		
		LinkedStack<Integer> popSomeTests = new LinkedStack<Integer>();
		
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
		
		LinkedStack<Adventurer> adventurerStack = new LinkedStack<Adventurer>();
		
		//Stack is empty
		System.out.println("Expected: 'No changes, the stack is currently empty.'\nActual: ");
		Driver.extractFromStack(adventurerStack, "Wizard");
		
		Adventurer adventurer_one = new Adventurer("", "Paladin", 3);
		Adventurer adventurer_two = new Adventurer("", "Cleric", 5);
		Adventurer adventurer_three = new Adventurer("", "Wizard", 6);
		Adventurer adventurer_four = new Adventurer("", "Druid", 7);
		Adventurer adventurer_five = new Adventurer("", "pAlAdiN", 7);
		Adventurer adventurer_six = new Adventurer("", "cLERIc");
		Adventurer adventurer_seven = new Adventurer("","wIzarD");
		Adventurer adventurer_eight = new Adventurer("", "druID");
		
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
		
		//Testing equalStacks()
		System.out.println("\n|----Testing equalStacks()----|");
		
		LinkedStack<Adventurer> equalStacksTest_one = new LinkedStack<Adventurer>();
		LinkedStack<Adventurer> equalStacksTest_two = new LinkedStack<Adventurer>();
		
		//Testing both empty, should be true
		System.out.println("Expected: true Actual: " + Driver.equalStacks(equalStacksTest_one, equalStacksTest_two));

		equalStacksTest_one.push(adventurer_one);
		equalStacksTest_one.push(adventurer_two);
		equalStacksTest_one.push(adventurer_three);
		equalStacksTest_one.push(adventurer_four);
		
		//Testing when only one stack is empty, should be true
		System.out.println("Expected: false Actual: " + Driver.equalStacks(equalStacksTest_one, equalStacksTest_two));
		
		equalStacksTest_two.push(adventurer_five);
		equalStacksTest_two.push(adventurer_six);
		equalStacksTest_two.push(adventurer_seven);
		equalStacksTest_two.push(adventurer_eight);
		
		//Testing when both stacks are not empty and are equal
		System.out.println("Expected: true Actual: " + Driver.equalStacks(equalStacksTest_one, equalStacksTest_two));
		
		equalStacksTest_two.pop();
		equalStacksTest_two.pop();
		
		//Testing when both stacks are not empty and are not equal
		System.out.println("Expected: false Actual: " + Driver.equalStacks(equalStacksTest_one, equalStacksTest_two));
		
		//Testing swap()
		System.out.println("\n|----Testing swap()----|");
		
		LinkedStack<Integer> swapStackTests = new LinkedStack<Integer>();
		ArrayQueue<Integer> swapQueueTests = new ArrayQueue<Integer>();
		
		swapStackTests.push(1);
		swapStackTests.push(2);
		swapStackTests.push(3);
		
		swapQueueTests.add(9);
		swapQueueTests.add(8);
		swapQueueTests.add(7);
		
		//Stack and queue have multiple elements and are the same length
		System.out.println("Stack Before:\n" + swapStackTests.toString());
		System.out.println("Queue Before:\n" + swapQueueTests.toString());
		
		Driver.swap(swapStackTests, swapQueueTests);
		
		System.out.println("Expected: 7 8 9 \nActual:\n" + swapStackTests.toString());
		System.out.println("Expected: 3 2 1 \nActual:\n" + swapQueueTests.toString());
		
		//Stack and queue have multiple elements and are different lengths
		swapQueueTests.remove();
		swapStackTests.push(6);
		
		Driver.swap(swapStackTests, swapQueueTests);
		
		System.out.println("Expected: 1 2\nActual:\n" + swapStackTests.toString());
		System.out.println("Expected: 6 7 8 9\nActual:\n" + swapQueueTests.toString());
		
		//Stack is empty but queue is not
		swapStackTests.pop();
		swapStackTests.pop();
		
		Driver.swap(swapStackTests, swapQueueTests);
		
		System.out.println("Expected: 9 8 7 6\nActual:\n" + swapStackTests.toString());
		System.out.println("Expected: \nActual:\n" + swapQueueTests.toString());
		
		//Queue is empty but stack is not
		Driver.swap(swapStackTests, swapQueueTests);
		
		System.out.println("Expected: \nActual:\n" + swapStackTests.toString());
		System.out.println("Expected: 9 8 7 6\nActual:\n" + swapQueueTests.toString());
		
		//Both queue and stack are empty
		swapQueueTests.remove();
		swapQueueTests.remove();
		swapQueueTests.remove();
		swapQueueTests.remove();
		
		Driver.swap(swapStackTests, swapQueueTests);
		
		System.out.println("Expected:\nActual:\n" + swapStackTests.toString());
		System.out.println("Expected:\nActual:\n" + swapQueueTests.toString());
		
		//Testing replace()
		System.out.println("\n|----Testing replace()----|");
		
		ArrayQueue<Integer> replaceTests = new ArrayQueue<Integer>();
		
		//Queue is empty
		Driver.replace(replaceTests, 1, 3);
		
		System.out.println("Expected:\nActual: " + replaceTests.toString());
		
		replaceTests.add(1);
		replaceTests.add(2);
		replaceTests.add(3);
		
		//Queue has multiple entries including one oldVal, oldVal is first in queue
		Driver.replace(replaceTests, 1, 3);
		System.out.println("\nExpected: 3 2 3\nActual:\n" + replaceTests.toString());
		
		//Queue has multiple entries including multiple oldVal
		Driver.replace(replaceTests, 3, 5);
		System.out.println("Expected: 5 2 5\nActual:\n" + replaceTests.toString());
		
		//Queue has multiple entries, not including oldVal
		Driver.replace(replaceTests, 7, 8);
		System.out.println("Expected: 5 2 5\nActual:\n" + replaceTests.toString());
		
		//Queue has multiple entries, oldval is located at the end
		replaceTests.add(9);
		
		Driver.replace(replaceTests, 9, 1);
		System.out.println("Expected: 5 2 5 1\nActual:\n" + replaceTests.toString());
		
		//Testing searchQueue()
		System.out.println("|----Testing searchQueue()----|");
		
		ArrayQueue<Adventurer> searchQueueTests = new ArrayQueue<Adventurer>();
		
		//The queue is empty
		System.out.println("Expected: -1 Actual: " + Driver.searchQueue(searchQueueTests, "Paladin"));
		
		searchQueueTests.add(adventurer_one);
		searchQueueTests.add(adventurer_two);
		searchQueueTests.add(adventurer_three);
		searchQueueTests.add(adventurer_four);
		
		//Queue has several items and matching one is in the middle
		System.out.println("Expected: 3 Actual: " + Driver.searchQueue(searchQueueTests, "wIzaRD"));
		
		//Queue has several items and matching one is in the front
		System.out.println("Expected: 1 Actual: " + Driver.searchQueue(searchQueueTests, "paladin"));
		
		//Queue has several items and matching one is at the rear
		System.out.println("Expected: 4 Actual: " + Driver.searchQueue(searchQueueTests, "Druid"));
		
		//Queue has several items and none of them match the key
		System.out.println("Expected: -1 Actual: " + Driver.searchQueue(searchQueueTests, "inquistor"));
		
		//Testing evenElements()
		System.out.println("\n|----Testing evenElements()---|");
		
		ArrayQueue<Integer> evenElementsTests = new ArrayQueue<Integer>();
		
		//Queue is empty
		ArrayQueue<Integer> queueIsEmpty = Driver.evenElements(evenElementsTests);
		System.out.println("Expected: Actual: " + evenElementsTests.toString());
		System.out.println("Expected: Actual: " + queueIsEmpty.toString());
		
		evenElementsTests.add(0);
		evenElementsTests.add(1);
		evenElementsTests.add(2);
		evenElementsTests.add(3);
		evenElementsTests.add(4);
		evenElementsTests.add(5);
		evenElementsTests.add(6);
		
		//Queue has a mixture of even and odd numbers including 0
		ArrayQueue<Integer> mixtureTestResults = Driver.evenElements(evenElementsTests);
		System.out.println("\nExpected: 1 3 5\nActual:\n" + evenElementsTests.toString());
		System.out.println("Expected: 0 2 4 6\nActual:\n" + mixtureTestResults);
		
		//Queue only has even numbers
		ArrayQueue<Integer> evensOnlyTest = Driver.evenElements(mixtureTestResults);
		System.out.println("\nExpected: Actual: " + mixtureTestResults.toString());
		System.out.println("\nExpected: 0 2 4 6\nActual:\n" + evensOnlyTest.toString());
		
		//Queue only has odd numbers
		ArrayQueue<Integer> oddsOnlyTest = Driver.evenElements(evenElementsTests);
		System.out.println("\nExpected: 1 3 5\nActual:\n" + evenElementsTests.toString());
		System.out.println("Expected: Actual: " + oddsOnlyTest.toString());
		
		//Testing split()
		System.out.println("\n|----Testing split()----|");
		ArrayQueue<Integer> splitTests = new ArrayQueue<Integer>();
		
		//Queue is empty
		ArrayQueue[] oddsAndEvens = Driver.split(splitTests);
		
		System.out.println("Expected: Actual: " + oddsAndEvens[0].toString());
		System.out.println("Expected: Actual: " + oddsAndEvens[1].toString());
		
		splitTests.add(0);
		splitTests.add(1);
		splitTests.add(2);
		splitTests.add(3);
		splitTests.add(4);
		splitTests.add(5);
		
		//Queue has mixture of odds and evens
		oddsAndEvens = Driver.split(splitTests);
		
		System.out.println("Expected: 0 2 4\nActual:\n" + oddsAndEvens[0]);
		System.out.println("Expected: 1 3 5\nActual:\n" + oddsAndEvens[1]);
		
		ArrayQueue<Integer> odds = oddsAndEvens[1];
		
		//Queue has only even numbers
		oddsAndEvens = Driver.split(oddsAndEvens[0]);
		
		System.out.println("Expected: 0 2 4\nActual:\n" + oddsAndEvens[0]);
		System.out.println("Expected: \nActual:\n" + oddsAndEvens[1]);
		
		//Queue only has odd numbers
		oddsAndEvens = Driver.split(odds);
		
		System.out.println("Expected: \nActual:\n" + oddsAndEvens[0]);
		System.out.println("Expected: 1 3 5\nActual:\n" + oddsAndEvens[1].toString());
		
	}

}
