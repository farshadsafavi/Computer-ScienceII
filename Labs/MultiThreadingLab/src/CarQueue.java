import java.util.PriorityQueue;
import java.util.Random;

public class CarQueue {
	Random random = new Random();
	PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	private int out;
	
	public CarQueue(){
		for(int i = 0; i < 6; i++){
			System.out.println(random.nextInt(4));
			q.add(random.nextInt(4));
		}
	}
	
	
   public void addToQueue() {
	   new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					q.add(random.nextInt(4));
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}).start();
   }
   
   public int deleteQueue() {
	   new Thread(new Runnable(){
			@Override
			public void run(){
				try {
                     Thread.sleep(500);
                 } catch (InterruptedException e) {
                	 e.printStackTrace();
                 }
				if(q.size() < 20){
					for(int i = 0; i < 10; i++){
						q.add(random.nextInt(4));
					}
				}else if (!q.isEmpty()){
					out = q.remove();
				}
			}
			
		}).start();
		return out;
	}

}
