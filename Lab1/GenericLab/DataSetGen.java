

public class DataSetGen<T extends Measurable> {
	private double sum;
    private T maximum;
    private int count;

    /**
      Constructs an empty data set.
    */
    public DataSetGen(){
      sum = 0;
      count = 0;
      maximum = null;
	}

	public void add(T t) {
		sum = sum + t.getMeasure();
		if (count == 0 || maximum.getMeasure() < t.getMeasure())
			maximum = t;
		count++;
		
	}

	public T getMaximum() {
		return maximum;
	}

	public double getAverage() {
		 if (count == 0) return 0;
	     else return (sum / count);
	}

}
