
public class main {
  
    // Driver program to test above function 
    public static void main(String args[]) 
    { 
        Tree t2 = new Tree(); 
        int arr[] = { 45, 38, 65, 34, 41, 63, 72, 16, 35, 39, 44, 55, 64 }; 
        t2.root = t2.insertLevelOrder(arr, t2.root, 0); 
        t2.inOrder(t2.root);
        System.out.println();
        t2.preOrder(t2.root); 
        System.out.println();
        t2.postOrder(t2.root); 
        System.out.println();
    } 
}
