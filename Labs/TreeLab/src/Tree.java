
public class Tree<T> {
	public Node root;
	public Tree(){
		
	}
	
	// Function to insert nodes in level order 
    public Node insertLevelOrder(int[] arr, Node root, int i) 
    { 
        // Base case for recursion 
        if (i < arr.length) { 
            Node temp = new Node(arr[i]); 
            root = temp; 
            // insert left child 
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1); 
            // insert right child 
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2); 
        } 
        return root; 
    } 
  
    // Function to print tree nodes in InOrder fashion 
    public void inOrder(Node root) 
    { 
        if (root != null) { 
            inOrder(root.left); 
            System.out.print(root.data + " "); 
            inOrder(root.right); 
        } 
    } 
    
    // Function to print tree nodes in InOrder fashion 
    public void preOrder(Node root) 
    { 
        if (root != null) { 
        	System.out.print(root.data + " "); 
            preOrder(root.left); 
            preOrder(root.right); 
        } 
    } 
    
    // Function to print tree nodes in InOrder fashion 
    public void postOrder(Node root) 
    { 
        if (root != null) { 
            postOrder(root.left); 
            postOrder(root.right);
            System.out.print(root.data + " "); 
        } 
    } 

}
