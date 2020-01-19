/**
 *  The StrieNode Class.
 * 
 *  @author Abdikarim Abdirahman
 * 
 */
public class StrieNode{

	/**
	 * the size of the children array.
	 */
	private static final int NUM_CHILDREN = 26;
	/**
	 * the children .
	 */
	private StrieNode[] children = new StrieNode[NUM_CHILDREN];  
	/**
	 * if it the end of the word.
	 */
	private boolean endMarker;  
	/**
	 * the removed status.
	 */
	private boolean removed;  
	/**
	 *  default constructor.
	 */

	public StrieNode(){

	}

	/**
	 *  sets the removed node .
	 */
	public void setRemoved(){
		removed=true;

	}

	/**
	 *   unsets the removed node .
	 */
	public void unsetRemoved(){
		removed=false;

	}

	/**
	 *  checks if the node is removed.
	 *  @return bool.
	 */
	public boolean isRemoved(){


		return removed;
	}

	/**
	 *  checks if the node contains the letter.
	 *  @param  ch the letter .
	 *  @return bool .
	 */
	public boolean containsChar(char ch){
		boolean bool=true;
		if (children[((int)ch)-97]!=null)
		{
			bool=true;
		}
		else
		{
			bool=false;
		}
		return bool;
	}

	/**
	 *  gets the node that has the child.
	 *  @param  ch the letter.
	 *  @return children[(int)ch-97].
	 */

	public StrieNode getChild(char ch){

		return children[(int)ch-97];
	}


	/**
	 *  puts the child node in a postion in the array.
	 *  @param  ch the letter .
	 *  @param  node .
	 */


	public void putChild(char ch, StrieNode node){
		children[(int)ch-97]=node;


	}
	/**
	 *  returns the children.
	 *  @return children .
	 */

	public StrieNode[] getAllChildren(){

		return children;
	}

	/**
	 *  the number of children.
	 *  @return children.length .
	 */

	public int getNumChildren(){
		return children.length;
	}

	/**
	 *  sets the end marker.
	 */

	public void setEnd(){

		endMarker=true;

	}

	/**
	 *   unsets the end marker.
	 */

	public void unsetEnd(){

		endMarker=false;


	}
	/**
	 *  checks if it is the end of the word.
	 *  @return endMarker.
	 */
	public boolean isEnd(){
		return endMarker;



	}
	/**
	 *  checks if the node is empty.
	 *  @return bool.
	 */
	public boolean isEmptyNode(){

		boolean bool=true;
		for (int i=0;i<NUM_CHILDREN;i++)
		{
			if (children[i]!=null)
			{
				bool=false;
			}
		}



		return bool;

	}


}
