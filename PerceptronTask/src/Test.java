import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		
		
		//creating 2 arrays of doubles with 100 length
		double[] arrayX1 = new double[100];
		double[] arrayX2 = new double[100];
		
		//adding numbers to our arrays (numbers are from -10 to 10
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			arrayX1[i] = 10 + rand.nextDouble() - rand.nextInt(21);
			arrayX2[i] = 10 + rand.nextDouble() - rand.nextInt(21);
		}
		
		//generating random threshold
		double gentresh = new Random().nextDouble();
		System.out.println("Generated threshold " + gentresh);
		//creating object of a class Perceptron with our generated threshold
		Perceptron prec = new Perceptron(gentresh);
		//training
		prec.train(arrayX1, arrayX2);
		//testing
		test(prec);
		//additional testing with points added by user
		testwithyourpoints(prec);
		
		}
		
	
	public static void test(Perceptron perc){
		//creating randomizer 
		Random rand = new Random();
		
		//error counter
		int errorCount = 0;
		
		//accuracy counter
		int accuracy = 0;
		
		//actual output for each step
		int actOut = 0;
		
		//generating new 20 points (from -10 to 10)
		for(int i = 0; i < 20;i++){
			double x1 = 10 + rand.nextDouble() - rand.nextInt(21); 
			double x2 = 10 + rand.nextDouble() - rand.nextInt(21); 
			//if sum of coordinates is bigger then our threshold then particular point is from class -1 and vice versa
			if((x1+x2) >= perc.treshold){
				actOut =  -1;
			}else{
				actOut = 1;
			}
			
			//if our predicted and current output differs - counting an error
			if(actOut != perc.calcOutput(x1, x2)){
				errorCount++;
			}
			System.out.println(actOut + " " + perc.calcOutput(x1, x2));
			
		}
		//counting accuracy
		accuracy = 100 - errorCount*100 / 20;
		System.out.println(accuracy);
	}
	
	public static void testwithyourpoints(Perceptron prec){
		while (true) {
			try {
				//creating reader for read input
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				System.out.println("Enter numbers with space");
				//reading input
				String s = br.readLine();
				//splitting read by space for getting 2 numbers a and b
				String sarr[] = s.split(" ");
				int a = Integer.parseInt(sarr[0]);
				int b = Integer.parseInt(sarr[1]);
				System.out.println("Class of the point: " + prec.calcOutput((double)a, (double)b));
				
			} catch (NumberFormatException nfe) {
				System.err.println("Invalid Format!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}}
