import java.util.Scanner;

public class BST
 {
     public BSTNode root;
     public static int opCount;

     /* Constructor */
     public BST()
     {
         root = null;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     /* Functions to insert data */
     public void insert(LSItems data)
     {
         root = insert(root, data);
     }
     /* Function to insert data recursively */
     private BSTNode insert(BSTNode node, LSItems data)
     {
         if (node == null)
             node = new BSTNode(data);
         else
         {
             if (data.getInformation().compareTo((node.getData()).getInformation()) <= 0)
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         return node;
     }

     /* Functions to search for an element */
   /*  public LSItems search(String val)
     {
         return search(root, val);
     }
     /* Function to search for an element recursively */
     /*private LSItems search(BSTNode r, String val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             String rval = (r.getData()).getInformation();
             if (val.compareTo(rval) < 0)
                 r = r.getLeft();
             else if (val.compareTo(rval) > 0)
                 r = r.getRight();
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;


     }  */

     public LSItems search(String info){
      opCount = 0;
  		BSTNode current = root;
  		while(current!=null){
         opCount++;
  			if(current.data.getInformation().equals(info)){
  				return current.data;
  			}else if(current.data.getInformation().compareTo(info)>0){
  				current = current.left;
  			}else{
  				current = current.right;
  			}
  		}
  		return null;
  	}

    public void inorder(BSTNode root) {
      if (root != null) {
         inorder(root.left);
         System.out.println(root.data);
         inorder(root.right);
      }
    }
 }


 /* Class BSTNode */
 class BSTNode
 {
     BSTNode left, right;
     LSItems data;


     /* Constructor */
     public BSTNode(LSItems n)
     {
         left = null;
         right = null;
         data = n;
     }
     /* Function to set left node */
     public void setLeft(BSTNode n)
     {
         left = n;
     }
     /* Function to set right node */
     public void setRight(BSTNode n)
     {
         right = n;
     }
     /* Function to get left node */
     public BSTNode getLeft()
     {
         return left;
     }
     /* Function to get right node */
     public BSTNode getRight()
     {
         return right;
     }
     /* Function to set data to node */
     public void setData(LSItems d)
     {
         data = d;
     }
     /* Function to get data from node */
     public LSItems getData()
     {
         return data;
     }
 }

 /* Class BST */
