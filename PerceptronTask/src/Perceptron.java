
public class Perceptron {
	
	private static double learnRate = 0.1;
	static double treshold = 3;
	private static double[] weights = new double[2];
	static double tresholdPerc;
	private static int count = 0;
	
	//Constructor with threshold
	public Perceptron(double tresholdPerc){
		this.tresholdPerc = tresholdPerc;
	}
	
	//Simple perceptron output calculation (using formula or perceptron)
	public static int calcOutput(double x1, double x2) {
		if (((x1 * weights[0]) + (x2 * weights[1]) - tresholdPerc) < 0)
			return -1;
		else
			return 1;
	}

	public static void train(double arrayX1[], double arrayX2[]) {
		boolean isError = true;
		//We train our perceptron before 100 percents accuracy
		while (isError) {
			//counting loops
			count++;
			isError = false;
			for (int i = 0; i < arrayX1.length; i++) {
				//calculating output for each case 
				int output = calcOutput(arrayX1[i], arrayX2[i]);
				//calculating output for new threshold
				int actualOutput = (arrayX1[i] + arrayX2[i] >= treshold) ? -1 : 1;
				// calculating error between our predicted(that we know for sure) output and current output
				int error = actualOutput - output;
				//if there is an error we will reenter the loop for training
				if(error != 0){
					isError = true;
				}
				//and if there was an error we are changing weights and threshold
				//we are using formula for correcting weights
					weights[0] += learnRate * error * arrayX1[i];
					weights[1] += learnRate * error * arrayX2[i];
					System.out.println(weights[0] + " " + weights[1]);
					tresholdPerc += learnRate * error * (-0.1);
					System.out.println(tresholdPerc);
				
			}
			
		}
		System.out.println("Iterations done before 100 accuracy - " + count);
	}
	
}
