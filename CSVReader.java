/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.file;

import java.io.*;
import tracker.objects.*;
import java.util.*;
/*import canadian.payroll.*;
import tracker.Utility;*/


public class CSVReader {
	
	//Converts a CSV file into its Hastable equivalent
	public static Map<Integer, Person> parsePersons( String fileName, String addressFile ) {
		
		String line = "", splitChar = ",";
		Map<Integer, Person> persons = new Hashtable<>();
		Map<Integer, Address> addresses = parseAddresses( addressFile );
		try {
			FileReader file = new FileReader( fileName );
			BufferedReader reader = new BufferedReader( file );
			line = reader.readLine();
			while( line != null ) {
				
				//Retrieving and spliting each line into its respective fields
				String [] tokens = line.split( splitChar );
				String identity = tokens[0].trim(),
					name = tokens[1].trim(),
					age = tokens[2].trim(),
					sex = tokens[3].trim(),
					status = tokens[4].trim(),
					latitude = tokens[5].trim(),
					longitude = tokens[6].trim(),
					address_id = tokens[7].trim(); //foreign key

					List<Address> address = new ArrayList<>();
					address.add(addresses.get(Integer.parseInt(address_id)));
					Person person = new Person( Integer.parseInt( identity ), 
						name, Double.parseDouble(age), getSex(sex), getStatus(status), 
						address, new Location( Double.parseDouble(longitude), Double.parseDouble(latitude) ) );

				persons.put( person.getIdentity(), person );
				line = reader.readLine();
			}
		} catch( Exception ex ) {
			System.out.println(ex);
		}
		return persons;
	}

	//Converts a CSV file into its Hastable equivalent
	public static Map<Integer, Address> parseAddresses( String fileName ) {
		
		String line = "", splitChar = ",";
		Map<Integer, Address> addresses = new Hashtable<>();
		try {
			FileReader file = new FileReader( fileName );
			BufferedReader reader = new BufferedReader( file );
			line = reader.readLine();
			while( line != null ) {
				
				//Retrieving and spliting each line into its respective fields
				line = line.replace( '\"', '\0' );
				String [] tokens = line.split( splitChar );
				String address_id = tokens[0].trim(),
					streetName = tokens[2].trim(),
					city = tokens[3].trim(),
					country = tokens[5].trim(),
					addressType = tokens[6].trim();

					String [] temp = tokens[1].split( "-" );
					int houseNumber = 0, streetNumber = 0;
					if( temp.length > 1 ) {
						houseNumber = Integer.parseInt( temp[0].trim() );
						streetNumber = Integer.parseInt( temp[1].trim() );
					} else {
						streetNumber = Integer.parseInt( temp[0].trim() );
					}

					temp = tokens[4].trim().split(" ");
					String province = temp[0].trim(),
					postalCode = temp[1].trim() + " " + temp[2].trim();

					Address address;
					if( houseNumber == 0 ) {
						address = new Address(streetNumber, streetName, postalCode, city, province, getAddressType( addressType ), country );
					} else {
						address = new Address(houseNumber, streetNumber, streetName, postalCode, city, province, getAddressType( addressType ), country );
					}
					addresses.put( Integer.parseInt( address_id ), address );
				line = reader.readLine();
			}
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
		return addresses;
	}

	private static Address.Type getAddressType( String type ) {
		
		type = type.toUpperCase();
		switch( type ) {
			case "OFFICE" : 
				return Address.Type.OFFICE;
			case "BUSINESS" : 
				return Address.Type.BUSINESS;
			default : 
				return Address.Type.HOME;
		}
	}

	private static Person.Sex getSex( String type ) {
		
		type = type.toUpperCase();
		switch( type ) {
			case "MALE" : 
				return Person.Sex.MALE;
			case "FEMALE" : 
				return Person.Sex.FEMALE;
			default : 
				return Person.Sex.UNKNOWN;
		}
	}

	private static Person.Status getStatus( String type ) {
		
		type = type.toUpperCase();
		switch( type ) {
			case "POSITIVE" : 
				return Person.Status.POSITIVE;
			case "NEGATIVE" : 
				return Person.Status.NEGATIVE;
			case "SYMPTOMATIC" : 
				return Person.Status.SYMPTOMATIC;
			case "ASYMPTOMATIC" : 
				return Person.Status.ASYMPTOMATIC;
			default : 
				return Person.Status.UNKNOWN;
		}
	}
}