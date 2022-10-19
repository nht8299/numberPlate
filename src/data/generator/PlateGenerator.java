package data.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
public class PlateGenerator {
	
	 public static List<String> generatePlate(){
	        List<Integer>plateNumberIndex = Arrays.asList(0,1,3,5,6,7,9,10);
	        ArrayList<String> plate = new ArrayList<>();
	        for (int i = 0;i < 11; i++ ){
	            if ( plateNumberIndex.contains(i)){
	                plate.add(generateNumber());
	            }
	            else if ( i == 2 ){
	                plate.add(i,generateString());
	            }
	            else if ( i == 4 ){
	                plate.add("-");
	            }
	            else if ( i == 8 ){
	                plate.add(".");
	            }
	        }
	        return plate;

	    }
	    public static String generateNumber(){
	        return RandomStringUtils.randomNumeric(1);
	    }
	    public static String generateString(){
	        return RandomStringUtils.randomAlphabetic(1).toUpperCase();
	    }
}
