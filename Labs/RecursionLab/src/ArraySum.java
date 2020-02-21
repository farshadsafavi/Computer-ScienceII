
public class ArraySum {
	// recursively add all ements of an array
	public int sumOfArray(Integer[] myArray, int n) {
		if(n >= 0){
			return sumOfArray(myArray, n - 1) + myArray[n];
		}
		return 0;
	}
	
}
