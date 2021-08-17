/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

import tracker.test.QualityAssurance;
import tracker.test.GradeAssignment;
import tracker.objects.Location;
import tracker.shapes.*;
import tracker.objects.Address;
import tracker.objects.Person;
import java.util.*;
import tracker.file.CSVReader;
import tracker.Utility;

class Tracker {
	
	public static void main( String [] args ) {
		
		Map<Integer, Person> persons = Utility.initiate();
		Person person = persons.get( 245679 );
		Map<Integer, Person> neighbours = person.getNeighbours( 10, persons );
		System.out.println("The neighbours of ... \n["+person+"] when operational-radius = 10.0 are as follow:\n");
		Utility.display( neighbours );

		boolean[] test = QualityAssurance.test();
		GradeAssignment.grade( test );
	}
}