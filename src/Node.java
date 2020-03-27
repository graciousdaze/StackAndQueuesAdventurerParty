/**
 * Used as a part of a linked list that stores objects. Each node
 * contains an object and a link to the next node in the list.
 * 
 * @author Grace O'Brien
 * April 1st, 2020
 *
 */
public class Node {
	
	private Object data;	//Object being held
	private Node link;		//Link to the next node in list
	
	public Node(Object data, Node link)
	{
		this.data = data;
		this.link = link;
	}
	
	/**
	 * Updates the node's data
	 * 
	 * @param data New object to replace the current object
	 */
	public void setData(Object data)
	{
		this.data = data;
	}
	
	/**
	 * Returns the node's data
	 * 
	 * @return The node's data
	 */
	public Object getData()
	{
		return data;
	}
	
	/**
	 * Updates the node's link
	 * 
	 * @param link The Node for link to be updated to
	 */
	public void setLink(Node link)
	{
		this.link = link;
	}
	
	/**
	 * Return's the Node's link, which is the next node in the list
	 * 
	 * @return The AdventurerNode that is next in the list
	 */
	public Node getLink()
	{
		return link;
	}

}
