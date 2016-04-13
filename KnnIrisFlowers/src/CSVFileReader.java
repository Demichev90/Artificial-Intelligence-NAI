import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ashraf_sarhan
 *
 */
public class CSVFileReader {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	
	//Student attributes index
	private static final int POINT_X_IDX = 0;
	private static final int POINT_Y_IDX = 1;
	private static final int POINT_Z_IDX = 2;
	private static final int POINT_Q_IDX = 3; 
	private static final int LABEL = 4;
	
	public static List<Point> readCsvFile(String fileName) {

		BufferedReader fileReader = null;
		List<Point> points = new ArrayList<Point>();	
        try {
        	
        	//Create a new list of student to be filled by CSV file data 
        	
        	
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));
            
            //Read the CSV file header to skip it
            fileReader.readLine();
            
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                
            	//Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                	//Create a new student object and fill his  data
					Point point = new Point(Float.parseFloat(tokens[POINT_X_IDX]), Float.parseFloat(tokens[POINT_Y_IDX]), Float.parseFloat(tokens[POINT_Z_IDX]), Float.parseFloat(tokens[POINT_Q_IDX]), (tokens[LABEL]));
					points.add(point);
				}
            }
            
            //Print the new points list
            
//            for (Point point : points) {
//				System.out.println(point.toString());
//			}
        } 
        catch (Exception e) {
        	System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return points;

	}

}