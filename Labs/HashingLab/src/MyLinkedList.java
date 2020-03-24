
public class MyLinkedList {
	Node head;
	int size;
	
	public MyLinkedList(){
		head = null;
		size = 0;
	}
	
	public void add(int data){
		Node c = head;
		Node newNode = new Node(data, null);
		if(c == null){
			head = newNode;
		} else{
			newNode.next = head;
			head = newNode;
		}
		size++;
	}
	
	public void print(){
		Node c = head;
		while(c != null){
			System.out.print(c.data + "-->");
			c = c.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	public int getSize(){
		return size;
	}
	
	class Node{
		int data;
		Node next;
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}

}
