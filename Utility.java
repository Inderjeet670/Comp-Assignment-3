package tracker;

import java.util.*;
import tracker.objects.*;
import tracker.file.*;
import tracker.objects.Person;

public class Utility {
	
	public static String formatProvince( String provinceOrFederal ) {
			
		provinceOrFederal = provinceOrFederal.toLowerCase();
		//System.out.println(provinceOrFederal);
		if( provinceOrFederal.equals( "ontario" ) || provinceOrFederal.equals( "on" ) ) {
			return "ON";
		} else if( provinceOrFederal.equals( "Manitoba" ) || provinceOrFederal.equals( "mb" ) ) {
			return "MB";
		} else if( provinceOrFederal.equals( "british columbia" ) || provinceOrFederal.equals( "bc" ) ) {
			return "BC";
		} else if( provinceOrFederal.equals( "new brunswick" ) || provinceOrFederal.equals( "nb" ) ) {
			return "NB";
		} else if( provinceOrFederal.equals( "alberta" ) || provinceOrFederal.equals( "ab" ) ) {
			return "AB";
		} else if( provinceOrFederal.equals( "saskatchewan" ) || provinceOrFederal.equals( "sk" ) ) {
			return "SK";
		} else if( provinceOrFederal.equals( "nova scotia" ) || provinceOrFederal.equals( "ns" ) ) {
			return "NS";
		} else {
			return "federal";
		}
	}
	
	public static void display( Map<? extends Object, ? extends Object > map ) {

		//INSERT YOUR CODE HERE...
		for (Map.Entry<? extends Object, ? extends Object> entry : map.entrySet()) {//loops over the hashmap and prints the items.
			System.out.println(entry);
		}
	}
	public static Map<Integer, Person> initiate() {
		
		String test_db = "./data/test_db.csv";
		String address_db = "./data/addresses_db.csv";
		Map<Integer, Person> persons = CSVReader.parsePersons( test_db, address_db );

		return persons;
	}
}