import java.util.ArrayList;

public class HashLab {

	public static void main(String[] args) {
		int[] arr = new int[13];
		for (int i = 0; i < 13; i++){
			arr[i] = -1;
		}
		int[] numbers = {12, 53, 130, 23, 121, 114, 4, 123, 27, 21};
		HashBucket hs = new HashBucket(10);
		for (int i = 0; i < numbers.length; i++){
			LQHashing(numbers[i], i, arr);
			hs.add(numbers[i]);
		}
		print(arr);
		
		int[] examples = {54, 135,114,49,174, 27};
		int[] count = new int[examples.length];
		int[] count2 = new int[examples.length];
		for(int i = 0; i < examples.length; i++){
			count[i] = LQretrieve(examples[i],arr);
			count2[i] = hs.getSize(i);
		}
		
		hs.print();
		
		print(examples);
		System.out.print("LQ retrieve: ");
		print(count);
		System.out.print("Bucket retrieve: ");
		print(count2);
		
		
		
		

	}
	
	public static void LQHashing(int pk, int k, int[] arr){
		int N = arr.length;
		int ip = pk % N;
		int q = pk/N;
		int offset;
		int prime = 19;
		if (q%N != 0)
	        offset = q;
	    else
	        offset = 19;
        while (arr[ip] != -1){
	        ip = (ip + offset) % N;
        }
//        System.out.println("ip: " + ip );
        arr[ip] = pk;
//        print(arr);
	}
	
	public static int LQretrieve(int pk, int[] arr){
		int N = arr.length;
		int ip = pk % N;
		int q = pk/N;
		int offset;
		int prime = 19;
		int count = 0;
		if (q%N != 0)
	        offset = q;
	    else
	        offset = 19;
        while (arr[ip] != pk && arr[ip] != -1){
	        ip = (ip + offset) % N;
	        count += 1;
        }
//        System.out.println("pk: " + pk +"--> count: " + count);
//        print(arr);
        return count;
	}
	
	public static void print(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	

}
