
import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	private TreeNode<String> root;
	private String fetched_node;
	
	public MorseCodeTree(){
		buildTree();
	}
	
	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}

	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String letter) {
		addNode(root, code, letter);
		return this;
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 1){
			if (code.equals(".")){
				root.left = new TreeNode<String>(letter);
			}else{
				root.right = new TreeNode<String>(letter);
			}
			return;
		}else{
			if (code.startsWith(".")){
				addNode(root.left, code.substring(1), letter);
			}else{
				addNode(root.right, code.substring(1), letter);
			}
		}
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if(code.length() == 1){
			if (code.equals(".")){
				fetched_node = root.left.getData();
			}else{
				fetched_node = root.right.getData();
			}
		}else{
			if (code.startsWith(".")){
				return fetchNode(root.left, code.substring(1));
			}else{
				return fetchNode(root.right, code.substring(1));
			}
		};
		return fetched_node;
	}

	

	@Override
	public void buildTree() {
       root = new TreeNode<String>("");
       // First level two children
       insert(".", "e");
       insert("-", "t");
      
       // Second level four children
       insert("..", "i");
       insert(".-", "a");
       insert("-.", "n");
       insert("--", "m");
      
       // Third level eight children
       insert("...", "s");
       insert("..-", "u");
       insert(".-.", "r");
       insert(".--", "w");
       insert("-..", "d");
       insert("-.-", "k");
       insert("--.", "g");
       insert("---", "o");

       // Fourth level twelve children
       insert("....", "h");
       insert("...-", "v");
       insert("..-.", "f");
       insert(".-..", "l");
       insert(".--.", "p");
       insert(".---", "j");
       insert("-...", "b");
       insert("-..-", "x");
       insert("-.-.", "c");
       insert("-.--", "y");
       insert("--..", "z");
       insert("--.-", "q");   
		
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> arr = new ArrayList<String>();
		LNRoutputTraversal(root, arr);
		return arr;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null){
			LNRoutputTraversal(root.left,list);
			list.add(root.getData());
			LNRoutputTraversal(root.right, list);
		}
		
	}
	
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

}
