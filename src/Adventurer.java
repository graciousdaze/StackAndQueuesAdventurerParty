/**
 * This class contains fields and methods to define an Adventurer object
 * Search Key: characterClass, String
 * 
 * @author Grace O'Brien
 * April 1st, 2020
 *
 */
public class Adventurer implements Comparable<Adventurer> {

	private String name;			//Adventurer's name
	private String characterClass;  //Adventurer's class (Ex. Mage, Warrior, etc.), Search Key
	private int level;				//Adventurer's current level
	
	/**
	 * Adventurer constructor. Starts adventurer at default level 1 and base hit
	 * points.
	 * 
	 * @param name	String, Adventurer's name
	 * @param characterClass String, Adventurer's chosen class
	 */
	public Adventurer(String name, String characterClass)
	{
		this.name = name;
		this.characterClass = characterClass;
		level = 1;
	}
	
	/**
	 * Adventurer constructor. Creates adventurer starting at the given level
	 * 
	 * @param name String,Adventurer's name
	 * @param characterClass String, Adventurer's chosen class
	 * @param level
	 */
	public Adventurer(String name, String characterClass, int level)
	{
		try {
			if(level < 0)
				throw new ArithmeticException("Level cannot be below 0");

			this.name = name;
			this.characterClass = characterClass;
			this.level = level;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * Setter method to update the Adventurer's name
	 * 
	 * @param name String, Adventurer's new name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Getter method to get the Adventurer's name
	 * 
	 * @return The Adventurer's name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Setter method to update the Adventurer's characterClass
	 * 
	 * @param characterClass The Adventurer's new class
	 */
	public void setCharacterClass(String characterClass)
	{
		this.characterClass = characterClass;
	}
	
	/**
	 * Getter method to return the Adventurer's characterClass
	 * 
	 * @return The Adventurer's characterClass
	 */
	public String getCharacterClass()
	{
		return characterClass;
	}
	
	/**
	 * Setter method to update the Adventurer's level
	 * 
	 * @param level int, the new level to be updated to
	 */
	public void setLevel(int level)
	{
		try
		{
			if(level < 0)
				throw new ArithmeticException("Error: Level cannot be below 0");
			this.level = level;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * Getter method to get the Adventurer's level
	 * 
	 * @return The Adventurer's current level
	 */
	public int getLevel()
	{
		return level;
	}
	
	/**
	 * This formats the Adventurer's information as a string and returns it
	 * 
	 * @return The Adventurer's information as a String
	 */
	public String toString()
	{
		String result = String.format("%-12s %-18s %-12d", 
						name, characterClass, level);
		return result;
	}
	
	/**
	 * This method checks to see if the invoking Adventurer is equal to the
	 * passed in Adventurer
	 * 
	 * @param adventurer2 The adventurer to be checked for equality
	 * @return True If the Adventurers have the same class
	 * 		   False If the Adventurers have a different class
	 */
	public boolean equals(Adventurer adventurer2)
	{
		if(this.compareTo(adventurer2) == 0)
			return true;
		
		return false;
	}
	
	/**
	 * This method compares an invoking adventurer with a second adventurer, and 
	 * returns an integer denoting the invoking Adventurer's search key's placement in relation
	 * to the Adventurer parameter's search key
	 * 
	 * @return -1 If the invoking Adventurer's search key is less than parameter's search key
	 * 		    0 If The invoking Adventurer's search key is equal to parameter's search key
	 * 			1 If the invoking Adventurer's search key is greater than parameter's search key
	 */
	@Override
	public int compareTo(Adventurer key)
	{	
		if(this.characterClass.compareToIgnoreCase(key.getCharacterClass()) > 0)
			return 1;
		else if(this.characterClass.compareToIgnoreCase(key.getCharacterClass()) < 0)
			return -1;
		else
			return 0;
	}
	
}
