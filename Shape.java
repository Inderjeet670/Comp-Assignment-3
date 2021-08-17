/*Code Authored by:
***Dr. Opeyemi Olusegun Adesina
***School of Computing, University of the Fraser Valley, Abbotsford - Canada
***All rights reserved - For reuse purposes, please contact Dr. Adesina at [opeyemi.adesina@ufv.ca]
**/

package tracker.shapes;

import tracker.objects.*;

public abstract class Shape {
	
	private Location centrePoint;
	
	//default constructor
	public Shape() {
		centrePoint = new Location( 0.0, 0.0 );
	}
	
	//parameterized constructor
	public Shape( Location centrePoint ) {
		this.centrePoint = centrePoint;
	}
	
	public void setCentrePoint( Location location ) {
		centrePoint = location;
	}
	
	public Location getCentrePoint() {
		return centrePoint;
	}
	
	//abstract method definitions
	abstract double area();
	abstract double perimeter();
	abstract Rectangle getBoundingRectangle();
}