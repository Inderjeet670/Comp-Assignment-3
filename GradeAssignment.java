/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/
package tracker.test;

public class GradeAssignment {
	
	private static double points( int index ) {
		
		//returns approriate grade points based on the test index
		switch( index ) {
			case 0 : return 1;
			case 1 : return 1;
			case 2 : return 1;
			case 3 : return 15;
			case 4 : return 7;
			case 5 : return 25;
			case 6 : return 30;
			default: return 0;
		}
	}

	//this method computes students grade for this lab...
	public static void grade( boolean [] test ) {
		
		boolean flag = true;
		double totalPoints = 0;
		double overallPoints = 0;
		for( int i = 0; i < test.length; i++ ) {
			double points = Math.round( points( i ) * 100.0 ) / 100.0;
			double x = points( i );
			if(test[i] == true ) {
				System.out.println("Test "+ i +" (Q"+(i+1)+") passed. [Alloted point(s): "+points+"]");
				totalPoints += x;
			} else {
				System.out.println("Test "+ i +" (Q"+(i+1)+") failed. [Alloted point(s): "+points+"]");
				flag = false;
			}
			overallPoints += x;
		}
		
		if( flag ) {
			System.out.println("All tests are successful.");
		} else {
			System.out.println("Not all tests are successful.");
		}
		System.out.println("Total points earned in this lab: ["+  Math.round( totalPoints * 100.0) / 100.0 +"/"+overallPoints +"] points.");
	}
}