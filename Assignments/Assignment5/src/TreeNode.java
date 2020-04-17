
public class TreeNode<T> {
	public TreeNode<T> left;
	public TreeNode<T> right;
	public T data;
	
	public TreeNode(T dataNode){
		this.left = null;
		this.right = null;
		this.data = dataNode;
	}
	
	public TreeNode(TreeNode<T> node){
		this.left = node.left;
		this.right = node.right;
		this.data = node.data;
	}
	
	public T getData(){
		return data;
	}

}
