
public class HashBucket {
	MyLinkedList[] arr;
	int size;
	
	public HashBucket(int size){
		arr = new MyLinkedList[size];
		for(int i = 0; i < size; i++){
			arr[i] = new MyLinkedList();
		}
		this.size = size;
	}
	
	public int generate_key(int pk){
		return pk % size;
	}
	
	public void add(int pk){
		arr[generate_key(pk)].add(pk);
	}
	
	public int getSize(int pk){
		return arr[generate_key(pk)].getSize();
	}
	
	public void print(){
		for(int i = 0; i < size; i++){
			arr[i].print();
			System.out.println("-----------------");
		}
	}
}
