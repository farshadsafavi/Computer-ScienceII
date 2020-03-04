/**
 * 
 * @author Farshad Safavi
 */
public class Container implements ContainerInterface{
	private int size;
	private MyStack<DonationPackage> stack;
	
	/**
	 * Provide two constructors:
	 * Container(int size) make the internal stack this size
	 * Container() make the internal stack a default size.
	 * a class Container that implements ContainerInterface.
	 * This class contains a stack of DonationPackage and simulates 
	 * adding and removing package from the container’s stack.
	 */
	public Container() {
		size = 5;
		stack = new MyStack<DonationPackage>(size);
	}
	
	public Container(int i) {
		// TODO Auto-generated constructor stub
		size = i;
		stack = new MyStack<DonationPackage>(size);
	}

	/**
	 * Stacks a new donation package  in to the container
	 * Return true if the package is stacked, false if the container is full
	 * @param dPackage a DonationPackage Object to be stacked to the container
	 * @throws ContainerException
	 */
	@Override
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		System.out.println("loadContainer");
		if(stack.isFull()){
			System.out.print("full");
			throw new ContainerException("The Container is Full");
		} else{
			stack.push(dPackage);
			return true;
		}
	}
	
	/**
	 * Removes  a DonationPackage from the stack of packages in the container
	 * ("The Container is Empty") if there is no package in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throws ContainerException
	 */
	@Override
	public DonationPackage removePackageFromContainer() throws ContainerException {
		if(stack.isEmpty()){
			throw new ContainerException("The Container is Empty");
		} else{
			return stack.pop();
		}
	}
	
	/**
	 * Returns an array of the DonationPackages in the stack.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic stack returns is an array of 
	 * type Object , i.e., Object[] temp. But since the individual elements of the array are still DonationPackages,
	 * we can copy them one by one into a new array	of type DonationPackage and cast each one to DonationPackage. 
	 * So create a new array of DonationPackages of the same length as temp, run a for-loop that casts each element 
	 * of temp to DonationPackage, and copies it to the corresponding position in the new array.  Then return the new array.
	 * 
	 * @return an array of the DonationPackages in the stack
	 */
	@Override
	public DonationPackage[] toArrayPackage() {
		// TODO Auto-generated method stub
		DonationPackage[] array_d= new DonationPackage[stack.size()];
		Object[] array = stack.toArray();
		int count = 0;
		for (Object o:array){
			array_d[count++] = (DonationPackage) o; 
		}
		return array_d;
	}
	/**
	 * helper function to return size of the container
	 * @return size of the container
	 */
	public int size(){
		return stack.size();
	}

}
