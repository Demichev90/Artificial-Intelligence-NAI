import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Knn {

	public static void main(String[] args) {
		String fileName = "iris.csv";


		System.out.println("\nRead CSV file:");
		List<Point> points = CSVFileReader.readCsvFile(fileName);

		//Print the points list
		for (Point point : points) {
			System.out.println(point.toString());
		}

		//reading from console coordinates for new point
		System.out.println("Enter 1st coordinate for your point");
		//Scanner creation for reading from console
		Scanner sc = new Scanner(System.in);
		float x = sc.nextFloat();
		System.out.println("Enter 2nd coordinate for your point");
		float y = sc.nextFloat();
		System.out.println("Enter 3rd coordinate for your point");
		float z = sc.nextFloat();
		System.out.println("Enter 4th coordinate for your point");
		float q = sc.nextFloat();
		
		//Getting "k" for classifier (How many items we count for classifying)
		System.out.println("PLEASE Specify number of neighbors");
		int k = sc.nextInt();
		sc.close();

		//Create a new point
		Point yourPoint = new Point(x,y,z,q);
		System.out.println(yourPoint);

		//Setting distances from your point to other
		setDistances(yourPoint, points);
		
		//Sorting our List of points
		Collections.sort(points, Point.pointOrderer);
		//System.out.println(points);
		
		
		System.out.println(classify(points, k));
		
		
	}

	// ADDITIONAL METHODS
	
	//Classifying yourPoint (Flower)
	public static String classify(List<Point> pointsList, int k ){
		int virginica = 0;
		int versicolor = 0;
		int setosa = 0;
		String answer = null;
		for(int i = 0; i < k; i++){
			if(pointsList.get(i).getLabel().equals("Iris-setosa")){
				setosa++;
			}
			if(pointsList.get(i).getLabel().equals("Iris-versicolor")){
				versicolor++;
			}else{
				virginica++;
			}
			if (virginica > versicolor && virginica > setosa) {
			    answer = "Iris-virginica";
			}

			if (versicolor > virginica && versicolor > setosa) {
				answer = "Iris-versicolor";
			}    

			if (setosa > versicolor && setosa > virginica) {
				answer = "Iris-setosa";
			}
			if (setosa == versicolor){
				answer = "Iris-setosa or Iris-Versicolor";
			}
			if (setosa == virginica){
				answer = "Iris-setosa or Iris-Virginica";
			}
			if (versicolor == virginica){
				answer = "Iris-Versicolor or Iris-Virginica";
			}
			
		}
		
		return answer;
		
	}
	//Point to Point Distance Calculation
	public static float getDistance(Point my, Point fromList){

		return (float) Math.sqrt(Math.pow((fromList.x-my.x), 2) + Math.pow((fromList.y-my.y), 2) + Math.pow((fromList.z-my.z), 2) + Math.pow((fromList.q-my.q), 2));
	}
	
	//Distance setter for points
	public static void setDistances(Point my, List<Point> pointList){
		for(int i = 0; i < pointList.size(); i++){
			pointList.get(i).distanceToPoint = getDistance(my, pointList.get(i));
		}
	}
	
	//Distance to zero
	public static void delDistances(Point my, List<Point> pointList){
		for(int i = 0; i < pointList.size(); i++){
			pointList.get(i).distanceToPoint = 0;
		}
	}
}


