import java.util.ArrayList;  // Use ArrayList, if you must, ONLY LOCALLY


/**
 *  The Strie Class.
 *  @author Abdikarim Abdirahman
 * 
 */
public class Strie{


 /**
  *  the root of the StrieNode.
  */
 private StrieNode root; 

 /**
  *  default constructor.
  */
 public Strie(){
  root=new StrieNode();

 }

 /**
  *  Checks if the Stride Node is empty.
  *  @param  myStrie the Strie i am checking.
  *  @return bool.
  */
 public static boolean isEmptyStrie(Strie myStrie){

  boolean bool=true;

  if ((myStrie.root.isEmptyNode())==true)
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
  *  inserts a word into the Strie.
  *  @param  word the word you want to insert.
  */

 public void insert(String word){

  StrieNode node =null;
  StrieNode temp= root;
  int count=0;

  if (word==null)
  {
   throw new RuntimeException("Invalid character entered. Characters must be between 'a' and 'z' ");

  }
  if (word.length()==0)
  {

   throw new RuntimeException("Invalid character entered. Characters must be between 'a' and 'z' ");
  }
  for (int i=0;i<word.length();i++)
  {
   int value = (int)(word.charAt(i));
   if (value<97 || value>122)
   {
    throw new RuntimeException("Invalid character entered. Characters must be between 'a' and 'z' ");
   }
   if (temp.getChild(word.charAt(i))==null)
   {
    node = new StrieNode();
    temp.putChild(word.charAt(i), node);

   }
   temp=temp.getChild(word.charAt(i)); 
   if (i==word.length()-1)
   {
    temp.setEnd();
   }
  }
 }



 /**
  *  checks if the Strie contains the word .
  *  @param  word the word you are checking.
  *  @return bool  if it contains it or not.
  */

 public boolean contains(String word){

  boolean bool=true;
  StrieNode temp = root;

  if (word==null)
  {
   return false;
  }

  if (word.length()==0)
  {
   return false;
  }



  for (int i=0;i<word.length();i++)
  { 




   int value=(int)(word.charAt(i));

   if ((value<97 || value>122))
   {

    return false;

   }

   if (!(temp.getChild(word.charAt(i))==null || (value<97 || value>122)))
   {
    bool=true;


   }

   if (temp.getChild(word.charAt(i))==null || (value<97 || value>122))
   {



    return false;
   }

   if (i==word.length()-1 && !(temp.getChild(word.charAt(i)).isEnd()))
   {
    return false;
   }





   temp=temp.getChild(word.charAt(i));

  }

  return bool;
 }



 /**
  *  helper method that helps me remove nodes .
  *  @param  word the word I am trying to remove.
  *  @param  value the postion of the node.
  *  @return temp  the node I am trying to remove.
  */
 private StrieNode depth(int value, String word)
 {
  StrieNode temp= root;


  for (int i=0;i<=value;i++)
  {

   temp=temp.getChild(word.charAt(i));

  }

  return temp;

 }
 /**
  *  a helper method I use to check on how I remove the word.
  *  @param  word the word I am checking .
  *  @return i  the number of words in the one word.
  */

 public int finder(String word)
 {
  StrieNode temp= root;
  String order="";
  int size=0;

  for (int i=0;i<word.length();i++)
  {


   if (temp.getChild(word.charAt(i))!=null)

   {

    temp=temp.getChild(word.charAt(i));
    order=help(temp);
    if (order.length()>2) 
    {
     return i;
    }

   } 

  }


  return -1;


 }

 /**
  *  helper method that helps me remove nodes .
  *  @param  word the word I am trying to remove.
  *  @param  value the postion of the node.
  */
 private void removal(int value, String word) {
  StrieNode temp= root;



  for (int i=word.length()-2;i>=0;i--)
  {

   temp=depth(i,word);

   if (i==value-1)
   {


    break;
   }


   temp.putChild(word.charAt(i+1), null);
   if (temp.isEnd())
   {
    break;
   }






  }

 }

 /**
  *  helper method that helps me remove nodes .
  *  @param  word the word I am trying to remove.
  *  @return temp  the node I am trying to remove.
  */
 private int path(String word) {
  int count=0;
  for (int i=0;i<word.length();i++)
  {

   if ((depth(i,word)).isEnd())
   {

    count++;
   }

  }

  return count;
 }



 /**
  *  remove method that removes nodes .
  *  @param  word the word I am trying to remove.
  *  @return true  if it removes.
  */
 public boolean remove(String word){
  if (!contains(word))
  {
   return false;
  }


  StrieNode temp= root;
  int val= word.length()-1;


  if (path(word)==1 && finder(word)==-1 && depth(val,word).isEmptyNode())
  {



   int value=word.length()-2;
   for (int i=word.length()-1;i>=0;i--)
   {
    temp=depth(value--,word);
    temp.putChild(word.charAt(i), null);
   }
  }

  else
  {
   int end =word.length()-1;
   if (!depth(end,word).isEmptyNode())
   {
    depth(end,word).unsetEnd();
   }

   else
   {
    removal(finder(word),word);
   }



  }

  return true;
 }




 /**
  *  helper mehtod that gets the children of a parent .
  *  @param  myStrie the node.
  *  @return order  the children.
  */


 private static String help(StrieNode myStrie){
  String order="";
  for (int i=0;i<myStrie.getAllChildren().length;i++)
  {
   if (myStrie.getAllChildren()[i]!=null)
   {
    order+=((char)(i+97));
    order+=" ";
   }

  }
  return order;
 } 


 /**
  *  a Breadth First Traversal of myStrie.
  *  @param  myStrie the Strie.
  *  @return String  the level Order Traversal.
  */

 public static String levelOrderTraversal(Strie myStrie){
  String order="";
  StrieNode temp=myStrie.root;
  boolean bool=true;

  ArrayList<StrieNode> queue = new ArrayList<StrieNode>();

  queue.add(temp);

  while (bool)
  {
   temp=queue.remove(0);
   order+=help(temp);

   for (int i=0;i<myStrie.root.getAllChildren().length;i++)
   {

    if (temp.getAllChildren()[i]!=null && !queue.contains(temp.getAllChildren()[i]))
    {

     queue.add(temp.getAllChildren()[i]);

    }    
   }
   if (queue.isEmpty())
   {
    bool=false;
   }


  }
  return order;
 }



 /**
  *  Gets the longest prefix among the word in the Strie .
  *  @param  myStrie the Strie I am looking for in it .
  *  @param  query the word.
  *  @return order the prefix.
  */

 public static String getLongestPrefix(Strie myStrie, String query){

  String word = null ;
  StrieNode temp=myStrie.root;
  boolean bool=false;


  StringBuffer letters = new StringBuffer();
  int end=0;

  if (query==null)
  {
   throw new RuntimeException ("No prefix found!");
  }


  if (isEmptyStrie(myStrie))
  {
   throw new RuntimeException ("No prefix found!");
  }



  for (int i=0;i<query.length();i++)
  {
   if (temp.getChild(query.charAt(i))!=null)
   {
    letters.append(Character.toString(query.charAt(i)));
    temp=temp.getChild(query.charAt(i));
    if (temp.isEnd())
    {
     end=i;
    }
   }
  }
  word=String.join("",letters);




  if (myStrie.contains(word))
  {
    
   bool=true;
   return word;
  }
  else
  {


   if (end+1<=word.length())
   {
     System.out.println("hi");
    word=word.substring(0, end+1);
    bool=true;

   }


  }

  if (!bool)
  {
   throw new RuntimeException ( "No prefix found!");
  }

  return word;
 }



 /**
  *  main method.
  *  @param args main method
  */
 public static void main(String[] args){ 

 }

}
